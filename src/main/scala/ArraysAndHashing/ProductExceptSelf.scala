package ArraysAndHashing

object ProductExceptSelf {
  def invalid(input: Seq[Int]): Seq[Int] =
    val ltr = input.scanLeft(1)(_ * _).drop(1)
    val rtl = input.scanRight(1)(_ * _).dropRight(1)

    input.zipWithIndex.map {
      case (_, 0)                                    => rtl(1)
      case (_, length) if length == input.length - 1 => ltr(length - 1)
      case (_, i)                                    => ltr(i - 1) * rtl(i + 1)
    }

}
