package BinarySearching

import scala.annotation.{tailrec, targetName}

object BinarySearch {
  def search(input: Vector[Int], target: Int): Int =
    @tailrec
    def recurse(low: Int, high: Int): Int =
      if (low > high)
        -1
      else
        val mid = (low + high) / 2
        input(mid) match
          case x if x == target => x
          case x if x < target => recurse(mid + 1, high)
          case _ => recurse(low, mid - 1)

    recurse(0, input.length - 1)


  @targetName("search2d")
  def search(input: Vector[Vector[Int]], target: Int): Int =
    val rowSize = input(0).length

    @tailrec
    def recurse(low: Int, high: Int): Int =
      if (low > high)
        -1
      else
        val mid = (low + high) / 2
        input(mid / rowSize)(mid % rowSize) match
          case x if x == target => x
          case x if x < target => recurse(mid + 1, high)
          case _ => recurse(low, mid - 1)

    recurse(0, (input.last.length - 1) * rowSize)
}
