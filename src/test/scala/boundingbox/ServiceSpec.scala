package boundingbox

import boundingbox.model.BoundingBox

class ServiceSpec extends UnitSpec {

  private val service = Service

  "Service.getBoundingBoxes test0.txt" should "return a single bounding box with coordinates (1,1)(2,2)" in {
    val file = "boundingbox/test0.txt"
    val input = TestParser.parse(file)
    val result = service.getBoundingBoxes(input, List.empty)

    val expect = List(BoundingBox(1, 2, 2, 1))
    assert(result == expect)
  }

  "Service.getBoundingBoxes test1.txt" should "return multiple bounding boxes with coordinates (0,0)(1,1), (0,8)(2,11), (1,4)(3,9)" in {
    val file = "boundingbox/test1.txt"
    val input = TestParser.parse(file)
    val result = service.getBoundingBoxes(input, List.empty)

    val expect = List(
      BoundingBox(0, 1, 1, 0),
      BoundingBox(0, 11, 2, 8),
      BoundingBox(1, 9, 3, 4)
    )
    assert(result == expect)
  }

  "Service.removeOverlapping test1.txt" should "return a result set with a single bounding box" in {
    val bbs = List(
      BoundingBox(0, 1, 1, 0),
      BoundingBox(0, 11, 2, 8),
      BoundingBox(1, 9, 3, 4)
    )
    val result = bbs.flatMap(bb => service.removeOverlapping(bbs)(bb))
    val expect = List(BoundingBox(0, 1, 1, 0))
    assert(result == expect)
  }

}
