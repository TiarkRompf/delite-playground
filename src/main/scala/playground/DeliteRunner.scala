package playground

import java.io.{File,FileReader,FileInputStream,PrintStream,ByteArrayOutputStream}

import scala.virtualization.lms.common._
import scala.collection.mutable
import scala.collection.mutable.{ ArrayBuffer, SynchronizedBuffer }

import ppl.delite.framework.DeliteApplication
import ppl.delite.framework.Config
import ppl.delite.runtime.graph.ops.OP_MultiLoop
import ppl.delite.runtime.graph.targets.Targets


// *** from delite test runner. call compileAndTest to run an app

trait DeliteTestConfig {
  // something arbitrary that we should never see in any test's output
  val MAGICDELIMETER = "!~x02$758209"

  val propFile = new File("delite.properties")
  val props = new java.util.Properties(System.getProperties)
  if (propFile.exists) props.load(new FileReader(propFile))

  // test parameters
  var verbose = props.getProperty("tests.verbose", "false") != "false"
  var verboseDefs = props.getProperty("tests.verboseDefs", "false") != "false"
  var threads = props.getProperty("tests.threads", "1").split(",").map(_.toInt)
  var cacheSyms = false /* NNOOOOOOOOOO!!!!!!!!!!!*/   //props.getProperty("tests.cacheSyms", "true").toBoolean
  var javaHome = new File(props.getProperty("java.home", ""))
  var scalaHome = new File(props.getProperty("scala.vanilla.home", ""))
  var runtimeClasses = new File(props.getProperty("runtime.classes", ""))
  var runtimeExternalProc = false // javaHome, scalaHome and runtimeClasses only required if runtimeExternalProc is true. should this be configurable? or should we just remove execTestExternal?
  var deliteTestTargets = props.getProperty("tests.targets", "scala").split(",")
  var useBlas = props.getProperty("tests.extern.blas", "false").toBoolean

  var cppWhiteList = Seq("StaticData", "DeliteTestMkString", "DeliteTestAppend", "DeliteTestStrConcat", "DeliteTestFwNew", //test operations are Scala-only by design
                         "DeliteTestBwNew", "DeliteTestBwWrite", "DeliteTestBwClose", "DeliteTestPrintLn", "scala.collection.mutable.ArrayBuffer",
                         "DeliteArraySeq[scala.virtualization.lms.common.Record{", "Array[scala.virtualization.lms.common.Record{") //C++ doesn't currently support non-Soa'd Array[Record]

}


object DeliteRunner extends DeliteTestConfig {
  val javaBin = new File(javaHome, "bin/java")
  val scalaCompiler = new File(scalaHome, "lib/scala-compiler.jar")
  val scalaLibrary = new File(scalaHome, "lib/scala-library.jar")

  def checkMultiLoop = false
  def enforceFullCoverage = true

  def validateParameters() {
    if (!javaHome.exists) throw new TestFailedException("java.home must be a valid path in delite.properties", 3)
    else if (!javaBin.exists) throw new TestFailedException("Could not find valid java installation in " + javaHome, 3)
    else if (runtimeExternalProc && !scalaHome.exists) throw new TestFailedException("scala.vanilla.home must be a valid path in delite.proeprties", 3)
    else if (runtimeExternalProc && (!scalaCompiler.exists || !scalaLibrary.exists)) throw new TestFailedException("Could not find valid scala installation in " + scalaHome, 3)
    else if (runtimeExternalProc && !runtimeClasses.exists) throw new TestFailedException("runtime.classes must be a valid path in delite.properties", 3)
  }

  def compileAndTest(app: DeliteTestRunner) {
    compileAndTest2(app, app.getClass.getName.replaceAll("\\$", ""))
  }

  def compileAndTest2(app: DeliteTestRunner, uniqueTestName: String, checkMultiLoop: Boolean = checkMultiLoop, enforceFullCoverage: Boolean = enforceFullCoverage) {
    println("=================================================================================================")
    println("TEST: " + app.toString)
    println("=================================================================================================")

    val degName = uniqueTestName + ".deg"
    validateParameters()
    val args = Array(degName)
    app.resultBuffer = new ArrayBuffer[Boolean] with SynchronizedBuffer[Boolean]

    // Enable specified target code generators
    for(t <- deliteTestTargets) {
      t match {
        case "scala" =>
        case "cuda" => Config.generateCUDA = true; Config.generateCpp = true
        case "cpp" => Config.generateCpp = true
        case "opencl" => Config.generateOpenCL = true; Config.generateCpp = true
        case _ => println("Unknown test target: " + t)
      }
    }

    //enable strict checking that scala and cpp kernels are actually generated
    if (enforceFullCoverage) {
      Config.generationFailedWhitelist += "scala" -> Seq() //no exceptions
      Config.generationFailedWhitelist += "cpp" -> cppWhiteList //exclude ops provided by test suite
    }

    if(useBlas) Config.useBlas = true

    // check if all multiloops in the test app are generated for specified targets
    if(checkMultiLoop) {
      val generateCUDA = Config.generateCUDA
      Config.generateCUDA = true
      stageTest(app, degName, uniqueTestName)
      val graph = ppl.delite.runtime.Delite.loadDeliteDEG(degName)
      val targets = List("scala","cuda") // Add other targets
      for(op <- graph.totalOps if op.isInstanceOf[OP_MultiLoop]) {
        targets foreach { t =>  if(!op.supportsTarget(Targets(t))) sys.error(t + " was unable to generate op " + op) }
      }
      Config.generateCUDA = generateCUDA
    }
    else { // Just stage test
      stageTest(app, degName, uniqueTestName)
    }

    // Set runtime parameters for targets and execute runtime
    for(target <- deliteTestTargets) {
      for (num <- threads) {
        def runtimeConfig(numScala: Int = 1, numCpp: Int = 0, numCuda: Int = 0, numOpenCL: Int = 0) {
          ppl.delite.runtime.Config.numThreads = numScala
          ppl.delite.runtime.Config.numCpp = numCpp
          ppl.delite.runtime.Config.numCuda = numCuda
          ppl.delite.runtime.Config.numOpenCL = numOpenCL
          ppl.delite.runtime.Config.testMode = true
        }

        target match {
          case "scala" => runtimeConfig(numScala = num)
          case "cpp" => runtimeConfig(numCpp = num)
          case "cuda" => runtimeConfig(numScala = num, numCpp = 1, numCuda = 1) // C++ kernels launched on GPU host
          case "opencl" => runtimeConfig(numScala = num, numOpenCL = 1)
          case _ => assert(false)
        }
        val outStr = execTest(app, args, target, num)
        checkTest(app, outStr)
        System.gc()
      }
    }
  }

