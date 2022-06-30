package Stack

import scala.annotation.tailrec
import scala.collection.mutable
import scala.util.Try

// Look at this graph

// Traverse right and calc possible rectangles.
// If we height lowers calc rectangles that can no longer extend further.
object LargestRectangleInHistogram {

  def calcRectangle(input: Array[Int]): Int =
    // Not sure about types vs case classes for zipping.
    type Height        = Int
    type Index         = Int
    type IndexedHeight = (Height, Index)

    var largestSoFar = 0
    val recStack     = mutable.Stack[IndexedHeight]()
    input.zipWithIndex.foreach { (height, index) =>

      val top = Try(recStack.top)
      if (recStack.nonEmpty && height < top.get._1) // Unwrap safely as we have already checked for a n on empty stack.
        calculateRectanglesAreaLarger(height, index)

      recStack.push((height, index))
    }

    // Side effecting rec
    @tailrec
    def calculateRectanglesAreaLarger(target: Int, startingIndex: Int): Unit =
      val (tHeight, tIndex) = recStack.pop()
      largestSoFar = Math.max(largestSoFar, tHeight * (startingIndex - tIndex))
      if (tHeight > target && recStack.nonEmpty)
        calculateRectanglesAreaLarger(target, startingIndex)

    while (recStack.nonEmpty) {
      val (tHeight, tIndex) = recStack.pop()
      largestSoFar = Math.max(largestSoFar, tHeight * (input.length - tIndex))
    }

    largestSoFar
}
