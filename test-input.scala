// test -- this can be run from the repl

val folder = sys.env("DELITE_PLAY") + "/data/"
// val file = folder + "tpch_2_17_0/dbgen/lineitem.tbl"
val file_part = folder + "part.tbl"
val file_supplier = folder + "supplier.tbl"
val file_partsupp = folder + "partsupp.tbl"
val file_customer = folder + "customer.tbl"
val file_orders = folder + "orders.tbl"
val file_lineitem = folder + "lineitem.tbl"
val file_nation = folder + "nation.tbl"
val file_region = folder + "region.tbl"

import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._

val schema_part = StructType(Seq(
  StructField("p_partkey", IntegerType, true),
  StructField("p_name", StringType, true),
  StructField("p_mfgr", StringType, true),
  StructField("p_brand", StringType, true),
  StructField("p_type", StringType, true),
  StructField("p_size", IntegerType, true),
  StructField("p_container", StringType, true),
  StructField("p_retailprice", DoubleType, true),
  StructField("p_comment", StringType, true)))

val schema_supplier = StructType(Seq(
  StructField("s_suppkey", IntegerType, true),
  StructField("s_name", StringType, true),
  StructField("s_address", StringType, true),
  StructField("s_nationkey", IntegerType, true),
  StructField("s_phone", StringType, true),
  StructField("s_acctbal", DoubleType, true),
  StructField("s_comment", StringType, true)))

val schema_partsupp = StructType(Seq(
  StructField("ps_partkey", IntegerType, true),
  StructField("ps_suppkey", IntegerType, true),
  StructField("ps_availqty", IntegerType, true),
  StructField("ps_supplycost", DoubleType, true),
  StructField("ps_comment", StringType, true)))

val schema_customer = StructType(Seq(
  StructField("c_custkey", IntegerType, true),
  StructField("c_name", StringType, true),
  StructField("c_address", StringType, true),
  StructField("c_nationkey", IntegerType, true),
  StructField("c_phone", StringType, true),
  StructField("c_acctbal", DoubleType, true),
  StructField("c_mktsegment", StringType, true),
  StructField("c_comment", StringType, true)))

val schema_orders = StructType(Seq(
  StructField("o_orderkey", IntegerType, true),
  StructField("o_custkey", IntegerType, true),
  StructField("o_orderstatus", StringType, true),
  StructField("o_totalprice", DoubleType, true),
  StructField("o_orderdate", DateType, true),
  StructField("o_orderpriority", StringType, true),
  StructField("o_clerk", StringType, true),
  StructField("o_shippriority", IntegerType, true),
  StructField("o_comment", StringType, true)))

val schema_lineitem = StructType(Seq(
  StructField("l_orderkey", IntegerType, true),
  StructField("l_partkey", IntegerType, true),
  StructField("l_suppkey", IntegerType, true),
  StructField("l_linenumber", IntegerType, true),
  StructField("l_quantity", DoubleType, true),
  StructField("l_extendedprice", DoubleType, true),
  StructField("l_discount", DoubleType, true),
  StructField("l_tax", DoubleType, true),
  StructField("l_returnflag", StringType, true), // Char
  StructField("l_linestatus", StringType, true),
  StructField("l_shipdate", DateType, true),
  StructField("l_commitdate", DateType, true),
  StructField("l_receiptdate", DateType, true),
  StructField("l_shipinstruct", StringType, true),
  StructField("l_shipmode", StringType, true),
  StructField("l_comment", StringType, true)))

val schema_nation = StructType(Seq(
  StructField("n_nationkey", IntegerType, true),
  StructField("n_name", StringType, true),
  StructField("n_regionkey", IntegerType, true),
  StructField("n_comment", StringType, true)))

val schema_region = StructType(Seq(
  StructField("r_regionkey", IntegerType, true),
  StructField("r_name", StringType, true),
  StructField("r_comment", StringType, true)))

import org.apache.spark.sql.catalyst.plans.logical._
import org.apache.spark.sql.catalyst.plans._
import org.apache.spark.sql.execution.datasources.LogicalRelation
import org.apache.spark.sql.sources.BaseRelation
import org.apache.spark.sql.DataFrame
import com.databricks.spark.csv.CsvRelation
import org.apache.spark.sql.catalyst.expressions._
import org.apache.spark.sql.catalyst.expressions.aggregate._

