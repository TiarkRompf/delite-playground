// debugging fusion issues of Q6 and others

// DeliteRunner.verbose = true
// DeliteRunner.verboseDefs = true

object DeliteQuery extends OptiQLApplicationCompiler with DeliteTestRunner { def main(): Unit = {
  // TODO: recreate what Q6 does internally and compare

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


  val tab = Table.fromFile[LineItem](file_lineitem, ("\\|"))

  val q = tab Where(_.l_shipdate <= Date("1998-12-01")) GroupBy(l => tup2_pack(l.l_returnflag, l.l_linestatus)) Select(gk => {
    new Record {
      val returnFlag = gk._1._1
      val lineStatus = gk._1._2
      val sumQty = gk._2.Sum(_.l_quantity)
      val sumBasePrice = gk._2.Sum(_.l_extendedprice)
      val sumDiscountedPrice = gk._2.Sum(l => l.l_extendedprice * (unit[Double](1.0) - l.l_discount))                // FIXME: ambiguous numeric ops problem and compiler crash in 2.10.0
      val sumCharge = gk._2.Sum(l=> l.l_extendedprice * (unit[Double](1.0) - l.l_discount) * (unit[Double](1.0) + l.l_tax))   // FIXME: ambiguous numeric ops problem and compiler crash in 2.10.0
      val avgQty = gk._2.Average(_.l_quantity)
      val avgPrice = gk._2.Average(_.l_extendedprice)
      val avgDiscount = gk._2.Average(_.l_discount)
      val countOrder = gk._2.Count
    }
  }) OrderBy { (x: Rep[Tmp], y: Rep[Tmp]) =>
    val tmp = x.returnFlag.asInstanceOf[Rep[Int]] - y.returnFlag.asInstanceOf[Rep[Int]]
    if (tmp == 0)
      x.lineStatus.asInstanceOf[Rep[Int]] - y.lineStatus.asInstanceOf[Rep[Int]]
    else
      tmp
  }
  q.printAsTable()

} }
DeliteRunner.compileAndTest(DeliteQuery)
