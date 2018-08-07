import scala.io._

object ShoesWorker {
  def main(args: Array[String]): Unit = {
    val pipeline = StdIn.readLine("Enter the shoes pipeline:")

    println("The number of pairs collected is " + countPairs(pipeline))

  }

  def countPairs(p: String ): Int = {
    var cnt, status = 0
    for (c <- p) {
      if (status == 0) {
        status = c.toInt
      } else if (status + c.toInt == 158) {
        cnt += 1
        status = 0
      } else return cnt
    }
    return cnt
  }
}
