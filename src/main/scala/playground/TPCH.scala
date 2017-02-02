package playground

import optimql.compiler._
import optimql.library._
import optimql.shared._
import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.Record

// object TPCHQ1Interpreter extends OptiQLApplicationInterpreter with TPCHQ1Trait
// object TPCHQ1Compiler extends OptiQLApplicationCompiler with TPCHQ1Trait with DeliteTestRunner
// object TPCHQ6Interpreter extends OptiQLApplicationInterpreter with TPCHQ6Trait
// object TPCHQ6Compiler extends OptiQLApplicationCompiler with TPCHQ6Trait
// object TPCHQ14Interpreter extends OptiQLApplicationInterpreter with TPCHQ14Trait
// object TPCHQ14Compiler extends OptiQLApplicationCompiler with TPCHQ14Trait


trait Types { this: OptiMQLApplication =>

  type LineItem = Record {
    val l_orderkey: Int
    val l_partkey: Int
    val l_suppkey: Int
    val l_linenumber: Int
    val l_quantity: Double
    val l_extendedprice: Double
    val l_discount: Double
    val l_tax: Double
    val l_returnflag: Char
    val l_linestatus: Char
    val l_shipdate: Date
    val l_commitdate: Date
    val l_receiptdate: Date
    val l_shipinstruct: String
    val l_shipmode: String
    val l_comment: String
  }

  def LineItem(orderKey: Rep[Int], partKey: Rep[Int], supplierKey: Rep[Int], lineNumber: Rep[Int], quantity: Rep[Double],
               extendedPrice: Rep[Double], discount: Rep[Double], tax: Rep[Double], returnFlag: Rep[Char],
               lineStatus: Rep[Char], shipDate: Rep[Date], commitDate: Rep[Date], receiptDate: Rep[Date],
               shipInstructions: Rep[String], shipMode: Rep[String], comment: Rep[String]): Rep[LineItem] = new Record {
    val l_orderkey = orderKey
    val l_partkey = partKey
    val l_suppkey = supplierKey
    val l_linenumber = lineNumber
    val l_quantity = quantity
    val l_extendedprice = extendedPrice
    val l_discount = discount
    val l_tax = tax
    val l_returnflag = returnFlag
    val l_linestatus = lineStatus
    val l_shipdate = shipDate
    val l_commitdate = commitDate
    val l_receiptdate = receiptDate
    val l_shipinstruct = shipInstructions
    val l_shipmode = shipMode
    val l_comment = comment
  }

  type Customer = Record {
    val c_custkey: Int
    val c_name: String
    val c_address: String
    val c_nationkey: Int
    val c_phone: String
    val c_acctbal: Double
    val c_mktsegment: String
    val c_comment: String
  }

  def Customer(key: Rep[Int], name: Rep[String], address: Rep[String], nationKey: Rep[Int], phone: Rep[String],
               acctBal: Rep[Double], marketSegment: Rep[String], comment: Rep[String]): Rep[Customer] = new Record {
    val c_custkey = key
    val c_name = name
    val c_address = address
    val c_nationkey = nationKey
    val c_phone = phone
    val c_acctbal = acctBal
    val c_mktsegment = marketSegment
    val c_comment = comment
  }

  type Nation = Record {
    val n_nationkey: Int
    val n_name: String
    val n_regionkey: Int
    val n_comment: String
  }

  def Nation(key: Rep[Int], name: Rep[String], regionKey: Rep[Int], comment: Rep[String]): Rep[Nation] = new Record {
    val n_nationkey = key
    val n_name = name
    val n_regionkey = regionKey
    val n_comment = comment
  }

  type Order = Record {
    val o_orderkey: Int
    val o_custkey: Int
    val o_orderstatus: Char
    val o_totalprice: Double
    val o_orderdate: Date
    val o_orderpriority: String
    val o_clerk: String
    val o_shippriority: Int
    val o_comment: String
  }

