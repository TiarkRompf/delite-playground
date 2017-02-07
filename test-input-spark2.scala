// test -- this can be run from the repl
import org.apache.spark.sql.SparkSession
import scala.collection.mutable._

// sc.stop()
// spark.stop
//val configuration = new SparkConf().setAppName("Benchmark").setMaster("local[8]")

// val sc = new SparkContext(configuration)

   val tpch_orig = Seq(
     ("tpch1",
        """
          |select
          |   l_returnflag,
          |   l_linestatus,
          |   sum(l_quantity) as sum_qty,
          |   sum(l_extendedprice) as sum_base_price,
          |   sum(l_extendedprice * (1 - l_discount)) as sum_disc_price,
          |   sum(l_extendedprice * (1 - l_discount) * (1 + l_tax)) as sum_charge,
          |   avg(l_quantity) as avg_qty,
          |   avg(l_extendedprice) as avg_price,
          |   avg(l_discount) as avg_disc,
          |   count(*) as count_order
          |from
          |   lineitem
          |where
          |   l_shipdate <= to_date('1998-09-02')
          |group by
          |   l_returnflag,
          |   l_linestatus
          |order by
          |   l_returnflag,
          |   l_linestatus
        """.stripMargin),

     ("tpch2",
        """
          |select
          |   s_acctbal,
          |   s_name,
          |   n_name,
          |   p_partkey,
          |   p_mfgr,
          |   s_address,
          |   s_phone,
          |   s_comment
          |from
          |   part,
          |   supplier,
          |   partsupp,
          |   nation,
          |   region,
          |   (select
          |       ps_partkey as t_ps_partkey,
          |       min(ps_supplycost) as t_min_ps_supplycost
          |   from
          |       part,
          |       partsupp,
          |       supplier,
          |       nation,
          |       region
          |   where
          |       p_partkey = ps_partkey
          |       and s_suppkey = ps_suppkey
          |       and s_nationkey = n_nationkey
          |       and n_regionkey = r_regionkey
          |       and r_name = 'EUROPE'
          |       and p_size = 15
          |       and p_type like '%BRASS'
          |   group by
          |       ps_partkey
          |   ) as T
          |where
          |   p_partkey = ps_partkey
          |   and s_suppkey = ps_suppkey
          |   and p_size = 15
          |   and p_type like '%BRASS'
          |   and s_nationkey = n_nationkey
          |   and n_regionkey = r_regionkey
          |   and r_name = 'EUROPE'
          |   and p_partkey = t_ps_partkey
          |   and ps_supplycost = t_min_ps_supplycost
          |order by
          |   s_acctbal desc,
          |   n_name,
          |   s_name,
          |   p_partkey
        """.stripMargin),

     ("tpch3",
        """
          |select
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
          | o_orderdate
        """.stripMargin),

      ("tpch4",
        """
          |select
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
          | o_orderpriority
        """.stripMargin),

      ("tpch5",
        """
          |select
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
          | revenue desc
        """.stripMargin),

      ("tpch6",
        """
          |select
          | sum(l_extendedprice*l_discount) as revenue
          |from
          | lineitem
          |where
          | l_shipdate >= to_date('1994-01-01')
          | and l_shipdate < to_date('1995-01-01')
          | and l_discount between 0.05 and 0.07
          | and l_quantity < 24
        """.stripMargin),

      ("tpch7",
        """
          |select
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
          | l_year
        """.stripMargin),

     ("tpch8",
        """
          |select
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
          | o_year
        """.stripMargin),

      ("tpch9",
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
          | o_year desc
        """.stripMargin),

      ("tpch10",
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
          | revenue desc
        """.stripMargin),

      ("tpch11",
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
          | value desc
        """.stripMargin),

      ("tpch12",
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
          | l_shipmode
        """.stripMargin),

      ("tpch13",
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
          | c_count desc
        """.stripMargin),

      ("tpch14",
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
          | and l_shipdate < to_date('1995-10-02')
        """.stripMargin),

      ("tpch15",
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
          | s_suppkey
        """.stripMargin),

      ("tpch16",
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
          | p_size
        """.stripMargin),

      ("tpch17",
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
          | )
        """.stripMargin),

      ("tpch18",
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
          | o_orderdate
          |limit 100
        """.stripMargin),

      ("tpch19",
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
          | )
        """.stripMargin),

      ("tpch20",
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
          | s_name
        """.stripMargin),

      ("tpch21",
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
          | s_name
        """.stripMargin),

      ("tpch22",
        """select
          | cntrycode,
          | count(*) as numcust,
          | sum(c_acctbal) as totacctbal
          |from
          |  (select
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
          | cntrycode
        """.stripMargin)

      )

val tpch_string = Seq(
  ("tpch1",
     """
       |select
       |   l_returnflag,
       |   l_linestatus,
       |   sum(l_quantity) as sum_qty,
       |   sum(l_extendedprice) as sum_base_price,
       |   sum(l_extendedprice * (1 - l_discount)) as sum_disc_price,
       |   sum(l_extendedprice * (1 - l_discount) * (1 + l_tax)) as sum_charge,
       |   avg(l_quantity) as avg_qty,
       |   avg(l_extendedprice) as avg_price,
       |   avg(l_discount) as avg_disc,
       |   count(*) as count_order
       |from
       |   lineitem
       |where
       |   l_shipdate <= to_date('1998-09-02')
       |group by
       |   l_returnflag,
       |   l_linestatus
       |order by
       |   l_returnflag,
       |   l_linestatus
     """.stripMargin),

  ("tpch2",
     """
       |select
       |   s_acctbal,
       |   s_name,
       |   n_name,
       |   p_partkey,
       |   p_mfgr,
       |   s_address,
       |   s_phone,
       |   s_comment
       |from
       |   part,
       |   supplier,
       |   partsupp,
       |   nation,
       |   region,
       |   (select
       |       ps_partkey as t_ps_partkey,
       |       min(ps_supplycost) as t_min_ps_supplycost
       |   from
       |       part,
       |       partsupp,
       |       supplier,
       |       nation,
       |       region
       |   where
       |       p_partkey = ps_partkey
       |       and s_suppkey = ps_suppkey
       |       and s_nationkey = n_nationkey
       |       and n_regionkey = r_regionkey
       |       and r_name = 'EUROPE'
       |       and p_size = 15
       |       and p_type like '%BRASS'
       |   group by
       |       ps_partkey
       |   ) as T
       |where
       |   p_partkey = ps_partkey
       |   and s_suppkey = ps_suppkey
       |   and p_size = 15
       |   and p_type like '%BRASS'
       |   and s_nationkey = n_nationkey
       |   and n_regionkey = r_regionkey
       |   and r_name = 'EUROPE'
       |   and p_partkey = t_ps_partkey
       |   and ps_supplycost = t_min_ps_supplycost
       |order by
       |   s_acctbal desc,
       |   n_name,
       |   s_name,
       |   p_partkey
     """.stripMargin),

  ("tpch3",
     """
       |select
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
       | o_orderdate
     """.stripMargin),

   ("tpch4orig",
     """
       |select
       | o_orderpriority,
       | count(*) as order_count
       |from
       | orders
       |where
       | o_orderdate >= to_date('1993-07-01')
       | and o_orderdate < to_date('1993-10-01')
       | and exists (
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
       | o_orderpriority
     """.stripMargin),

   ("tpch4",
     """
       |select
       | o_orderpriority,
       | count(*) as order_count
       |from
       | orders left semi join lineitem on
       |   l_orderkey = o_orderkey
       |   and o_orderdate >= to_date('1993-07-01')
       |   and o_orderdate < to_date('1993-10-01')
       |   and l_commitdate < l_receiptdate
       |group by
       | o_orderpriority
       |order by
       | o_orderpriority
     """.stripMargin),

   ("tpch5",
     """
       |select
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
       | revenue desc
     """.stripMargin),

   ("tpch6",
     """
       |select
       | sum(l_extendedprice*l_discount) as revenue
       |from
       | lineitem
       |where
       | l_shipdate >= to_date('1994-01-01')
       | and l_shipdate < to_date('1995-01-01')
       | and l_discount between 0.05 and 0.07
       | and l_quantity < 24
     """.stripMargin),

   ("tpch7",
     """
       |select
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
       | l_year
     """.stripMargin),

  ("tpch8",
     """
       |select
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
       | o_year
     """.stripMargin),

   ("tpch9",
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
       | o_year desc
     """.stripMargin),

   ("tpch10",
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
       | revenue desc
     """.stripMargin),

   ("tpch11orig",
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
       | value desc
     """.stripMargin),

   ("tpch11",
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
     """.stripMargin),

   ("tpch12",
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
       | l_shipmode
     """.stripMargin),

   ("tpch13",
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
       | c_count desc
     """.stripMargin),

   ("tpch14",
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
       | and l_shipdate < to_date('1995-10-02')
     """.stripMargin),

   ("tpch15orig",
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
       | s_suppkey
     """.stripMargin),

   ("tpch15",
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
       |    s_suppkey
     """.stripMargin),

   ("tpch16orig",
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
       | p_size
     """.stripMargin),

   ("tpch16",
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
       | p_size
     """.stripMargin),

   ("tpch17orig",
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
       | )
     """.stripMargin),

   ("tpch17",
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
       |        and l_quantity < T.avg_l_quantity
     """.stripMargin),


   ("tpch18orig",
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
       | o_orderdate
     """.stripMargin),

   ("tpch18",
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
       |limit 100
     """.stripMargin),

   ("tpch19",
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
       | )
     """.stripMargin),

   ("tpch20orig",
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
       | s_name
     """.stripMargin),

   ("tpch20_orig",
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
       |        s_name
     """.stripMargin),
   ("tpch20",
     """select
       |        distinct s_name,
       |        s_address
       |from
       |        supplier,
       |        nation,
       |        (
       |            select
       |                    distinct PSupp.ps_suppkey
       |            from
       |                   (
       |                      select
       |                          ps_partkey, ps_suppkey, 0.5 * sum(l_quantity) as sum_l_quantity
       |                      from
       |                          lineitem, partsupp
       |                      where
       |                        ps_partkey = l_partkey
       |                        and ps_suppkey = l_suppkey
       |                        and l_shipdate >= to_date('1994-01-01')
       |                        and l_shipdate < to_date('1995-01-01')
       |                     group by
       |                        ps_partkey, ps_suppkey
       |                   ) as T1,
       |                   partsupp as PSupp left semi join part on PSupp.ps_partkey = p_partkey and p_name like 'forest%'
       |
       |            where
       |                    ps_availqty > T1.sum_l_quantity
       |                    and T1.ps_partkey = PSupp.ps_partkey
       |                    and T1.ps_suppkey = PSupp.ps_suppkey
       |
       |        )T3
       |where
       |        s_suppkey = T3.ps_suppkey
       |        and s_nationkey = n_nationkey
       |        and n_name = 'CANADA'
       |order by
       |        s_name
     """.stripMargin),


   ("tpch21orig",
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
       | s_name
     """.stripMargin),

   ("tpch21",
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
       |limit 100
     """.stripMargin),

   ("tpch22orig",
     """select
       | cntrycode,
       | count(*) as numcust,
       | sum(c_acctbal) as totacctbal
       |from (
       | select
       |   substring(c_phone, 1, 2) as cntrycode,
       |   c_acctbal
       | from
       |   customer
       | where
       |   substring(c_phone, 1, 2) in
       |     ('13','31','23','29','30','18','17')
       |   and c_acctbal > (
       |     select
       |       avg(c_acctbal)
       |     from
       |       customer
       |     where
       |       c_acctbal > 0.00
       |     and substring (c_phone, 1, 2) in
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
       | cntrycode
     """.stripMargin),

   ("tpch22",
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
       |        cntrycode
     """.stripMargin)

   )

def getQuery(seq: Seq[(String, String)], name: String) = {
  seq.filter { case (a, b) => a == name }(0)
}

val tpch_opt_string = Seq(
  getQuery(tpch_string, "tpch1"),

  ("tpch2",
    """with A as (select * from region, nation where n_regionkey = r_regionkey and r_name = 'EUROPE'),
      |B as (select * from A, supplier where s_nationkey = n_nationkey),
      |C as (select ps_partkey as int_ps_partkey, min(ps_supplycost) as min_cost from B, partsupp where s_suppkey = ps_suppkey group by ps_partkey),
      |D as (select * from part, C where p_partkey = int_ps_partkey and p_size = 15 and p_type like '%BRASS'),
      |E as (select * from D, partsupp where ps_supplycost = min_cost and p_partkey = ps_partkey)
      |select
      |        s_acctbal,
      |        s_name,
      |        n_name,
      |        p_partkey,
      |        p_mfgr,
      |        s_address,
      |        s_phone,
      |        s_comment
      |from
      |       B,
      |       E
      |where
      |       s_suppkey = ps_suppkey
      |order by
      |        s_acctbal desc,
      |        n_name,
      |        s_name,
      |        p_partkey
      |limit 100
    """.stripMargin),

  getQuery(tpch_string, "tpch3"),

  getQuery(tpch_string, "tpch4"),

  ("tpch5",
    """with A as (select * from region, nation where n_regionkey = r_regionkey),
      |B as (select * from A, customer where c_nationkey = n_nationkey),
      |C as (select * from B, orders where c_custkey = o_custkey),
      |D as (select * from C, lineitem where l_orderkey = o_orderkey)
      |select
      | n_name,
      | sum(l_extendedprice * (1 - l_discount)) as revenue
      |from
      | supplier, D
      |where
      | l_suppkey = s_suppkey
      | and c_nationkey = s_nationkey
      | and s_nationkey = n_nationkey
      | and r_name = 'ASIA'
      | and o_orderdate >= to_date('1994-01-01')
      | and o_orderdate < to_date('1995-01-01')
      |group by
      | n_name
      |order by
      | revenue desc
    """.stripMargin),

  getQuery(tpch_string, "tpch6"),

  ("tpch7",
    """with A as (select n1.n_name as supp_nation, n2.n_name as cust_nation, n1.n_nationkey as n1key, n2.n_nationkey as n2key from nation n1, nation n2 where (n1.n_name = 'FRANCE' and n2.n_name = 'GERMANY') or (n1.n_name = 'GERMANY' and n2.n_name = 'FRANCE')),
      |B as (select * from A, customer where c_nationkey = n2key),
      |C as (select * from B, orders where c_custkey = o_custkey),
      |D as (select * from C, lineitem where o_orderkey = l_orderkey)
      |select
      | supp_nation,
      | cust_nation,
      | l_year,
      | sum(volume) as revenue
      |from (
      | select
      |   supp_nation,
      |   cust_nation,
      |   year(l_shipdate) as l_year,
      |   l_extendedprice * (1 - l_discount) as volume
      | from
      |   supplier, D
      | where
      |   s_suppkey = l_suppkey
      |   and s_nationkey = n1key
      |   and l_shipdate between to_date('1995-01-01') and to_date('1996-12-31')
      | ) as shipping
      |group by
      | supp_nation,
      | cust_nation,
      | l_year
      |order by
      | supp_nation,
      | cust_nation,
      | l_year
    """.stripMargin),

  ("tpch8",
    """with A as (select * from region, nation where n_regionkey = r_regionkey),
      |B as (select * from part, lineitem where p_partkey = l_partkey),
      |C as (select * from B, orders where l_orderkey = o_orderkey),
      |D as (select * from C, customer where o_custkey = c_custkey),
      |E as (select * from A, D where c_nationkey = n_nationkey),
      |F as (select * from E, supplier where s_suppkey = l_suppkey)
      |select
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
      |   nation n2,
      |   F
      | where
      |   r_name = 'AMERICA'
      |   and s_nationkey = n2.n_nationkey
      |   and o_orderdate between to_date('1995-01-01') and to_date('1996-12-31')
      |   and p_type = 'ECONOMY ANODIZED STEEL'
      | ) as all_nations
      |group by
      | o_year
      |order by
      | o_year
    """.stripMargin),

("tpch9",
  """with A as (select * from nation, supplier where s_nationkey = n_nationkey),
    |B as (select * from part, partsupp where p_partkey = ps_partkey and p_name like '%green%'),
    |C as (select * from A, B where s_suppkey = ps_suppkey),
    |D as (select * from C, lineitem where p_partkey = l_partkey and s_suppkey = l_suppkey and ps_suppkey = l_suppkey and ps_partkey = l_partkey)
    | select
    | nation,
    | o_year,
    | sum(amount) as sum_profit
    |from (
    | select
    |   n_name as nation,
    |   year(o_orderdate) as o_year,
    |   l_extendedprice * (1 - l_discount) - ps_supplycost * l_quantity as amount
    | from
    |   D join orders
    |     on o_orderkey = l_orderkey
    | ) as profit
    |group by
    | nation,
    | o_year
    |order by
    | nation,
    | o_year desc
  """.stripMargin),

("tpch10",
  """with A as (select * from orders, customer where c_custkey = o_custkey),
    |B as (select * from nation, A where c_nationkey = n_nationkey)
    |select
    | c_custkey,
    | c_name,
    | sum(l_extendedprice * (1 - l_discount)) as revenue,
    | c_acctbal,
    | n_name,
    | c_address,
    | c_phone,
    | c_comment
    |from
    | B, lineitem
    |where
    | l_orderkey = o_orderkey
    | and o_orderdate >= to_date('1993-10-01')
    | and o_orderdate < to_date('1994-01-01')
    | and l_returnflag = 'R'
    |group by
    | c_custkey,
    | c_name,
    | c_acctbal,
    | c_phone,
    | n_name,
    | c_address,
    | c_comment
    |order by
    | revenue desc
  """.stripMargin),

("tpch11",
  """with A as (select * from nation, supplier where s_nationkey = n_nationkey and n_name = 'GERMANY'),
    |B as (select * from A, partsupp where ps_suppkey = s_suppkey),
    |C as (select sum(ps_supplycost * ps_availqty) * 0.0001 as V from B),
    |D as (select ps_partkey, sum(ps_supplycost * ps_availqty) as value from B group by ps_partkey)
    |select
    |   ps_partkey,
    |   value
    |from
    |   C, D
    |where
    |   value > V
    |order by
    |   value desc
  """.stripMargin),

getQuery(tpch_string, "tpch12"),

getQuery(tpch_string, "tpch13"),

getQuery(tpch_string, "tpch14"),

getQuery(tpch_string, "tpch15"),

getQuery(tpch_string, "tpch16"),

getQuery(tpch_string, "tpch17"),

("tpch18",
  """with A as (select l_orderkey as key, sum(l_quantity) as sumq from lineitem group by l_orderkey),
    |B as (select * from A, orders where sumq > 300 and o_orderkey = key),
    |C as (select * from customer, B where c_custkey = o_custkey)
    |select
    | c_name,
    | c_custkey,
    | o_orderkey,
    | o_orderdate,
    | o_totalprice,
    | sum(l_quantity)
    |from
    | C,
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
    |order by
    | o_totalprice desc,
    | o_orderdate
    |limit 100
  """.stripMargin),

getQuery(tpch_string, "tpch19"),

("tpch20",
  """with A as (select * from nation, supplier where s_nationkey = n_nationkey),
    |B as (select * from partsupp left semi join part on ps_partkey = p_partkey and p_name like 'forest%'),
    |C as (select l_partkey, l_suppkey, 0.5 * sum(l_quantity) as sum from lineitem where l_shipdate >= to_date('1994-01-01') and l_shipdate < to_date('1995-01-01') group by l_partkey, l_suppkey),
    |D as (select * from B, C where ps_partkey = l_partkey and ps_suppkey = l_suppkey and ps_availqty > sum)
    |select
    |   distinct s_name,
    |   s_address
    |from
    |   A left semi join D on s_suppkey = ps_suppkey
    |where
    |   n_name = 'CANADA'
    |order by
    |   s_name
  """.stripMargin),

("tpch21",
  """with Z as (select * from lineitem where l_receiptdate > l_commitdate),
    |A as (select * from nation, supplier where s_nationkey = n_nationkey and n_name = 'SAUDI ARABIA'),
    |B as (select * from A, Z where s_suppkey = l_suppkey),
    |C as (select * from B, orders where o_orderkey = l_orderkey and o_orderstatus = 'F'),
    |D as (select * from C left semi join Z on not (Z.l_orderkey = C.l_orderkey and Z.l_suppkey <> C.l_suppkey))
    |select
    |   s_name,
    |   count(*) as numwait
    |from
    |   D left semi join lineitem as L on D.l_orderkey = L.l_orderkey and D.l_suppkey <> L.l_suppkey
    |group by
    |   s_name
    |order by
    |   numwait desc,
    |   s_name
    |limit 100
  """.stripMargin),

("tpch22",
  """with A as (select * from customer where c_acctbal > 0.00 and substring(c_phone, 1, 2) in ('13', '31', '23', '29', '30', '18', '17')),
    |B as (select avg(c_acctbal) as avg_c_acctbal from A),
    |C as (select c_custkey, c_acctbal, substring(c_phone, 1, 2) as cntrycode from B, A where c_acctbal > avg_c_acctbal)
    |select
    |   cntrycode,
    |   count(*) as numcust,
    |   sum(c_acctbal) as totacctbal
    |from
    |   C left anti join orders on o_custkey = c_custkey
    |group by
    | cntrycode
    |order by
    | cntrycode
  """.stripMargin)
)

val folder = "/home/greg/Research/data/SF1/"
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

def stringLength(n: Int) = Metadata.fromJson("{ \"length\" : " + n + "}")

val schema_part = StructType(Seq(
  StructField("p_partkey", IntegerType, nullable = false),
  StructField("p_name", StringType, nullable = false),
  StructField("p_mfgr", StringType, nullable = false),
  StructField("p_brand", StringType, nullable = false),
  StructField("p_type", StringType, nullable = false),
  StructField("p_size", IntegerType, nullable = false),
  StructField("p_container", StringType, nullable = false),
  StructField("p_retailprice", DoubleType, nullable = false),
  StructField("p_comment", StringType, nullable = false)))

val schema_supplier = StructType(Seq(
  StructField("s_suppkey", IntegerType, nullable = false),
  StructField("s_name", StringType, nullable = false),
  StructField("s_address", StringType, nullable = false),
  StructField("s_nationkey", IntegerType, nullable = false),
  StructField("s_phone", StringType, nullable = false, metadata = stringLength(15)),
  StructField("s_acctbal", DoubleType, nullable = false),
  StructField("s_comment", StringType, nullable = false)))

val schema_partsupp = StructType(Seq(
  StructField("ps_partkey", IntegerType, nullable = false),
  StructField("ps_suppkey", IntegerType, nullable = false),
  StructField("ps_availqty", IntegerType, nullable = false),
  StructField("ps_supplycost", DoubleType, nullable = false),
  StructField("ps_comment", StringType, nullable = false)))

val schema_customer = StructType(Seq(
  StructField("c_custkey", IntegerType, nullable = false),
  StructField("c_name", StringType, nullable = false),
  StructField("c_address", StringType, nullable = false),
  StructField("c_nationkey", IntegerType, nullable = false),
  StructField("c_phone", StringType, nullable = false, metadata = stringLength(15)),
  StructField("c_acctbal", DoubleType, nullable = false),
  StructField("c_mktsegment", StringType, nullable = false),
  StructField("c_comment", StringType, nullable = false)))

val schema_orders = StructType(Seq(
  StructField("o_orderkey", IntegerType, nullable = false),
  StructField("o_custkey", IntegerType, nullable = false),
  StructField("o_orderstatus", StringType, nullable = false, metadata = stringLength(1)),
  StructField("o_totalprice", DoubleType, nullable = false),
  StructField("o_orderdate", DateType, nullable = false),
  StructField("o_orderpriority", StringType, nullable = false),
  StructField("o_clerk", StringType, nullable = false, metadata = stringLength(15)),
  StructField("o_shippriority", IntegerType, nullable = false),
  StructField("o_comment", StringType, nullable = false)))

val schema_lineitem = StructType(Seq(
  StructField("l_orderkey", IntegerType, nullable = false),
  StructField("l_partkey", IntegerType, nullable = false),
  StructField("l_suppkey", IntegerType, nullable = false),
  StructField("l_linenumber", IntegerType, nullable = false),
  StructField("l_quantity", DoubleType, nullable = false),
  StructField("l_extendedprice", DoubleType, nullable = false),
  StructField("l_discount", DoubleType, nullable = false),
  StructField("l_tax", DoubleType, nullable = false),
  StructField("l_returnflag", StringType, nullable = false, metadata = stringLength(1)), // Char
  StructField("l_linestatus", StringType, nullable = false, metadata = stringLength(1)),
  StructField("l_shipdate", DateType, nullable = false),
  StructField("l_commitdate", DateType, nullable = false),
  StructField("l_receiptdate", DateType, nullable = false),
  StructField("l_shipinstruct", StringType, nullable = false),
  StructField("l_shipmode", StringType, nullable = false),
  StructField("l_comment", StringType, nullable = false)))

val schema_nation = StructType(Seq(
  StructField("n_nationkey", IntegerType, nullable = false),
  StructField("n_name", StringType, nullable = false),
  StructField("n_regionkey", IntegerType, nullable = false),
  StructField("n_comment", StringType, nullable = false)))

val schema_region = StructType(Seq(
  StructField("r_regionkey", IntegerType, nullable = false),
  StructField("r_name", StringType, nullable = false),
  StructField("r_comment", StringType, nullable = false)))

import org.apache.spark.sql.catalyst.plans.logical._
import org.apache.spark.sql.catalyst.plans._
import org.apache.spark.sql.execution.datasources.LogicalRelation
import org.apache.spark.sql.sources.BaseRelation
import org.apache.spark.sql.DataFrame
import com.databricks.spark.csv.CsvRelation
import org.apache.spark.sql.catalyst.expressions._
import org.apache.spark.sql.catalyst.expressions.aggregate._

import optimql.compiler._
import optimql.library._
import optimql.shared._
import scala.reflect.{Manifest,SourceContext,ManifestFactory,RefinedManifest}
import scala.virtualization.lms.common.{Record, TupleOps}
import scala.math.Ordering
import playground._
import java.util.{Date, Calendar}
import java.text._

// def deliteSQL(s: String) = Run.runDelite(spark.sql(s).queryExecution.optimizedPlan, false)

// Tables
val customer = (spark.read
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_customer)
  .csv(file_customer))

