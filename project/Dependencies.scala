import sbt.Keys._
import sbt._

object Dependencies {
  val Versions = Seq(
    crossScalaVersions := Seq("2.11.6", "2.12.0-M1")
  )

  object Compile {
    val jacksonModule = "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.5.2"
    val akkaHttp = Seq(
      "com.typesafe.akka" % "akka-stream-experimental_2.11" % "1.0-RC3",
      "com.typesafe.akka" % "akka-http-core-experimental_2.11" % "1.0-RC3",
      "com.typesafe.akka" % "akka-http-experimental_2.11" % "1.0-RC3",
      "com.typesafe.akka" % "akka-http-spray-json-experimental_2.11" % "1.0-RC3",
      jacksonModule
    )
    val log4j2 = Seq(
      "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.2",
      "org.apache.logging.log4j" % "log4j-api" % "2.2",
      "org.apache.logging.log4j" % "log4j-core" % "2.2"
    )
  }

  object Test {
    val scalaTest = "org.scalatest" %% "scalatest" % "2.2.2"
  }

  import Compile._
  import Test._

  val logStream = akkaHttp ++ log4j2 ++ Seq(scalaTest)
}