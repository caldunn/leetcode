package Stack

import scala.collection

object CarFleets {
  def asCarFleets(target: Int, positions: Array[Int], speeds: Array[Int]): Int =
    val mutStack = collection.mutable.Stack[Int]()
    val zippedAndSorted = positions.zip(speeds).sortWith { (x, y) => x._1 < y._1 }.reverse
    zippedAndSorted.foreach { e =>
      val lastVal = if mutStack.nonEmpty then mutStack.top else Int.MaxValue
      mutStack.push((target - e._1) / e._2)
      if mutStack.length >= 2 && mutStack.top <= lastVal then mutStack.pop()
    }
    println(mutStack.length)
    mutStack.length
}