  def stageTest(app: DeliteTestRunner, degName: String, uniqueTestName: String) = {
    println("STAGING...")
    val save = Config.degFilename
    val buildDir = Config.buildDir
    val saveCacheSyms = Config.cacheSyms
    val generatedDir = (new File("generated")).getAbsolutePath + /*protobuf wants absolute path*/
      java.io.File.separator + uniqueTestName
    try {
      Config.degFilename = degName
      Config.buildDir = generatedDir
      Config.cacheSyms = cacheSyms
      //Config.generateCUDA = true
      val screenOrVoid = if (verbose) System.out else new PrintStream(new ByteArrayOutputStream())
      Console.withOut(screenOrVoid) {
        app.main(Array())
        if (verboseDefs) app.globalDefs.foreach { d => //TR print all defs
          println(d)
          //val s = d match { case app.TP(sym,_) => sym; case app.TTP(syms,_,_) => syms(0); case _ => sys.error("unknown Stm type: " + d) }
          //val info = s.sourceInfo.drop(3).takeWhile(_.getMethodName != "main")
          //println(info.map(s => s.getFileName + ":" + s.getLineNumber).distinct.mkString(","))
        }
        //assert(!app.hadErrors) //TR should enable this check at some time ...
      }
    } finally {
      // concurrent access check
      assert(Config.buildDir == generatedDir)
      Config.degFilename = save
      Config.buildDir = buildDir
      Config.cacheSyms = saveCacheSyms
    }
  }

  def execTest(app: DeliteTestRunner, args: Array[String], target: String, threads: Int) = {
    println("EXECUTING(" + target + ":" + threads + ")...")
    val name = "test.tmp"
    // Changed mkReport to directly write to a file instead of trying to capture the output stream here.
    // This is to make the C target testing work, because native C stdout is not captured by this.
    val screenOrVoid = if (verbose) System.out else new PrintStream(new ByteArrayOutputStream())
    //TR Console.withOut(screenOrVoid) {
      println("test output for: " + app.toString)
      ppl.delite.runtime.Delite.embeddedMain(args, app.staticDataMap)
    //}
    /*TR val reportFile = new File(name)
    val buf = new Array[Byte](reportFile.length.toInt)
    val fis = new FileInputStream(name)
    fis.read(buf)
    fis.close()
    reportFile.delete() //we don't want any other test to find this file
    new String(buf)*/
    ""
  }


  def checkTest(app: DeliteTestRunner, outStr: String) {
    println("CHECKING...")
    /*val resultStr = outStr substring (outStr.indexOf(MAGICDELIMETER) + MAGICDELIMETER.length, outStr.lastIndexOf(MAGICDELIMETER))
    val results = resultStr split ","
    for (i <- 0 until results.length) {
      if (verbose) print("  condition " + i + ": ")
      val passed = results(i).toLowerCase() == "true"
      if (verbose)
        if (passed) println("PASSED") else println("FAILED")
      assert(passed)
    }*/
  }
}


class TestFailedException(s: String, i: Int) extends Exception(s)

trait DeliteTestOpsExp extends SynchronizedArrayBufferOpsExp

trait DeliteTestRunner extends DeliteTestModule with DeliteTestConfig with DeliteTestOpsExp with DeliteApplication {
  var resultBuffer: ArrayBuffer[Boolean] = _

  def collector: Rep[ArrayBuffer[Boolean]] = staticData(resultBuffer)
  def collect(s: Rep[Boolean]) = { collector += s }/*delite_test_append(collector, s)*/

  def mkReport(): Rep[Unit] = {
    /*val out = delite_test_bw_new(delite_test_fw_new(unit("test.tmp")))
    val s1 = delite_test_strconcat(unit(MAGICDELIMETER), (delite_test_mkstring(collector, unit(","))))
    val s2 = delite_test_strconcat(s1, unit(MAGICDELIMETER))
    delite_test_bw_write(out, s2)
    delite_test_bw_close(out)*/
  }

}

trait DeliteTestModule extends Base {
  def collect(s: Rep[Boolean]): Rep[Unit]
  def mkReport(): Rep[Unit]
}