import optiql.compiler._
import optiql.library._
import optiql.shared._
import scala.reflect.{Manifest,SourceContext,ManifestFactory,RefinedManifest}
import scala.virtualization.lms.common.{Record, TupleOps}
import scala.math.Ordering
import playground._
import java.util.{Date, Calendar}
import java.text._

def deliteSQL(s: String) = Run.runDelite(sqlContext.sql(s).queryExecution.optimizedPlan, false)

// Tables
val customer = (sqlContext.read
  .format("com.databricks.spark.csv")
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_customer)
  .load(file_customer))

val orders = (sqlContext.read
  .format("com.databricks.spark.csv")
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_orders)
  .load(file_orders))

val lineitem = (sqlContext.read
  .format("com.databricks.spark.csv")
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_lineitem)
  .load(file_lineitem))

val part = (sqlContext.read
  .format("com.databricks.spark.csv")
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_part)
  .load(file_part))

val supplier = (sqlContext.read
  .format("com.databricks.spark.csv")
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_supplier)
  .load(file_supplier))

val partsupp = (sqlContext.read
  .format("com.databricks.spark.csv")
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_partsupp)
  .load(file_partsupp))

val nation = (sqlContext.read
  .format("com.databricks.spark.csv")
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_nation)
  .load(file_nation))

val region = (sqlContext.read
  .format("com.databricks.spark.csv")
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_region)
  .load(file_region))

customer.registerTempTable("customer")
orders.registerTempTable("orders")
lineitem.registerTempTable("lineitem")
part.registerTempTable("part")
supplier.registerTempTable("supplier")
partsupp.registerTempTable("partsupp")
nation.registerTempTable("nation")
region.registerTempTable("region")


// TPCH - 1
val tpch1 =
  """select
    | l_returnflag,
    | l_linestatus,
    | sum(l_quantity) as sum_qty,
    | sum(l_extendedprice) as sum_base_price,
    | sum(l_extendedprice * (1 - l_discount)) as sum_disc_price,
    | sum(l_extendedprice * (1 - l_discount) * (1 + l_tax)) as sum_charge,
    | avg(l_quantity) as avg_qty,
    | avg(l_extendedprice) as avg_price,
    | avg(l_discount) as avg_disc,
    | count(*) as count_order
    |from
    | lineitem
    |where
    | l_shipdate <= to_date('1998-09-02')
    |group by
    | l_returnflag,
    | l_linestatus
    |order by
    | l_returnflag,
    | l_linestatus""".stripMargin

// TPCH - 2
val tpch2 =
  """select
    | s_acctbal,
    | s_name,
    | n_name,
    | p_partkey,
    | p_mfgr,
    | s_address,
    | s_phone,
    | s_comment
    |from
    | part,
    | supplier,
    | partsupp,
    | nation,
    | region
    |where
    | p_partkey = ps_partkey
    | and s_suppkey = ps_suppkey
    | and p_size = 15
    | and p_type like '%BRASS'
    | and s_nationkey = n_nationkey
    | and n_regionkey = r_regionkey
    | and r_name = 'EUROPE'
    | and ps_supplycost = (
    |   select
    |     min(ps_supplycost)
    |   from
    |     partsupp, supplier,
    |     nation, region
    |   where
    |     p_partkey = ps_partkey
    |     and s_suppkey = ps_suppkey
    |     and s_nationkey = n_nationkey
    |     and n_regionkey = r_regionkey
    |     and r_name = 'EUROPE'
    |   )
    |order by
    | s_acctbal desc,
    | n_name,
    | s_name,
    | p_partkey""".stripMargin

