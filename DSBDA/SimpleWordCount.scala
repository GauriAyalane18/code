import scala.io.Source

object SimpleWordCount {
  def main(args: Array[String]): Unit = {
    val filename = "example.txt"

    val source = Source.fromFile(filename)
    val text = source.getLines().mkString(" ")
    source.close()

    val words = text.split("\\s+")
    val wordCounts = words.groupBy(identity).view.mapValues(_.length)

    wordCounts.foreach { case (word, count) =>
      println(s"$word: $count")
    }
  }
}
