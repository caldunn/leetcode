package ArraysAndHashing

import scala.annotation.tailrec
import scala.collection.mutable

object EncodeAndDecodeStrings {
  def encode(in: Seq[String]): String =
    in.fold("") { (acc, s) =>
      s"$acc${s.length}!$s"
    }

  def decode(in: String): Seq[String] =

    /**
     * Grab the length of the first word. Makes recursive step easier to read.
     * @return
     *   Length of first encoded word.
     */
    def extractLength(word: String) =
      val l = word.takeWhile(_ != '!')
      if l.nonEmpty then (l.toInt, l.length) else (0, 0)

    @tailrec
    def recurse(wordLength: Int, encodedWord: String, wordList: List[String]): List[String] =

      if encodedWord.isEmpty then return wordList
      val newEncodedWord = encodedWord.drop(wordLength)
//      println(s"$encodedWord -> $newEncodedWord")
      val newWordLength = extractLength(newEncodedWord)
      recurse(
        newWordLength._1,
        newEncodedWord.drop(newWordLength._2 + 1),
        wordList :+ encodedWord.take(wordLength)
      )

    if in.length <= 0 then Seq()
    else
      val wordLength = extractLength(in)
      recurse(wordLength._1, in.drop(wordLength._2 + 1), List())

}