val tpch2nosub =
  """select
    |        s_acctbal,
    |        s_name,
    |        n_name,
    |        p_partkey,
    |        p_mfgr,
    |        s_address,
    |        s_phone,
    |        s_comment
    |from
    |        part,
    |        supplier,
    |        partsupp,
    |        nation,
    |        region,
    |        (select ps_partkey as t_ps_partkey, min(ps_supplycost) as t_min_ps_supplycost
    |        from part, partsupp, supplier, nation, region
    |        where p_partkey = ps_partkey
    |              and s_suppkey = ps_suppkey
    |              and s_nationkey = n_nationkey
    |              and n_regionkey = r_regionkey
    |              and r_name = 'EUROPE'
    |              and p_size = 15
    |              and p_type like '%BRASS'
    |        group by ps_partkey
    |        ) as T
    |where
    |        p_partkey = ps_partkey
    |        and s_suppkey = ps_suppkey
    |        and p_size = 15
    |        and p_type like '%BRASS'
    |        and s_nationkey = n_nationkey
    |        and n_regionkey = r_regionkey
    |        and r_name = 'EUROPE'
    |        and p_partkey = t_ps_partkey
    |        and ps_supplycost = t_min_ps_supplycost
    |order by
    |        s_acctbal desc,
    |        n_name,
    |        s_name,
    |        p_partkey
    |limit 100""".stripMargin

// TPCH - 3
val tpch3 =
  """select
    | l_orderkey,
    | sum(l_extendedprice*(1-l_discount)) as revenue,
    | o_orderdate,
    | o_shippriority
    |from
    | customer,
    | orders,
    | lineitem
    |where
    | c_mktsegment = 'BUILDING'
    | and c_custkey = o_custkey
    | and l_orderkey = o_orderkey
    | and o_orderdate < to_date('1995-03-15')
    | and l_shipdate > to_date('1995-03-15')
    |group by
    | l_orderkey,
    | o_orderdate,
    | o_shippriority
    |order by
    | revenue desc,
    | o_orderdate""".stripMargin

// TPCH - 4
val tpch4 =
    """select
      | o_orderpriority,
      | count(*) as order_count
      |from
      | orders
      |where
      | exists (
      |   select
      |     *
      |   from
      |     lineitem
      |   where
      |     lineitem.l_orderkey = orders.o_orderkey
      |     and lineitem.l_commitdate < lineitem.l_receiptdate
      | )
      |group by
      | o_orderpriority
      |order by
      | o_orderpriority""".stripMargin

val tpch4nosub =
    """select
      | o_orderpriority,
      | count(*) as order_count
      |from
      | orders join (
      |   select
      |     distinct l_orderkey
      |   from
      |     lineitem
      |   where
      |     lineitem.l_commitdate < lineitem.l_receiptdate
      | ) as L
      |on
      | L.l_orderkey = o_orderkey
      |where
      | o_orderdate >= to_date('1993-07-01')
      | and o_orderdate < to_date('1993-10-01')
      |group by
      | o_orderpriority
      |order by
      | o_orderpriority""".stripMargin

// TPCH - 5
val tpch5 =
  """select
    | n_name,
    | sum(l_extendedprice * (1 - l_discount)) as revenue
    |from
    | customer,
    | orders,
    | lineitem,
    | supplier,
    | nation,
    | region
    |where
    | c_custkey = o_custkey
    | and l_orderkey = o_orderkey
    | and c_nationkey = s_nationkey
    | and s_nationkey = n_nationkey
    | and n_regionkey = r_regionkey
    | and l_suppkey = s_suppkey
    | and r_name = 'ASIA'
    | and o_orderdate >= to_date('1994-01-01')
    | and o_orderdate < to_date('1995-01-01')
    |group by
    | n_name
    |order by
    | revenue desc""".stripMargin

// TPCH - 6
// val tpch6res = lineitem.where(lineitem("l_shipdate") >= to_date(lit("1994-01-01")) && lineitem("l_shipdate") < to_date(lit("1995-01-01")) && lineitem("l_discount") >= 0.05 && lineitem("l_discount") <= 0.07 && lineitem("l_quantity") < 24).agg(sum(lineitem("l_extendedprice") * lineitem("l_discount")) as ("revenue"))
val tpch6 =
  """select
    | sum(l_extendedprice*l_discount) as revenue
    |from
    | lineitem
    |where
    | l_shipdate >= to_date('1994-01-01')
    | and l_shipdate < to_date('1995-01-01')
    | and l_discount between 0.05 and 0.07
    | and l_quantity < 24""".stripMargin

