name := "delite-playground"

version := "0.1"

scalaVersion := "2.11.2"

scalaOrganization := "org.scala-lang.virtualized"

scalacOptions += "-Yvirtualize"

// tests are not thread safe
parallelExecution in Test := false

libraryDependencies += "org.scala-lang.virtualized" % "scala-compiler" % "2.11.2"

libraryDependencies += "EPFL" %% "lms" % "0.3-SNAPSHOT"

libraryDependencies += "stanford-ppl" %% "framework" % "0.1-SNAPSHOT"

libraryDependencies += "stanford-ppl" %% "runtime" % "0.1-SNAPSHOT"

//libraryDependencies += "stanford-ppl" %% "optiml" % "0.1-SNAPSHOT"

libraryDependencies += "stanford-ppl" %% "optiql" % "0.1-SNAPSHOT"


libraryDependencies += "com.google.protobuf" % "protobuf-java" % "2.4.1"