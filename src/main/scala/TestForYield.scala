import scala.util.Try

object TestForYield {

  def printCapitalLetterByForYield(str: String): Try[String] = {
    val result = for (item <- str.split("") if item.equals(item.toUpperCase)) yield item
    return Try(result.mkString)
  }

  def printCapitalLetterByFilter(str: String): Try[String] = {
    val result = str.toArray
      .filter(item => item.equals(item.toUpper))
    return Try(result.mkString)
  }

  def main(args: Array[String]) {
    println(printCapitalLetterByForYield("qweASD"))
    println(printCapitalLetterByFilter("qweASD"))
  }

}