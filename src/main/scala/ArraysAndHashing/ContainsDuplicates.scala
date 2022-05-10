package ArraysAndHashing
import scala.collection.mutable

// Very easy lmao
object ContainsDuplicates {
  def containsADuplicate(input: Seq[Int]): Boolean =
    input.toSet[Int].size != input.size
}
