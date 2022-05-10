package ArraysAndHashing

import scala.collection.mutable

object TopKElements {
  def topK(input: Seq[Int], k: Int): Seq[Int] =
    val map = mutable.Map[Int, Int]()
    input.foreach { x =>
      if map.contains(x) then map(x) += 1
      else map(x) = 1
    }
    map
      .toList
      .sorted
      .reverse
      .take(k)
      .map(e => e._2)
}
