package boundingbox

import boundingbox.Parser.{parse => input}
import boundingbox.Service.{getBoundingBoxes, removeOverlapping}

object Main extends App {

  val boundingBoxes = getBoundingBoxes(input, List.empty)
  val results = boundingBoxes.flatMap(removeOverlapping(boundingBoxes))
  results.foreach(bb => println(bb.toString))

}
