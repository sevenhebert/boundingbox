package boundingbox

import boundingbox.model.Node

import scala.annotation.tailrec
import scala.io.StdIn.readLine

object Parser {

  def parse: List[Node] = {

    @tailrec
    def rec(ri: Int, input: List[Node]): List[Node] = readLine match {
      case line if line == null => input
      case line =>
        val row = line.zipWithIndex.collect {
          case (char, ci) if char == '*' => Node(ri, ci)
        }.toList
        rec(ri + 1, input :++ row)
    }

    rec(0, List.empty)
  }

}