// TPCH - 7
val tpch7 =
  """select
    | supp_nation,
    | cust_nation,
    | l_year,
    | sum(volume) as revenue
    |from (
    | select
    |   n1.n_name as supp_nation,
    |   n2.n_name as cust_nation,
    |   year(l_shipdate) as l_year,
    |   l_extendedprice * (1 - l_discount) as volume
    | from
    |   supplier,
    |   lineitem,
    |   orders,
    |   customer,
    |   nation n1,
    |   nation n2
    | where
    |   s_suppkey = l_suppkey
    |   and o_orderkey = l_orderkey
    |   and c_custkey = o_custkey
    |   and s_nationkey = n1.n_nationkey
    |   and c_nationkey = n2.n_nationkey
    |   and (
    |     (n1.n_name = 'FRANCE' and n2.n_name = 'GERMANY')
    |     or (n1.n_name = 'GERMANY' and n2.n_name = 'FRANCE')
    |   )
    |   and l_shipdate between to_date('1995-01-01') and to_date('1996-12-31')
    | ) as shipping
    |group by
    | supp_nation,
    | cust_nation,
    | l_year
    |order by
    | supp_nation,
    | cust_nation,
    | l_year""".stripMargin

// TPCH - 8
val tpch8 =
  """select
    | o_year,
    | sum(case
    |   when all_nations.nation = 'BRAZIL'
    |   then volume
    |   else 0
    | end) / sum(volume) as mkt_share
    |from (
    | select
    |   year(o_orderdate) as o_year,
    |   l_extendedprice * (1-l_discount) as volume,
    |   n2.n_name as nation
    | from
    |   part,
    |   supplier,
    |   lineitem,
    |   orders,
    |   customer,
    |   nation n1,
    |   nation n2,
    |   region
    | where
    |   p_partkey = l_partkey
    |   and s_suppkey = l_suppkey
    |   and l_orderkey = o_orderkey
    |   and o_custkey = c_custkey
    |   and c_nationkey = n1.n_nationkey
    |   and n1.n_regionkey = r_regionkey
    |   and r_name = 'AMERICA'
    |   and s_nationkey = n2.n_nationkey
    |   and o_orderdate between to_date('1995-01-01') and to_date('1996-12-31')
    |   and p_type = 'ECONOMY ANODIZED STEEL'
    | ) as all_nations
    |group by
    | o_year
    |order by
    | o_year""".stripMargin

// TPCH - 9
val tpch9 =
  """select
    | nation,
    | o_year,
    | sum(amount) as sum_profit
    |from (
    | select
    |   n_name as nation,
    |   year(o_orderdate) as o_year,
    |   l_extendedprice * (1 - l_discount) - ps_supplycost * l_quantity as amount
    | from
    |   part,
    |   supplier,
    |   lineitem,
    |   partsupp,
    |   orders,
    |   nation
    | where
    |   s_suppkey = l_suppkey
    |   and ps_suppkey = l_suppkey
    |   and ps_partkey = l_partkey
    |   and p_partkey = l_partkey
    |   and o_orderkey = l_orderkey
    |   and s_nationkey = n_nationkey
    |   and p_name like '%green%'
    | ) as profit
    |group by
    | nation,
    | o_year
    |order by
    | nation,
    | o_year desc""".stripMargin

// TPCH - 10
val tpch10 =
  """select
    | c_custkey,
    | c_name,
    | sum(l_extendedprice * (1 - l_discount)) as revenue,
    | c_acctbal,
    | n_name,
    | c_address,
    | c_phone,
    | c_comment
    |from
    | customer,
    | orders,
    | lineitem,
    | nation
    |where
    | c_custkey = o_custkey
    | and l_orderkey = o_orderkey
    | and o_orderdate >= to_date('1993-10-01')
    | and o_orderdate < to_date('1994-01-01')
    | and l_returnflag = 'R'
    | and c_nationkey = n_nationkey
    |group by
    | c_custkey,
    | c_name,
    | c_acctbal,
    | c_phone,
    | n_name,
    | c_address,
    | c_comment
    |order by
    | revenue desc""".stripMargin

