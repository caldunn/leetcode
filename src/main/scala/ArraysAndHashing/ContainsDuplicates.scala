package ArraysAndHashing
import scala.collection.mutable

// Very easy lmao -> Not very functional.
/* */
object ContainsDuplicates {
  def containsADuplicate(input: Seq[Int]): Boolean =
    val mUniqueSet = mutable.Set[Int]()
    for i <- input do
      val isAdded = mUniqueSet.add(i)
      if !isAdded then return true

    false

}
