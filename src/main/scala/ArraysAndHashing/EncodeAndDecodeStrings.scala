package ArraysAndHashing

import scala.annotation.tailrec
import scala.collection.mutable

object EncodeAndDecodeStrings {
  def encode(in: Seq[String]): String =
    in.fold("") { (acc, s) =>
      s"$acc${s.length}!$s"
    }

  def decode(in: String): Seq[String] =
    enum State:
      case DELIMITER, WORD

    println("-" * 25)
    println(s"\n${in.drop(4)} : ${in.slice(0, 4)}\n")
    println("-" * 25)
    /**/

    if in.length <= 0 then return Seq()

    // val boot = in.split("^\\d+!")
    val boot = in.split('!')(0)
    val firstStr = in
      .drop(boot.length + 1)
      .slice(0, boot.toInt)
    println(s"Boot: $firstStr")
//    @tailrec
//    def recurse(state: State, encodedWord: String, currentIndex: Int) = state match {
//      case State.DELIMITER => println("delims")
//      case State.WORD      =>
//
//    }

    val decoded       = mutable.Seq[String]()
    var currentString = ""
    for (x <- in) {}

    decoded.toSeq
}
