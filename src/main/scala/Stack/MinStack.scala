package Stack

import scala.collection.mutable.ListBuffer
import scala.math.Ordering.Implicits.infixOrderingOps

class MinStack[A: Ordering] {
  case class Node(min: A, element: A)
  private val stack = ListBuffer[Node]()

  def push(element: A): Unit =
    val minimum = stack.headOption match
      case None    => element
      case Some(x) => element min x.min

    stack.prepend(Node(minimum, element))

  private def popNode: Node =
    val head = stack.head
    stack.dropInPlace(1)
    head

  def pop: A = popNode.element

  def top: A = stack.head.element

  def getMin: A =
    stack.head.min
}
