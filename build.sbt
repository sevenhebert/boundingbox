import sbt.Keys._
import sbt._

scalaVersion := "2.13.8"

lazy val app = (project in file("."))
  .settings(
    assembly / assemblyJarName := "boundingbox.jar",
    version := "0.1",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9" % Test
    )
  )

//coverageFailOnMinimum := false
//coverageMinimumStmtTotal := 80
//coverageMinimumBranchTotal := 80
coverageExcludedPackages := List(
  "boundingbox.Main",
  "boundingbox.model",
  "boundingbox.Parser",
).mkString(";")