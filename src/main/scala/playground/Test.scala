// debugging fusion issues of Q6 and others
package playground

// DeliteRunner.verbose = true
// DeliteRunner.verboseDefs = true

import optiql.compiler._
import optiql.library._
import optiql.shared._
import scala.virtualization.lms.common._
import scala.virtualization.lms.internal._

trait Type { this: OptiQLApplication =>
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

  type Tmp = Record {
    val returnFlag: Char
    val lineStatus: Char
    val sumQty: Double
    val sumBasePrice: Double
    val sumDiscountedPrice: Double
    val sumCharge: Double
    val avgQty: Double
    val avgPrice: Double
    val avgDiscount: Double
    val countOrder: Int
  }
}

trait Test extends OptiQLApplication with Types {
  def query() = {
    val tab = Table.fromFile[LineItem]("/home/greg/Research/data/SF1/lineitem.tbl", ("\\|"))

    tic(tab.size)
    val q = tab Where(_.l_shipdate <= Date("1998-09-02")) GroupBy(l => pack(l.l_returnflag,l.l_linestatus)) Select(g => new Record {
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
  }
}

object TPCH1 {
  def test() = {
    object DeliteQuery extends OptiQLApplicationCompiler with Test with DeliteTestRunner {
      def main(): Unit = {
        query()
      }
    }
  DeliteRunner.compileAndTest(DeliteQuery)
  }
}