val tpch11 =
  """select
    | ps_partkey,
    | sum(ps_supplycost * ps_availqty) as value
    |from
    | partsupp,
    | supplier,
    | nation
    |where
    | ps_suppkey = s_suppkey
    | and s_nationkey = n_nationkey
    | and n_name = 'GERMANY'
    |group by
    | ps_partkey having
    | sum(ps_supplycost * ps_availqty) > (
    |   select
    |     sum(ps_supplycost * ps_availqty) * 0.0001
    |   from
    |     partsupp,
    |     supplier,
    |     nation
    |   where
    |     ps_suppkey = s_suppkey
    |     and s_nationkey = n_nationkey
    |     and n_name = 'GERMANY'
    |   )
    |order by
    | value desc""".stripMargin

val tpch11nosub =
  """
    |select
    |        ps_partkey,
    |        sum(ps_supplycost * ps_availqty) as value
    |from
    |        partsupp,
    |        supplier,
    |        nation,
    |        (
    |                        select
    |                                sum(ps_supplycost * ps_availqty) * 0.0001 as V
    |                        from
    |                                partsupp,
    |                                supplier,
    |                                nation
    |                        where
    |                                ps_suppkey = s_suppkey
    |                                and s_nationkey = n_nationkey
    |                                and n_name = 'GERMANY'
    |                ) as T1
    |where
    |        ps_suppkey = s_suppkey
    |        and s_nationkey = n_nationkey
    |        and n_name = 'GERMANY'
    |group by
    |        ps_partkey having
    |                sum(ps_supplycost * ps_availqty) > max(V)
    |order by
    |        value desc
""".stripMargin

val tpch12 =
  """select
    | l_shipmode,
    | sum(case
    |   when o_orderpriority ='1-URGENT'
    |   or o_orderpriority ='2-HIGH'
    |   then 1
    | else 0
    | end) as high_line_count,
    | sum(case
    |   when o_orderpriority <> '1-URGENT'
    |   and o_orderpriority <> '2-HIGH'
    |   then 1
    | else 0
    | end) as low_line_count
    |from
    | orders,
    | lineitem
    |where
    | o_orderkey = l_orderkey
    | and l_shipmode in ('MAIL', 'SHIP')
    | and l_commitdate < l_receiptdate
    | and l_shipdate < l_commitdate
    | and l_receiptdate >= to_date('1994-01-01')
    | and l_receiptdate < to_date('1995-01-01')
    |group by
    | l_shipmode
    |order by
    | l_shipmode""".stripMargin

val tpch13 =
  """select
    | c_count, count(*) as custdist
    |from (
    |   select
    |     c_custkey,
    |     count(o_orderkey) as c_count
    |   from
    |     customer join orders on
    |     o_custkey = c_custkey
    |     and o_comment not like '%special%requests%'
    |   group by
    |     c_custkey
    |   ) as c_orders
    |group by
    | c_count
    |order by
    | custdist desc,
    | c_count desc""".stripMargin

val tpch14 =
  """select
    | 100.00 * sum(case
    |   when p_type like 'PROMO%'
    |   then l_extendedprice * (1 - l_discount)
    |   else 0
    | end) / sum(l_extendedprice * (1 - l_discount)) as promo_revenue
    |from
    | lineitem,
    | part
    |where
    | l_partkey = p_partkey
    | and l_shipdate >= to_date('1995-09-01')
    | and l_shipdate < to_date('1995-10-02')""".stripMargin

val tpch15 =
  """with revenue as (
    | select
    |   l_suppkey as supplier_no,
    |   sum(l_extendedprice * (1 - l_discount)) as total_revenue
    | from
    |   lineitem
    | where
    |   l_shipdate >= to_date('1996-01-01')
    |   and l_shipdate < to_date('1996-04-01')
    | group by
    |   l_suppkey
    |)
    |select
    | s_suppkey,
    | s_name,
    | s_address,
    | s_phone,
    | total_revenue
    |from
    | supplier,
    | revenue
    |where
    | s_suppkey = supplier_no
    | and total_revenue = (
    |  select
    |   max(total_revenue)
    |  from
    |   revenue
    | )
    |order by
    | s_suppkey""".stripMargin

