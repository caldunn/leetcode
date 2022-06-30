import BitManipulation.*

class BitManipulationT extends BaseFlatSpec {
  // Return a boolean to predicate => Is there a duplicate?
  "136 - single number" should "Array 1 single multiple dupes" in {
    val res = BitManipulation.SingleNum.getSingleNumber(Array(4, 1, 2, 1, 2))
    assertResult(4)(res)
  }
  it should "Array size of 1" in {
    val res = BitManipulation.SingleNum.getSingleNumber(Array(3))
    assertResult(3)(res)
  }

  it should "Single duplicate" in {
    val res = BitManipulation.SingleNum.getSingleNumber(Array(4, 4, 1))
    assertResult(1)(res)
  }

  "191 - Number of 1 bits" should "11 = 3 hamming weight" in {
    val res = BitManipulation.SingleNum.getHammingWeight(11)
    assertResult(3)(res)
  }
  it should "Array size of 1" in {
    val res = BitManipulation.SingleNum.getHammingWeight(0)
    assertResult(0)(res)
  }
  it should "1 = 1" in {
    val res = BitManipulation.SingleNum.getHammingWeight(1)
    assertResult(1)(res)
  }

  "338 - Counting bits" should "0 = array of length 1" in {
    val res = BitManipulation.SingleNum.countInBits(0)
    assertResult(Array(0))(res)
  }

  it should "multiple" in {
    val res = BitManipulation.SingleNum.countInBits(5)
    assertResult(Array(0, 1, 1, 2, 1, 2))(res)
  }

  "338 - Missing var" should "0 = array of length 1" in {
    val res = BitManipulation.SingleNum.getMissingNumberBit(Array(3, 0, 1))
    assertResult(2)(res)
  }
  it should "Example 2??" in {
    val res = BitManipulation.SingleNum.getMissingNumberBit(Array(9, 6, 4, 2, 3, 5, 7, 0, 1))
    assertResult(8)(res)
  }

  "338 - Missing var Guassian" should "small array" in {
    val res = BitManipulation.SingleNum.getMissingNumberGauss(Array(3, 0, 1))
    assertResult(2)(res)
  }
  it should "Larger array" in {
    val res = BitManipulation.SingleNum.getMissingNumberGauss(Array(9, 6, 4, 2, 3, 5, 7, 0, 1))
    assertResult(8)(res)
  }

  "371 - Add two integers CUSTOM IMPL" should "1 + 1 == 2" in {
    val res = BitManipulation.SingleNum.+(1, 1)
    assertResult(2)(res)
  }
  it should "0 as first | 0 + 5 = 5" in {
    val res = BitManipulation.SingleNum.+(0, 5)
    assertResult(5)(res)
  }
  it should "0 as second | 5 + 0 = 5" in {
    val res = BitManipulation.SingleNum.+(5, 0)
    assertResult(5)(res)
  }
}
