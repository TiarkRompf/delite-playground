name := "delite-playground"

version := "0.1"

resolvers += Resolver.mavenLocal

scalaVersion := "2.11.2"

scalaOrganization := "org.scala-lang.virtualized"

scalacOptions += "-Yvirtualize"

// tests are not thread safe
parallelExecution in Test := false


libraryDependencies += "org.scala-lang.virtualized" % "scala-compiler" % "2.11.2"

libraryDependencies += "jline" % "jline" % "2.11"

libraryDependencies += "EPFL" %% "lms" % "0.3-SNAPSHOT"

libraryDependencies += "stanford-ppl" %% "framework" % "0.1-SNAPSHOT"

libraryDependencies += "stanford-ppl" %% "runtime" % "0.1-SNAPSHOT"

//libraryDependencies += "stanford-ppl" %% "optiml" % "0.1-SNAPSHOT"

libraryDependencies += "stanford-ppl" %% "optiql" % "0.1-SNAPSHOT"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.6.0"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "1.6.0"

libraryDependencies += "com.databricks" %% "spark-csv" % "1.2.0"

//libraryDependencies += "com.google.protobuf" % "protobuf-java" % "2.4.1"

libraryDependencies += "com.google.guava" % "guava" % "14.0.1"

// do not include repl scripts in assembly
sourcesInBase := false

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
  {
  	// Delite and lms use scala-virtualized instead of plain scala.
  	// For assembly, we want to pick the virtualized versions of
  	// scala-library and scala-compiler.
    case PathList("scala", xs @ _*) => MergeStrategy.first // Is first vs last deterministic?
    case "interactive.properties" => MergeStrategy.last
    case "compiler.properties" => MergeStrategy.last
    case "library.properties" => MergeStrategy.last
    case "reflect.properties" => MergeStrategy.last
    case "scaladoc.properties" => MergeStrategy.last
    case "repl.properties" => MergeStrategy.last
    case PathList("com", "google", "common", xs @ _*) => MergeStrategy.last
    /* --- */
    case PathList("javax", "servlet", xs @ _*) => MergeStrategy.last
    case PathList("org", "apache", xs @ _*) => MergeStrategy.last
    case PathList("com", "esotericsoftware", xs @ _*) => MergeStrategy.last
    case "about.html" => MergeStrategy.rename
    case x => old(x)
  }
}

