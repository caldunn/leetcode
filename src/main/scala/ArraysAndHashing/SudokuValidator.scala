package ArraysAndHashing

import scala.collection.mutable
// 1st draft -> 9 + 9 + 9 sets
object SudokuValidator {

  def validateSudoku(input: Array[Array[String]]): Boolean =
    val validNums  = Set("1", "2", "3", "4", "5", "6", "7", "8", "9")
    val setsMapped = List("row", "col", "sqr").map(i => i -> Range(0, 9).map(_ => mutable.Set[String]())).toMap

    for i <- input.zipWithIndex do
      for j <- i._1.zipWithIndex if validNums.contains(j._1) do

        val (row, col, square) = (
          setsMapped("row")(i._2).add(j._1),
          setsMapped("col")(j._2).add(j._1),
          setsMapped("sqr")((i._2 / 3 * 3) + (j._2 / 3)).add(j._1)
        )

        if !row || !col || !square then return false
    true
}