val orders = (spark.read
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_orders)
  .csv(file_orders))

val lineitem = (spark.read
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_lineitem)
  .csv(file_lineitem))

val part = (spark.read
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_part)
  .csv(file_part))

val supplier = (spark.read
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_supplier)
  .csv(file_supplier))

val partsupp = (spark.read
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_partsupp)
  .csv(file_partsupp))

val nation = (spark.read
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_nation)
  .csv(file_nation))

val region = (spark.read
  .option("delimiter", "|")
  .option("header", "false") // use first line of all files as header
  .option("inferschema", "false") // automatically infer data types
  .schema(schema_region)
  .csv(file_region))

customer.createOrReplaceTempView("customer")
orders.createOrReplaceTempView("orders")
lineitem.createOrReplaceTempView("lineitem")
part.createOrReplaceTempView("part")
supplier.createOrReplaceTempView("supplier")
partsupp.createOrReplaceTempView("partsupp")
nation.createOrReplaceTempView("nation")
region.createOrReplaceTempView("region")

def measureTimeMs[A](f: => A): Double = {
  val startTime = System.nanoTime()
  f
  val endTime = System.nanoTime()
  (endTime - startTime).toDouble / 1000000
}

def testSpark(s: String) = {

  val df =  spark.sql(s)
  val queryExecution = df.queryExecution
  // We are not counting the time of ScalaReflection.convertRowToScala.
  val parsingTime = measureTimeMs {
    queryExecution.logical
  }
  println(s"Parsing time: $parsingTime")

  val analysisTime = measureTimeMs {
    queryExecution.analyzed
  }
  println(s"Analysis time: $analysisTime")

  val optimizationTime = measureTimeMs {
    queryExecution.optimizedPlan
  }
  println(s"Optimization time: $optimizationTime")

  val planningTime = measureTimeMs {
    queryExecution.executedPlan
  }
  println(s"Planning time: $planningTime")

  val executionTime = measureTimeMs {
    df.rdd.foreach { row => Unit }
  }
  df.show()
  println(s"Execution time: $executionTime")
}

