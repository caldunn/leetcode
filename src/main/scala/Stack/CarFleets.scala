package Stack

import scala.collection

object CarFleets {
  def asCarFleets(target: Int, positions: Seq[Int], speeds: Seq[Int]): Int =
    case class Car(position: Int, speed: Int)

    val fleetStack = collection.mutable.Stack[Int]()
    val zippedAndSorted = positions
      .zip(speeds)
      .map(x => Car(x._1, x._2))
      .sortWith((c1, c2) => c1.position < c2.position)
      .reverse

    zippedAndSorted.foreach { car =>
      val lastVal = if fleetStack.nonEmpty then fleetStack.top else Int.MaxValue
      fleetStack.push((target - car.position) / car.speed)
      if (fleetStack.length >= 2 && fleetStack.top <= lastVal) fleetStack.pop()
    }

    fleetStack.length
}
