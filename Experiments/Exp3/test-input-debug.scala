// debugging fusion issues of Q6 and others

// DeliteRunner.verbose = true
// DeliteRunner.verboseDefs = true

object DeliteQuery extends OptiQLApplicationCompiler with DeliteTestRunner { def main(): Unit = {
  // TODO: recreate what Q6 does internally and compare
  type Nation = Record {
    val n_nationkey: Int
    val n_name: String
    val n_regionkey: Int
    val n_comment: String
  }

  val tab = Table.fromFile[Nation](file_nation, ("\\|"))

  val res = tab Where { g => g.n_regionkey > 0 } GroupBy { l => l.n_regionkey } Select {
    g => new Record {
      val n_regionkey = g.key
      val count = g.Count
    }
   }

  res.printAsTable()
} }
DeliteRunner.compileAndTest(DeliteQuery)