def testDelite(s: String, preloadData: Boolean = false, debug: Boolean = false)(udfMap: Map[Any,Any]) = {
  val res = spark.sql(s)

  System.out.println(res.queryExecution.optimizedPlan)

  Run.runDelite(res.queryExecution.optimizedPlan, preloadData, debug)(udfMap)
}

ppl.delite.framework.Config.debug = true

def time[T](a: =>T):T = {
  val t = System.currentTimeMillis
  try a finally println(System.currentTimeMillis - t)
}

def preload() = {
  customer.persist().count()
  orders.persist().count()
  lineitem.persist().count()
  part.persist().count()
  supplier.persist().count()
  partsupp.persist().count()
  nation.persist().count()
  region.persist().count()
}

def runbenchmark(iterations: Int, queries: String = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22") = {
  val res = HashMap[String,ArrayBuffer[Double]]()
  preload()

  for (it <- 1 to iterations) {
    println(s"Iteration $it")
    queries.split(",").map({
      (n:String) => getQuery(tpch_opt_string, s"tpch${n}")
    }).foreach({
        case (name: String, sql: String) =>
          println(s"\tQuery $name")
          val df = spark.sql(sql)
          val queryExecution = df.queryExecution
          // We are not counting the time of ScalaReflection.convertRowToScala.
          val parsingTime = measureTimeMs {
            queryExecution.logical
          }
          val analysisTime = measureTimeMs {
            queryExecution.analyzed
          }
          val optimizationTime = measureTimeMs {
            queryExecution.optimizedPlan
          }
          val planningTime = measureTimeMs {
            queryExecution.executedPlan
          }

          val executionTime = measureTimeMs {
            df.rdd.foreach { row => Unit }
          }

          val resq = res getOrElseUpdate (name, ArrayBuffer[Double]())
          resq += executionTime
          println("Results:")
          res.toSeq.sortWith((a,b) => a._1.length < b._1.length || (a._1.length == b._1.length && a._1 < b._1)) foreach { case (name, resq) =>
            print(name + ", ")
            resq foreach { d => print(d + ",") }
            println(resq.min)
          }
      })
  }
}

def fS(lms: OptiMQLApplicationCompiler) = { import lms._; (yy: Rep[Int]) => yy + yy }
val f = (x: Int) => x
val g = fS(_: OptiMQLApplicationCompiler): Any
val map = Map[Any,Any]()
map(f) = g

spark.udf.register("testFunction", f)

testDelite("select n_nationkey, testFunction(n_nationkey) from nation")(map)


val tpch1 =
        """
          |select
          |   l_returnflag,
          |   l_linestatus,
          |   sum(l_quantity) as sum_qty,
          |   sum(l_extendedprice) as sum_base_price,
          |   sum(l_extendedprice * (1 - l_discount)) as sum_disc_price,
          |   sum(l_extendedprice * (1 - l_discount) * (1 + l_tax)) as sum_charge,
          |   avg(l_quantity) as avg_qty,
          |   avg(l_extendedprice) as avg_price,
          |   avg(l_discount) as avg_disc,
          |   count(*) as count_order
          |from
          |   lineitem
          |where
          |   l_shipdate <= to_date('1998-09-02')
          |group by
          |   l_returnflag,
          |   l_linestatus
          |order by
          |   l_returnflag,
          |   l_linestatus
        """.stripMargin
