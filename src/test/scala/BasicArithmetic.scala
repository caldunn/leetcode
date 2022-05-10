import org.scalatest.*
import flatspec.*

/**
 * My initial playground for scalatest.
 */
class BasicArithmetic extends BaseFlatSpec {
  "Basic Arithmetic" should "allow 1 + 1 to equal 2" in {
    assert(1 + 1 == 2)
  }
  it should "allow for multiplication" in {
    assert(2 * 2 == 4)
  }
  it should "throw an exception when divided by 0" in {
    assertThrows[ArithmeticException] {
      1 / 0
    }
  }
}
