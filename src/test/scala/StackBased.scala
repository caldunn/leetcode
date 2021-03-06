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

  "155 - Well formed" should "just werkz" in {
    Stack.WellFormedParens.generateWellFormedParens(2)
  }

  "739 - Daily Temps - Just leetcode samples" should "Example 1" in {
    val res =
      Stack.DailyTemps.getDailyTemps(Array(73, 74, 75, 71, 69, 72, 76, 73))
    val real = Array(1, 1, 4, 2, 1, 1, 0, 0)

    assertResult(real)(res)
  }

  it should "Example 2" in {
    val res =
      Stack.DailyTemps.getDailyTemps(Array(73, 74, 75, 71, 69, 72, 76, 73))
    val real = Array(1, 1, 4, 2, 1, 1, 0, 0)

    assertResult(real)(res)
  }

  "854 - Cars - Just leetcode samples" should "Example 1" in {
    val res =
      Stack
        .CarFleets
        .asCarFleets(
          12,
          Array(10, 8, 0, 5, 3),
          Array(2, 4, 1, 1, 3)
        )
    val real = 3

    assertResult(real)(res)
  }
  it should "Example 2" in {
    val res =
      Stack
        .CarFleets
        .asCarFleets(
          100,
          Array(0, 2, 4),
          Array(4, 2, 1)
        )
    val real = 1

    assertResult(real)(res)
  }

  "150 - Evaluate RPN" should "Example 1" in {
    val res  = EvalRPN.evaluate(Array("2", "1", "+", "3", "*"))
    val real = 9

    assertResult(real)(res)
  }
  it should "Ex 2" in {
    val res  = EvalRPN.evaluate(Array("4", "13", "5", "/", "+"))
    val real = 6

    assertResult(real)(res)
  }
  it should "Ex 3" in {
    val res  = EvalRPN.evaluate(Array("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"))
    val real = 22

    assertResult(real)(res)
  }

  "84 - Histogram rectangles" should "Rectangle at end" in {
    val res  = LargestRectangleInHistogram.calcRectangle(Array(2, 1, 3, 7, 7, 7))
    val real = 21

    assertResult(real)(res)
  }
  it should "middle" in {
    val res  = LargestRectangleInHistogram.calcRectangle(Array(2, 1, 5, 6, 2, 3))
    val real = 10

    assertResult(real)(res)
  }
  it should "Single column" in {
    val res  = LargestRectangleInHistogram.calcRectangle(Array(1, 4, 1))
    val real = 4

    assertResult(real)(res)
  }
  it should "Start" in {
    val res  = LargestRectangleInHistogram.calcRectangle(Array(6, 6, 2, 2, 2, 3))
    val real = 12

    assertResult(real)(res)
  }
  it should "Across bottom" in {
    val iArray = Array(1, 1, 2, 2, 1, 1, 6, 1)
    val res    = LargestRectangleInHistogram.calcRectangle(iArray)
    val real   = iArray.length

    assertResult(real)(res)
  }
}
