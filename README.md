# How to
## Design
* Collect a set of input values and their indices where the character is a '*'
* Breath first search for neighboring values
* Once the first BFS exits with a group of neighbors, take the remaining set and run the same BFS as before
* Once the set of (non-grouped) input values is empty find the (top, left) and (bottom, right) box boundaries from each group of neighbors
* Check each resulting bounding box against permutations of the result set to find and eliminate overlapping boxes 

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
To read in a corpus of text, and output the resulting bounding boxes to your shell run:
```
$ cat <pathToFile> | java -jar $PWD/target/scala-2.13/boundingbox.jar

e.g., cat $PWD/src/test/resources/boundingbox/test3.txt | java -jar $PWD/target/scala-2.13/boundingbox.jar
```

## Run the unit tests:
```
$ sbt clean coverage test
```
To generate the coverage reports (after running the tests) run:
```
$ sbt coverageReport
```
The html report should be located here: `/bounding-box/target/scala-2.13/scoverage-report/index.html`
