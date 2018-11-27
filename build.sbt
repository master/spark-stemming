name := "spark-stemming"

organization := "com.github.master"

spName := "master/spark-stemming"

version := "0.2.1"

sparkVersion := "2.2.0"

scalaVersion := "2.10.6"

crossScalaVersions := Seq("2.10.6", "2.11.8")

spShortDescription := "Spark MLlib wrapper for the Snowball framework"

spDescription := """Snowball is a small string processing language
                    | designed for creating stemming algorithms for
                    | use in Information Retrieval. This package allows
                    | to use it as a part of Spark ML Pipeline API.""".stripMargin

licenses := Seq("BSD 2-Clause" -> url("https://opensource.org/licenses/BSD-2-Clause"))

spDistDirectory := target.value

sparkComponents ++= Seq("mllib", "sql")

parallelExecution := false

spIncludeMaven := true

libraryDependencies ++= Seq(
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "org.scalatest" %% "scalatest" % "2.1.5" % "test"
)

sonatypeProfileName := "com.master.github"

publishMavenStyle := true

homepage := Some(url("https://github.com/master/spark-stemming"))

scmInfo := Some(
  ScmInfo(
    url("https://github.com/master/spark-stemming"),
    "scm:git@github.com:master/spark-stemming.git"
  )
)

developers := List(
  Developer(id="master", name="Oleg Smirnov", email="oleg.smirnov@gmail.com", url=url("http://nord.org.ua"))
)

publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)
