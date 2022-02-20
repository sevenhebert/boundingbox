package boundingbox

import boundingbox.model.{BoundingBox, Node}

import scala.annotation.tailrec

object Service {

  @tailrec
  def getNeighbors(
      rem: List[Node],
      q: List[Node],
      res: List[Node]
  ): (List[Node], List[Node]) = q match {
    case Nil => (rem, res)
    case cur :: rest =>
      val Node(x, y) = cur
      val left = Node(x - 1, y)
      val right = Node(x + 1, y)
      val top = Node(x, y - 1)
      val bottom = Node(x, y + 1)

      val neighbors = rem.intersect(List(left, right, bottom, top))
      val remainingUpdate = rem.diff(neighbors)
      getNeighbors(remainingUpdate, rest :++ neighbors, res :++ neighbors)
  }

  @tailrec
  def getBoundingBoxes(
      q: List[Node],
      res: List[Option[BoundingBox]]
  ): List[BoundingBox] = q match {
    case Nil => res.flatten
    case cur :: rest =>
      val (remaining, neighbors) = getNeighbors(rest, List(cur), List(cur))
      getBoundingBoxes(remaining, res :+ BoundingBox(neighbors))
  }

  def removeOverlapping(
      bbs: List[BoundingBox]
  )(cur: BoundingBox): Option[BoundingBox] = {
    val curIdx = bbs.indexOf(cur)

    @tailrec
    def rec(i: Int): Option[BoundingBox] =
      if (i == curIdx) Some(cur)
      else if (i >= bbs.length) rec(0)
      else if (cur.overlaps(bbs(i))) None
      else rec(i + 1)

    rec(curIdx + 1)
  }

}