val tpch15nosub =
  """with revenue as (
    |    select
    |        l_suppkey as supplier_no,
    |        sum(l_extendedprice * (1 - l_discount)) as total_revenue
    |    from
    |        lineitem
    |    where
    |        l_shipdate >= to_date('1996-01-01')
    |        and l_shipdate < to_date('1996-04-01')
    |    group by
    |        l_suppkey)
    |select
    |    s_suppkey,
    |    s_name,
    |    s_address,
    |    s_phone,
    |    total_revenue
    |from
    |    supplier,
    |    revenue,
    |     (
    |        select
    |            max(total_revenue) as total_rev
    |        from
    |            revenue
    |    )as T
    |where
    |    s_suppkey = supplier_no
    |    and total_revenue = T.total_rev
    |order by
    |    s_suppkey""".stripMargin

val tpch16 =
  """select
    | p_brand,
    | p_type,
    | p_size,
    | count(distinct ps_suppkey) as supplier_cnt
    |from
    | partsupp,
    | part
    |where
    | p_partkey = ps_partkey
    | and p_brand <> 'Brand#45'
    | and p_type not like 'MEDIUM POLISHED%'
    | and p_size in (42, 14, 23, 45, 19, 3, 36, 9)
    | and ps_suppkey not in (
    |   select
    |     s_suppkey
    |   from
    |     supplier
    |   where
    |     s_comment like '%Customer%Complaints%'
    | )
    |group by
    | p_brand,
    | p_type,
    | p_size
    |order by
    | supplier_cnt desc,
    | p_brand,
    | p_type,
    | p_size""".stripMargin

val tpch16nosub =
  """select
    | p_brand,
    | p_type,
    | p_size,
    | count(distinct ps_suppkey) as supplier_cnt
    |from
    | partsupp,
    | part,
    | supplier
    |where
    | p_partkey = ps_partkey
    | and p_brand <> 'Brand#45'
    | and p_type not like 'MEDIUM POLISHED%'
    | and p_size in (49, 14, 23, 45, 19, 3, 36, 9)
    | and ps_suppkey = s_suppkey
    | and s_comment not like '%Customer%Complaints%'
    |group by
    | p_brand,
    | p_type,
    | p_size
    |order by
    | supplier_cnt desc,
    | p_brand,
    | p_type,
    | p_size""".stripMargin

val tpch17 =
  """select
    | sum(l_extendedprice) / 7.0 as avg_yearly
    |from
    | lineitem,
    | part
    |where
    | p_partkey = l_partkey
    | and p_brand = 'Brand#23'
    | and p_container = 'MED BOX'
    | and l_quantity < (
    |   select
    |     avg(0.2 * l_quantity)
    |   from
    |     lineitem
    |   where
    |     l_partkey = p_partkey
    | )""".stripMargin

val tpch17nosub =
  """select
    |        sum(l_extendedprice) / 7.0 as avg_yearly
    |from
    |        lineitem,
    |        part,
    |        (select l_partkey as t_l_partkey, 0.2 * avg(l_quantity) as avg_l_quantity
    |         from lineitem, part
    |         where l_partkey = p_partkey
    |         group by l_partkey
    |        ) as T
    |where
    |        p_partkey = l_partkey
    |        and p_partkey = T.t_l_partkey
    |        and p_brand = 'Brand#23'
    |        and p_container = 'MED BOX'
    |        and l_quantity < T.avg_l_quantity""".stripMargin


val tpch18 =
  """select
    | c_name,
    | c_custkey,
    | o_orderkey,
    | o_orderdate,
    | o_totalprice,
    | sum(l_quantity)
    |from
    | customer,
    | orders,
    | lineitem
    |where
    | o_orderkey in (
    |   select
    |     l_orderkey
    |   from
    |     lineitem
    |   group by
    |     l_orderkey having
    |     sum(l_quantity) > 300
    | )
    | and c_custkey = o_custkey
    | and o_orderkey = l_orderkey
    |group by
    | c_name,
    | c_custkey,
    | o_orderkey,
    | o_orderdate,
    | o_totalprice
    |order by
    | o_totalprice desc,
    | o_orderdate""".stripMargin

val tpch18nosub =
  """select
    | c_name,
    | c_custkey,
    | o_orderkey,
    | o_orderdate,
    | o_totalprice,
    | sum(l_quantity)
    |from
    | customer,
    | orders,
    | lineitem
    |where
    | c_custkey = o_custkey
    | and o_orderkey = l_orderkey
    |group by
    | c_name,
    | c_custkey,
    | o_orderkey,
    | o_orderdate,
    | o_totalprice
    |having
    | sum(l_quantity) > 300
    |order by
    | o_totalprice desc,
    | o_orderdate
    |limit 100""".stripMargin

