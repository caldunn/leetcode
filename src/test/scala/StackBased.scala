import Stack.*

class StackBased extends BaseFlatSpec {
  // Return a boolean to predicate => Is there a duplicate?
  "20 - Valid Parens" should "Single Set" in {
    val res = ValidParens.validateParens("()")
    assertResult(true)(res)
  }
  it should "2 pair single depth" in {
    val res = ValidParens.validateParens("()[]")
    assertResult(true)(res)
  }
  it should "enclosing pairs" in {
    val res = ValidParens.validateParens("([{}])")
    assertResult(true)(res)
  }
  it should "fail on unclosed" in {
    val res = ValidParens.validateParens("({}")
    assertResult(false)(res)
  }
  it should "pass on out of order" in {
    val res = ValidParens.validateParens("({)}")
    assertResult(false)(res)
  }

  "155 - Min Stack" should "Be stacklike (push & pop)" in {
    val stack = MinStack[Int]()
    stack.push(1)
    stack.push(2)
    val a = stack.pop
    val b = stack.pop
    assertResult((2, 1))((a, b))
  }
  it should "expect a thrown NoSuchElementException on popping/topping/getminning of empty stack" in {
    val stack = MinStack[Int]()
    assertThrows[NoSuchElementException](stack.pop)
    assertThrows[NoSuchElementException](stack.top)
    assertThrows[NoSuchElementException](stack.getMin)
  }
  it should "pass leetcodes example" in {
    val stack = MinStack[Int]()

    stack.push(-2)
    stack.push(0)
    stack.push(-3)
    val firstMin  = stack.getMin
    val firstPop  = stack.pop
    val firstTop  = stack.top
    val secondMin = stack.getMin

    assertResult((-3, -3, 0, -2))((firstMin, firstPop, firstTop, secondMin))
  }
}