  def Order(key: Rep[Int], customerKey: Rep[Int], orderStatus: Rep[Char], totalPrice: Rep[Double],
            orderDate: Rep[Date], orderPriority: Rep[String], clerk: Rep[String], shipPriority: Rep[Int],
            comment: Rep[String]): Rep[Order] = new Record {
    val o_orderkey = key
    val o_custkey = customerKey
    val o_orderstatus = orderStatus
    val o_totalprice = totalPrice
    val o_orderdate = orderDate
    val o_orderpriority = orderPriority
    val o_clerk = clerk
    val o_shippriority = shipPriority
    val o_comment = comment
  }

  type Part = Record {
    val p_partkey: Int
    val p_name: String
    val p_mfgr: String
    val p_brand: String
    val p_type: String
    val p_size: Int
    val p_container: String
    val p_retailprice: Double
    val p_comment: String
  }

  def Part(key: Rep[Int], name: Rep[String], manufacturer: Rep[String], brand: Rep[String], partType: Rep[String],
           size: Rep[Int], container: Rep[String], retailPrice: Rep[Double], comment: Rep[String]): Rep[Part] = new Record {
    val p_partkey = key
    val p_name = name
    val p_mfgr = manufacturer
    val p_brand = brand
    val p_type = partType
    val p_size = size
    val p_container = container
    val p_retailprice = retailPrice
    val p_comment = comment
  }

  type PartSupplier = Record {
    val ps_partkey: Int
    val ps_suppkey: Int
    val ps_availqty: Int
    val ps_supplycost: Double
    val ps_comment: String
  }

  def PartSupplier(partKey: Rep[Int], supplierKey: Rep[Int], availableQty: Rep[Int],
                   supplyCost: Rep[Double], comment: Rep[String]): Rep[PartSupplier] = new Record {
    val ps_partkey = partKey
    val ps_suppkey = supplierKey
    val ps_availqty = availableQty
    val ps_supplycost = supplyCost
    val ps_comment = comment
  }

  type Region = Record {
    val r_regionkey: Int
    val r_name: String
    val r_comment: String
  }

  def Region(key: Rep[Int], name: Rep[String], comment: Rep[String]): Rep[Region] = new Record {
    val r_regionkey = key
    val r_name = name
    val r_comment = comment
  }

  type Supplier = Record {
    val s_suppkey: Int
    val s_name: String
    val s_address: String
    val s_nationkey: Int
    val s_phone: String
    val s_acctbal: Double
    val s_comment: String
  }

  def Supplier(key: Rep[Int], name: Rep[String], address: Rep[String], nationKey: Rep[Int],
               phone: Rep[String], acctBal: Rep[Double], comment: Rep[String]): Rep[Supplier] = new Record {
    val s_suppkey = key
    val s_name = name
    val s_address = address
    val s_nationkey = nationKey
    val s_phone = phone
    val s_acctbal = acctBal
    val s_comment = comment
  }

}


trait TPCHBaseTrait extends OptiMQLApplication with Types {

  def printUsage = {
    println("Usage: TPCH"+queryName+" <input directory>")
    exit(-1)
  }

  //timing decided at staging time so we can fuse across I/O when possible
  val timeIO: Boolean = false // System.getProperty("tpch.time.io", "true") != "false"
  override def tic(in: Rep[Any]*)(implicit ctx: SourceContext) = {
    if (timeIO) super.tic() //start timing immediately
    else super.tic(in:_*) //start timing after input loaded
  }

  val queryName: String

  var tpchDataPath: Rep[String] = _
  val sep = "\\|"
  def loadLineItems() = Table.fromFile[LineItem](tpchDataPath+"/lineitem.tbl", sep)
  def loadCustomers() = Table.fromFile[Customer](tpchDataPath+"/customer.tbl", sep)
  def loadNations() = Table.fromFile[Nation](tpchDataPath+"/nation.tbl", sep)
  def loadOrders() = Table.fromFile[Order](tpchDataPath+"/orders.tbl", sep)
  def loadParts() = Table.fromFile[Part](tpchDataPath+"/part.tbl", sep)
  def loadPartSuppliers() = Table.fromFile[PartSupplier](tpchDataPath+"/partsupp.tbl", sep)
  def loadRegions() = Table.fromFile[Region](tpchDataPath+"/region.tbl", sep)
  def loadSuppliers() = Table.fromFile[Supplier](tpchDataPath+"/supplier.tbl", sep)

