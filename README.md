# How to
## Build
In order to build the project Scala and SBT must be installed:
<https://www.scala-lang.org/download/2.12.10.html>
<https://www.scala-sbt.org/download.html>

Once installed run: `sbt assembly` to build the executable jar.

Included in the package is an executable .jar that only requires a java interpreter if unable/unwilling to install
Scala and SBT.

The jar should be located in `/target/scala-2.13/boundingbox.jar`

## Run
At the project root run:
```
$ java -jar $PWD/target/scala-2.13/boundingbox.jar
```
To read in a corpus of text, and output the resulting bounding boxes to your shell:
```
$ cat <pathToFile> | java -jar $PWD/target/scala-2.13/boundingbox.jar

e.g., cat $PWD/src/main/resources/boundingbox/test3.txt | java -jar $PWD/target/scala-2.13/boundingbox.jar
```

