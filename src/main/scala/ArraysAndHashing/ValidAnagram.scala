package ArraysAndHashing

import scala.collection.mutable

object ValidAnagram {

  // Q 242
  def isValidAnagram(s: String): Boolean =
    s == s.reverse

  // Q 49
  def groupAnagrams(input: Seq[String]): Seq[Seq[String]] =
    val map = mutable.Map[String, mutable.ArrayBuffer[String]]()
    input.foreach { s =>
      val sorted = s.sorted
      if map.contains(sorted) then map(sorted).append(s)
      else map(sorted) = mutable.ArrayBuffer(s)
    }
    // Convert
    map.map { e =>
      e._2.toList
    }.toList

}