val tpch19 =
  """select
    | sum(l_extendedprice * (1 - l_discount) ) as revenue
    |from
    | lineitem,
    |part
    | where
    | (
    |   p_partkey = l_partkey
    |   and p_brand = 'Brand#12'
    |   and p_container in ( 'SM CASE', 'SM BOX', 'SM PACK', 'SM PKG')
    |   and l_quantity >= 1 and l_quantity <= 11
    |   and p_size between 1 and 5
    |   and l_shipmode in ('AIR', 'AIR REG')
    |   and l_shipinstruct = 'DELIVER IN PERSON'
    | )
    | or
    | (
    |   p_partkey = l_partkey
    |   and p_brand = 'Brand#23'
    |   and p_container in ('MED BAG', 'MED BOX', 'MED PKG', 'MED PACK')
    |   and l_quantity >= 10 and l_quantity <= 20
    |   and p_size between 1 and 10
    |   and l_shipmode in ('AIR', 'AIR REG')
    |   and l_shipinstruct = 'DELIVER IN PERSON'
    | )
    | or
    | (
    |   p_partkey = l_partkey
    |   and p_brand = 'Brand#34'
    |   and p_container in ( 'LG CASE', 'LG BOX', 'LG PACK', 'LG PKG')
    |   and l_quantity >= 20 and l_quantity <= 30
    |   and p_size between 1 and 15
    |   and l_shipmode in ('AIR', 'AIR REG')
    |   and l_shipinstruct = 'DELIVER IN PERSON'
    | )""".stripMargin

val tpch20 =
  """select
    | s_name,
    | s_address
    |from
    | supplier, nation
    |where
    | s_suppkey in (
    |   select
    |     ps_suppkey
    |   from
    |     partsupp
    |   where
    |     ps_partkey in (
    |       select
    |         p_partkey
    |       from
    |         part
    |       where
    |       p_name like 'forest%'
    |     )
    |     and ps_availqty > (
    |       select
    |         0.5 * sum(l_quantity)
    |       from
    |         lineitem
    |       where
    |         l_partkey = ps_partkey
    |         and l_suppkey = ps_suppkey
    |         and l_shipdate >= to_date('1994-01-01')
    |         and l_shipdate < to_date('1995-01-01')
    |     )
    | )
    | and s_nationkey = n_nationkey
    | and n_name = 'CANADA'
    |order by
    | s_name""".stripMargin

val tpch20nosub =
  """select
    |        distinct s_name,
    |        s_address
    |from
    |        supplier,
    |        nation,
    |        (
    |                select
    |                        distinct PSupp.ps_suppkey
    |                from
    |                        partsupp as PSupp,(
    |                                select ps_partkey, ps_suppkey, 0.5 * sum(l_quantity) as sum_l_quantity
    |                                from lineitem, partsupp
    |                                where l_partkey = ps_partkey
    |                                      and l_suppkey = ps_suppkey
    |                                      and l_shipdate >= to_date('1994-01-01')
    |                                      and l_shipdate < to_date('1995-01-01')
    |
    |                          group by ps_partkey, ps_suppkey
    |                        ) as T1,
    |
    |                                        (
    |                                select
    |                                        p_partkey
    |                                from
    |                                        part
    |                                where
    |                                        p_name like 'forest%'
    |                        ) as T2
    |                where
    |                        PSupp.ps_partkey = T2.p_partkey
    |                        and ps_availqty > T1.sum_l_quantity
    |          and T1.ps_partkey = PSupp.ps_partkey
    |          and T1.ps_suppkey = PSupp.ps_suppkey
    |
    |        )T3
    |where
    |        s_suppkey = T3.ps_suppkey
    |        and s_nationkey = n_nationkey
    |        and n_name = 'CANADA'
    |order by
    |        s_name""".stripMargin

