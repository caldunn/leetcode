package Heaps

class KthLargest(k: Int, nums: Array[Int]) {
  private val heap = Node(nums.head, None, None)
  case class Node(num: Int, var leftChild: Option[Node], var rightChild: Option[Node]) {
    def isLeaf: Boolean = leftChild.isEmpty && rightChild.isEmpty
  }
  private def fromInput() =
    // Create first node.
    nums.drop(1).foreach { e => }

  private def traverse(value: Int, node: Node): Unit =
    if (value < node.num) // Go left if true
      if (node.isLeaf)
        node.leftChild = Some(Node(value, None, None))
      // else traverse(value, node.leftChild)
}
