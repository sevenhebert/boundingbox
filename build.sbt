scalaVersion := "2.13.8"

//lazy val root = (project in file("."))
//  .settings(
//    name := "bounding-box",
//    version := "0.1",
//    assembly / target := target.value
//  )

lazy val app = (project in file("."))
  .settings(
    assembly / assemblyJarName := "boundingbox.jar",
    version := "0.1",
  )

//cat $PWD/test0.txt - - | java -jar $PWD/target/scala-2.13/boundingbox.jar