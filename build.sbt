name := "spark-stemming"

organization := "com.github.master"

spName := "master/spark-stemming"

version := "0.2.0"

sparkVersion := "2.2.0"

scalaVersion := "2.10.6"

crossScalaVersions := Seq("2.10.6", "2.11.8")

spAppendScalaVersion := true

spShortDescription := "Spark MLlib wrapper for the Snowball framework"

spDescription := """Snowball is a small string processing language
                    | designed for creating stemming algorithms for
                    | use in Information Retrieval. This package allows
                    | to use it as a part of Spark ML Pipeline API.""".stripMargin

licenses := Seq("BSD 2-Clause" -> url("https://opensource.org/licenses/BSD-2-Clause"))

spDistDirectory := target.value

sparkComponents ++= Seq("mllib", "sql")

parallelExecution := false

credentials += Credentials(Path.userHome / ".sbt" / "sparkpkg-credentials")

libraryDependencies ++= Seq(
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "org.scalatest" %% "scalatest" % "2.1.5" % "test"
)
