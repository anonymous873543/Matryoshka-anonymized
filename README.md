<meta name="robots" content="noindex">

# Matryoshka

This repository contains the material to run the experiments for the Matryoshka paper.

Build with `mvn clean package -DskipTests`

You will need a cluster with
* Spark 3.1.0
* Java 14
* HDFS (for Spark checkpoints)
* pdsh

The `scripts` directory contains Bash scripts to run the experiments.

You should grep for the string `TOBEFILLED` to fill in machine names, directories, etc. (both in scripts and the Scala sources)