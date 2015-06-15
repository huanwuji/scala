import sbt.Keys._
import sbt._

object SbtBuild extends Build {
  lazy val commonSettings = Seq(
    organization := "huanwuji",
    version := "1.0",
    scalaVersion := "2.11.6"
  )

  lazy val logStream = Project(
    id = "LogStream",
    base = file("LogStream")
  )

  lazy val root = (project in file(".")).
    aggregate(logStream)


  lazy val defaultSettings = Seq(
    // compile options
    scalacOptions in Compile ++= Seq("-encoding", "UTF-8", "-target:jvm-1.8", "-feature", "-unchecked", "-Xlog-reflective-calls", "-Xlint"),
    scalacOptions in Test := (scalacOptions in Test).value.filterNot(opt =>
      opt == "-Xlog-reflective-calls" || opt.contains("genjavadoc")),
    // -XDignore.symbol.file suppresses sun.misc.Unsafe warnings
    javacOptions in compile ++= Seq("-encoding", "UTF-8", "-source", "1.8", "-target", "1.8", "-Xlint:unchecked", "-XDignore.symbol.file"),
    javacOptions in doc ++= Seq("-encoding", "UTF-8", "-source", "1.8"),
    incOptions := incOptions.value.withNameHashing(true),

    crossVersion := CrossVersion.binary,

    ivyLoggingLevel in ThisBuild := UpdateLogging.Quiet,

    licenses := Seq(("Apache License, Version 2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))),
    homepage := Some(url("https://github.com/huanwuji"))
  )
}