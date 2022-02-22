package boundingbox

object model {

  case class Node(r: Int, c: Int)

  case object BoundingBox {
    def apply(ns: List[Node]): Option[BoundingBox] =
      if (ns.length > 1) Some(BoundingBox(
        ns.minBy(_.r).r,
        ns.maxBy(_.c).c,
        ns.maxBy(_.r).r,
        ns.minBy(_.c).c
      ))
      else None
  }

  case class BoundingBox(top: Int, right: Int, bottom: Int, left: Int) {
    override def toString = s"(${top + 1},${left + 1})(${bottom + 1},${right + 1})"

    def overlaps(bb: BoundingBox): Boolean = {
      val nbrY = bb.top to bb.bottom
      val nbrX = bb.left to bb.right
      val yOverlap = nbrY.contains(top) || nbrY.contains(bottom)
      val xOverlap = nbrX.contains(left) || nbrX.contains(right)
      yOverlap && xOverlap
    }
  }

}
