# Spark Stemming

[![Build Status](https://travis-ci.org/master/spark-stemming.svg?branch=master)](https://travis-ci.org/master/spark-stemming)

[Snowball](http://snowballstem.org/) is a small string processing language
designed for creating stemming algorithms for use in Information Retrieval.
This package allows to use it as a part of [Spark ML
Pipeline](https://spark.apache.org/docs/latest/ml-guide.html) API.

## Linking

Link against this library using SBT:

```
libraryDependencies += "com.github.master" %% "spark-stemming" % "0.2.1"
```

Using Maven:

```xml
<dependency>
    <groupId>com.github.master</groupId>
    <artifactId>spark-stemming_2.10</artifactId>
    <version>0.2.0</version>
</dependency>
```

Or include it when starting the Spark shell:

```
$ bin/spark-shell --packages com.github.master:spark-stemming_2.10:0.2.1
```

## Features

Currently implemented algorithms:

* Arabic
* English
* English (Porter)
* Romance stemmers:
  * French
  * Spanish
  * Portuguese
  * Italian
  * Romanian
* Germanic stemmers:
  * German
  * Dutch
* Scandinavian stemmers:
  * Swedish
  * Norwegian (Bokmål)
  * Danish
* Russian
* Finnish
* Greek

More details are on the [Snowball stemming algorithms](http://snowballstem.org/algorithms/) page.

## Usage

`Stemmer`
[Transformer](https://spark.apache.org/docs/latest/ml-guide.html#transformers)
can be used directly or as a part of ML
[Pipeline](https://spark.apache.org/docs/latest/ml-guide.html#pipeline). In
particular, it is nicely combined with
[Tokenizer](https://spark.apache.org/docs/latest/ml-features.html#tokenizer).

```scala
import org.apache.spark.mllib.feature.Stemmer

val data = sqlContext
  .createDataFrame(Seq(("мама", 1), ("мыла", 2), ("раму", 3)))
  .toDF("word", "id")

val stemmed = new Stemmer()
  .setInputCol("word")
  .setOutputCol("stemmed")
  .setLanguage("Russian")
  .transform(data)

stemmed.show
```
