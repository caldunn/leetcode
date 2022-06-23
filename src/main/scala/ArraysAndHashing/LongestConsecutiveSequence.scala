package ArraysAndHashing

import scala.annotation.tailrec

object LongestConsecutiveSequence {
  def findLongestSequence(input: Seq[Int]): Int =

    if input.isEmpty then return 0

    val workingSet = input.toSet

    @tailrec
    def longestSeq(count: Int, currentInt: Int): Int =
      if workingSet.contains(currentInt + 1) then longestSeq(count + 1, currentInt + 1)
      else count

    workingSet.fold(1) { (a, v) =>
      val count = if !workingSet.contains(v - 1) then longestSeq(1, v) else 1
      if count > a then count else a
    }

}
