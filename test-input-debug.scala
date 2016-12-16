// debugging fusion issues of Q6 and others

DeliteRunner.verbose = true
DeliteRunner.verboseDefs = true

val q6 = getQuery(tpch_string, "tpch6")._2

testDelite(q6)


object DeliteQuery extends OptiQLApplicationCompiler with DeliteTestRunner { def main(): Unit = { 
    // TODO: recreate what Q6 does internally and compare
    trait TYPE
    implicit val mf: Manifest[TYPE] = ManifestFactory.refinedType[Record](
                    manifest[Record],
                    List("r_regionkey","r_name","r_comment"),
                    List(manifest[Int], manifest[String], manifest[String])).asInstanceOf[Manifest[TYPE]]

    val res = Table.fromFile[TYPE](file_region, ("\\|")).asInstanceOf[Rep[Table[Record]]]
    infix_printAsTable(res, 20)(mf.asInstanceOf[Manifest[Record]], implicitly[SourceContext])
} }
DeliteRunner.compileAndTest(DeliteQuery)
