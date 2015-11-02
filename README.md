Delite Playground
=================

This repository contains some example [Delite](http://stanford-ppl.github.io/Delite/)
and Spark programs.

To run (assuming tpchdir holds lineitem.csv file):

    sbt assembly
    java -jar target/scala-2.11/delite-playground-assembly-0.1.jar <tpchdir>

To launch an interactive Spark shell with Delite support (assuming Spark is installed in `../spark`):

    java -cp ~/.ivy2/cache/com.google.guava/guava/jars/guava-11.0.2.jar:target/scala-2.11/delite-playground-assembly-0.1.jar:../spark/assembly/target/scala-2.11/spark-assembly-1.5.1-hadoop2.2.0.jar -Dscala.usejavacp=true -noverify org.apache.spark.repl.Main

But first, build and install the artifacts from the
[Hyperdsl](https://github.com/stanford-ppl/hyperdsl)
repository.

Hyperdsl: tested with branch wip-master (commit 338a2cd3bb07802525b26f14109093dd78120e9c), Forge bumped to commit 3324f3394e264f9e2bf8942d8de9d7f4dfc4b9b8, scala-version set to 2.11 in build.sbt

    hyperdsl$ sbt publish-local
    hyperdsl$ forge/bin/update -j ppl.dsl.forge.dsls.optiql.OptiQLDSLRunner OptiQL
    hyperdsl$ cd published/OptiQL
    hyperdsl/published/OptiQL$ sbt "; project OptiQL-shared; publish-local; project OptiQL-lib; publish-local; project OptiQL-comp; publish-local; project OptiQL-apps; publish-local; project OptiQL; publish-local; project OptiQL-ident; publish-local;"

Spark support: use Spark version 1.5.1 and if you are building locally, make sure to compile for Scala 2.11

    spark$ ./dev/change-scala-version.sh 2.11
    spark$ mvn -Dscala-2.11 -DskipTests clean package


