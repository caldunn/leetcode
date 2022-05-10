package ArraysAndHashing

import scala.annotation.tailrec
import scala.collection.mutable

object TwoSum {
  def find(input: Seq[Int], target: Int): (Int, Int) =
    val map = mutable.Map[Int, Int]()

    if input.isEmpty then return (0, 0)

    @tailrec
    def recurse(index: Int): (Int, Int) =
      val cv = input(index)
      val tv = target - cv
      if map.contains(tv) then (map(tv), index)
      else {
        map(cv) = index
        // Question does not need guard as guaranteed to contain
        if index == input.length then (0, 0) else recurse(index + 1)
      }

    recurse(0)
}