  def query(): Rep[_]

  def main() = {
    println("TPC-H " + queryName)
    if (args.length < 1) printUsage

    tpchDataPath = args(0)
    query()
  }

}


trait TPCHQ1Trait extends TPCHBaseTrait {

  val queryName = "Q1"
  def query() = {

    val lineItems = loadLineItems()
    tic(lineItems.size)

    val q = lineItems Where(_.l_shipdate <= Date("1998-09-02")) GroupBy(l => pack(l.l_returnflag,l.l_linestatus)) Select(g => new Record {
      val returnFlag = g.key._1
      val lineStatus = g.key._2
      val sumQty = g.values.Sum(_.l_quantity)
      val sumBasePrice = g.values.Sum(_.l_extendedprice)
      val sumDiscountedPrice = g.values.Sum(l => l.l_extendedprice * (1.0 - l.l_discount))
      val sumCharge = g.values.Sum(l => l.l_extendedprice * (1.0 - l.l_discount) * infix_+(1.0, l.l_tax)) //FIXME: infix_+ fails to resolve automatically
      val avgQty = g.values.Average(_.l_quantity)
      val avgPrice = g.values.Average(_.l_extendedprice)
      val avgDiscount = g.values.Average(_.l_discount)
      val countOrder = g.values.Count
    }) OrderBy(asc(_.returnFlag), asc(_.lineStatus))

    toc(q)
    q.printAsTable()
    //q.writeAsJSON("out.json")
  }
}


trait TPCHQ6Trait extends TPCHBaseTrait {
  val queryName = "Q6"

  def query() = {
    val lineItems = loadLineItems()
    tic(lineItems.size)

    //FIXME: infix_&& fails to resolve automatically
    val q = lineItems Where (l => infix_&&(l.l_shipdate >= Date("1994-01-01"), infix_&&(l.l_shipdate < Date("1995-01-01"), infix_&&(l.l_discount >= 0.05, infix_&&(l.l_discount <= 0.07, l.l_quantity < 24)))))
    val revenue = q.Sum(l => l.l_extendedprice * l.l_discount)

    toc(revenue)
    println(revenue)
  }
}

trait TPCHQ14Trait extends TPCHBaseTrait {
  val queryName = "Q14"

  def query() = {
    val parts = loadParts(); val lineItems = loadLineItems()
    tic(parts.size, lineItems.size)

    val shippedItems = lineItems.Where(li => li.l_shipdate >= Date("1995-09-01") && li.l_shipdate < Date("1995-10-01"))
    val q = parts.Join(shippedItems)(_.p_partkey, _.l_partkey)(
      (p,l) => new Record { //this post-Join Select is very boilerplate but we need to get the type right
        val l_extendedprice = l.l_extendedprice
        val l_discount = l.l_discount
        val p_type = p.p_type
      })

    val promoRevenue = q.Sum(l => if (l.p_type startsWith "PROMO") l.l_extendedprice * (1.0 - l.l_discount) else 0.0)
    val totalRevenue = q.Sum(l => l.l_extendedprice * (1.0 - l.l_discount))
    val promoPercentage = 100 * promoRevenue / totalRevenue
    toc(promoPercentage)
    println(promoPercentage)
  }
}



import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object Q1_Runner {

  def testRun(base: String) = {
    object TPCHQ1Compiler extends OptiMQLApplicationCompiler with TPCHQ1Trait with DeliteTestRunner {
      override def main() {
        System.out.println("Hello")
        println("TPC-H " + queryName)
        // tpchDataPath = unit(base)
        // query()
      }
    }
    DeliteRunner.compileAndTest(TPCHQ1Compiler)
  }

  def main(args: Array[String]) {
    if (args.length < 1) error("usage: need base dir as argument")

    val conf = new SparkConf().setAppName("Simple Application").setMaster("local[1]")
    val sc = new SparkContext(conf)

    testRun(args(0))
  }
}
