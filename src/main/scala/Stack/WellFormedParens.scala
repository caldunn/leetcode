package Stack

import scala.annotation.tailrec
import scala.collection.mutable
/* Basic rubber chicken talk.
=> grab n
=> Split 2 paths for each n
  => pop the stack & leave counter
  => push to stack & decrement counter
 * */
object WellFormedParens {

  sealed trait StateT(word: String)
  private case class StateN(open: Int, closed: Int, word: String) extends StateT(word)
  private case class Base(word: String)                           extends StateT(word)

  def generateWellFormedParens(n: Int): Set[String] =
    val uniqueSet = mutable.Set[String]()

    // I got stumped and took the easy recursive way out.
    def branch(state: StateT): Unit = state match {
      case Base(word) => uniqueSet.add(s"\"$word\"")
      case StateN(open, closed, word) =>
        if (open == closed && open == n) branch(Base(word))
        if (open < n) branch(StateN(open + 1, closed, s"$word("))
        if (closed < open) branch(StateN(open, closed + 1, s"$word)"))
    }

    branch(StateN(0, 0, ""))
    uniqueSet.toSet

}
