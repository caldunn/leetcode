package BitManipulation

import scala.annotation.{tailrec, targetName}
import scala.collection.mutable

object SingleNum {

  def getSingleNumber(input: Array[Int]): Int =
    input.reduce(_ ^ _)

  def getMissingNumberBit(input: Array[Int]): Int =
    input.reduce(_ ^ _) ^ (0 to input.length).reduce(_ ^ _)

  def getMissingNumberGauss(input: Array[Int]): Int =
    (input.length * (input.length + 1)) / 2 - input.sum

  def getHammingWeight(input: Int): Int =
    @tailrec
    def recurseHamming(total: Int, n: Int): Int =
      val newTotal = total + n % 2
      val updated  = n >> 1
      if (updated == 0)
        newTotal
      else
        recurseHamming(newTotal, updated)

    recurseHamming(0, input)

  def countInBits(n: Int): Array[Int] =
    val arr = mutable.ArrayBuffer.fill(n + 1)(0)
    for (i <- 1 to n)
      arr(i) = arr(i >> 1) + (i & 1)

    arr.toArray

  def reverseBits(n: Int): Int =
    var back = 0
    for (i <- 0 to 31)
      val from = (n >> i) & 1
      back = back | (from << (31 - i))

    back

  @targetName("Addition") @tailrec
  def +(x: Int, y: Int): Int =
    if (y == 0) x else this.+(x ^ y, (x & y) << 1) // 1st = added, 2nd = carried
}
