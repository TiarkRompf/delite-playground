Delite Playground
=================

This repository contains some example [Delite](http://stanford-ppl.github.io/Delite/)
and Spark programs.

To build:

    sbt assembly

To launch an interactive Spark shell with Delite support (assuming Spark is installed in `$SPARK_HOME` and delite-playground in `$DELITE_PLAY`):

    java -cp $DELITE_PLAY/target/scala-2.11/delite-playground-assembly-0.1.jar:$SPARK_HOME/conf/:$SPARK_HOME/assembly/target/scala-2.11/jars/* -Dscala.usejavacp=true -Xmx512g org.apache.spark.deploy.SparkSubmit --class org.apache.spark.repl.Main spark-shell


But first, build and install the artifacts from the
[Hyperdsl](https://github.com/stanford-ppl/hyperdsl)
repository.

Hyperdsl: tested with branch wip-master (commit 338a2cd3bb07802525b26f14109093dd78120e9c), Forge from [Gregory Essertel](https://github.com/GSAir/Forge) repository branch develop, scala-version set to 2.11 in build.sbt

In hyperdsl, modify the .gitmodules file as follow:

    [submodule "forge"]
            path = forge
            url = https://github.com/GSAir/Forge.git

Then install:

    hyperdsl$ git submodulte update --init
    hyperdsl$ cd forge
    forge$ git checkout develop
    forge$ cd ../delite
    delite$ git checkout develop
    delite$ cd ..
    hyperdsl$ git checkout 338a2cd3bb07802525b26f14109093dd78120e9c
    hyperdsl$ source init-env.sh
    hyperdsl$ sbt publish-local
    hyperdsl$ forge/bin/update -j ppl.dsl.forge.dsls.optiql.OptiQLDSLRunner OptiQL
    hyperdsl$ cd published/OptiQL
    hyperdsl/published/OptiQL$ sbt "; project OptiQL-shared; publish-local; project OptiQL-lib; publish-local; project OptiQL-comp; publish-local; project OptiQL-apps; publish-local; project OptiQL; publish-local; project OptiQL-ident; publish-local"

Spark support: use Spark version 2.0.0 (tag v2.0.0-rc2). To build it locally:

    spark$ build/mvn -DskipTests clean install


