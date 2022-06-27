package Stack

import scala.collection.mutable

object DailyTemps {
  def getDailyTemps(temps: Array[Int]): Array[Int] =
    val indexedArray = temps.zipWithIndex
    val mutStack     = mutable.Stack[(Int, Int)]()
    val mutArray     = mutable.ArrayBuffer.fill(temps.length)(0)

    indexedArray.foreach { e =>
      /*
      mutStack.popWhile { x =>
        mutArray(x._2) = e._2 - x._2
        x._1 < e._1
      }*/

      while (mutStack.nonEmpty && mutStack.top._1 < e._1)
        val top = mutStack.pop
        mutArray(top._2) = e._2 - top._2

      mutStack.push(e)
    }

    mutArray.toArray
}
