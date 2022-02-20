package boundingbox

object model {

  case class Node(x: Int, y: Int)

  case object BoundingBox {
    def apply(ns: List[Node]): Option[BoundingBox] =
      if (ns.length > 1)
        Some(
          BoundingBox(
            ns.minBy(_.y).y,
            ns.maxBy(_.x).x,
            ns.maxBy(_.y).y,
            ns.minBy(_.x).x
          )
        )
      else None
  }

  case class BoundingBox(top: Int, right: Int, bottom: Int, left: Int) {
    override def toString = s"($left,$top)($right,$bottom)"

    def overlaps(bb: BoundingBox): Boolean = {
      val nbrY = bb.top to bb.bottom
      val nbrX = bb.left to bb.right
      val yOverlap = nbrY.contains(top) || nbrY.contains(bottom)
      val xOverlap = nbrX.contains(left) || nbrX.contains(right)
      yOverlap && xOverlap
    }
  }

}
