package boundingbox

import boundingbox.model.Node

import scala.util.{Failure, Success, Try}

object TestParser {

  def parse(path: String): List[Node] = Try(
    io.Source
      .fromResource(path)
      .getLines
      .zipWithIndex
      .toList
      .flatMap { case (str, row) => str
        .zipWithIndex
        .collect { case (char, col) if char == '*' => Node(row, col)
        }
      }
  ) match {
    case Failure(err) => throw new Exception(err.getMessage)
    case Success(res) => res
  }

}
