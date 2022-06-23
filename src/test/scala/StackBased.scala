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

}
