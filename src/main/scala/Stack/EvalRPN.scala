package Stack
import scala.collection.mutable

object EvalRPN {
  type TwoOps = (Int, Int) => Int
  private val validOps: collection.Map[String, TwoOps] = scala
    .collection
    .Map(
      "+" -> ((x: Int, y: Int) => x + y),
      "-" -> ((x: Int, y: Int) => x - y),
      "/" -> ((x: Int, y: Int) => x / y),
      "*" -> ((x: Int, y: Int) => x * y)
    )
  def evaluate(input: Seq[String]): Int =
    val calcStack = mutable.Stack[String]()
    input.foreach { e =>
      var res = e
      if (validOps.contains(e))
        val (op2, op1) = (calcStack.pop().toInt, calcStack.pop().toInt)
        res = validOps(e).apply(op1, op2).toString

      calcStack.push(res)

    }

    calcStack.top.toInt
}
