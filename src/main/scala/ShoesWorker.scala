import scala.io._

object ShoesWorker {
  def main(args: Array[String]): Unit = {
    while (true) {
      val pipeline = StdIn.readLine("Enter the shoes pipeline:")
      if (pipeline == "exit") sys.exit(0)
      println(
        "The number of pairs collected is " + plantWorker(pipeline, 0, 0, 0, 0))
    }
  }

  def plantWorker(input: String,
                  pos: Integer,
                  qSize: Int,
                  qType: Char,
                  counter: Int): Int = {
    // Evaluate state of the queue with shoes that were put aside and the counter
    val (qs, qt, cnt) = if (qSize > 0) {
      if (input(pos) == qType) (qSize + 1, qType, counter)
      else if (qSize == 1) (0, qType, counter + 1)
      else (qSize - 1, qType, counter)
    } else (1, input(pos), counter)

    // Recursively call the function until reach the end of the input
    if (pos == input.length - 1) {
      return cnt
    } else return plantWorker(input, pos + 1, qs, qt, cnt)
  }
}
