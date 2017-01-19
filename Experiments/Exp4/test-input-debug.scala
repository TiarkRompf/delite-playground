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


  val tab = Table.fromFile[LineItem](file_lineitem, ("\\|"))

  val q = tab Where (l => l.l_shipdate >= Date("1994-01-01") && l.l_shipdate < Date("1995-01-01") && l.l_discount >= 0.05 && l.l_discount <= 0.07 && l.l_quantity < 24.0)
  val res = q.Sum(l => l.l_extendedprice * l.l_discount)

  println(res)
} }
DeliteRunner.compileAndTest(DeliteQuery)