val tpch21 =
  """select
    | s_name,
    | count(*) as numwait
    |from
    | supplier,
    | lineitem l1,
    | orders,
    | nation
    |where
    | s_suppkey = l1.l_suppkey
    | and o_orderkey = l1.l_orderkey
    | and o_orderstatus = 'F'
    | and l1.l_receiptdate > l1.l_commitdate
    | and exists (
    |   select
    |     *
    |   from
    |     lineitem l2
    |   where
    |     l2.l_orderkey = l1.l_orderkey
    |     and l2.l_suppkey <> l1.l_suppkey
    | )
    | and not exists (
    |   select
    |     *
    |   from
    |     lineitem l3
    |   where
    |     l3.l_orderkey = l1.l_orderkey
    |     and l3.l_suppkey <> l1.l_suppkey
    |     and l3.l_receiptdate > l3.l_commitdate
    | )
    | and s_nationkey = n_nationkey
    | and n_name = 'SAUDI ARABIA'
    |group by
    | s_name
    |order by
    | numwait desc,
    | s_name""".stripMargin

val tpch21nosub =
  """select
    |        s_name,
    |        count(*) as numwait
    |from
    |        supplier,
    |        lineitem l1 left outer join lineitem l3 on l3.l_orderkey = l1.l_orderkey
    |                        and l3.l_suppkey <> l1.l_suppkey
    |                        and l3.l_receiptdate > l3.l_commitdate,
    |        orders,
    |        nation,
    |        (select distinct l2.l_orderkey from lineitem l2, lineitem l4 where l2.l_orderkey = l4.l_orderkey and l2.l_suppkey <> l4.l_suppkey) as T
    |
    |where
    |        s_suppkey = l1.l_suppkey
    |        and o_orderkey = l1.l_orderkey
    |        and o_orderstatus = 'F'
    |        and l1.l_receiptdate > l1.l_commitdate
    |        and T.l_orderkey = l1.l_orderkey
    |        and s_nationkey = n_nationkey
    |        and n_name = 'SAUDI ARABIA'
    |        and l3.l_orderkey is NULL
    |        and T.l_orderkey = l1.l_orderkey
    |group by
    |        s_name
    |order by
    |        numwait desc,
    |        s_name
    |limit 100""".stripMargin

val tpch22 =
  """select
    | cntrycode,
    | count(*) as numcust,
    | sum(c_acctbal) as totacctbal
    |from (
    | select
    |   substring(c_phone from 1 for 2) as cntrycode,
    |   c_acctbal
    | from
    |   customer
    | where
    |   substring(c_phone from 1 for 2) in
    |     ('13','31','23','29','30','18','17')
    |   and c_acctbal > (
    |     select
    |       avg(c_acctbal)
    |     from
    |       customer
    |     where
    |       c_acctbal > 0.00
    |     and substring (c_phone from 1 for 2) in
    |       ('13','31','23','29','30','18','17')
    |   )
    |   and not exists (
    |     select
    |       *
    |     from
    |       orders
    |     where
    |     o_custkey = c_custkey
    |   )
    | ) as custsale
    |group by
    | cntrycode
    |order by
    | cntrycode""".stripMargin

val tpch22nosub =
  """select
    |        cntrycode,
    |        count(*) as numcust,
    |        sum(c_acctbal) as totacctbal
    |from
    |     (
    |          select
    |              substring(c_phone, 1, 2) as cntrycode,
    |            c_acctbal
    |          from
    |              customer left outer join orders on o_custkey = c_custkey ,
    |              (
    |              select avg(c_acctbal) as avg_c_acctbal
    |              from customer
    |              where
    |                   c_acctbal > 0.00
    |                    and substring(c_phone, 1, 2) in ('13', '31', '23', '29', '30', '18', '17')) as T
    |          where
    |                substring(c_phone, 1, 2) in ('13', '31', '23', '29', '30', '18', '17')
    |          and o_custkey is NULL
    |          and c_acctbal > T.avg_c_acctbal
    |        ) as custsale
    |group by
    |        cntrycode
    |order by
    |        cntrycode""".stripMargin

def testSpark(s: String) = {
  val res = sqlContext.sql(s)

  System.out.println(res.queryExecution.optimizedPlan)

  res.show()
}

def testDelite(s: String, preloadData: Boolean = false) = {
  val res = sqlContext.sql(s)

  System.out.println(res.queryExecution.optimizedPlan)

  Run.runDelite(res.queryExecution.optimizedPlan, preloadData)
}
