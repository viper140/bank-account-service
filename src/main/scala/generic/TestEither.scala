package generic

import java.net.URL
import scala.io.Source

object TestEither {

  def main(args: Array[String]): Unit = {
    val goodUrl = "https://baidu.com"
    val gooUrl2 = "http://tehang.com"
    val badUrl = "https://google.com"

    printWebContent(gooUrl2)
    printWebContent(badUrl)
  }

  def printWebContent(url: String): Unit = {
    println("Enter printWebContent")

    val urlContentEither = this.getWebContent(url)
    println("isLeft: " + urlContentEither.isLeft)
    urlContentEither match {
      case Left(msg) => println(msg)
      case Right(source) => source.getLines.foreach(println)
    }

    println("Exit printWebContent")
  }

  /**
   * 获取浏览器内容
   */
  def getWebContent(urlStr: String): Either[String, Source] = {
    val url = new URL(urlStr)
    if (url.getHost.contains("google"))
      Left("Requested URL is blocked for the good of the people!")

    else
      Right(Source.fromURL(url))
  }

}
