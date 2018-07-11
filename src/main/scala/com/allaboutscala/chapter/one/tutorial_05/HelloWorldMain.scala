package com.allaboutscala.chapter.one.tutorial_05
import scala.io.Source
/**
  * Created by lucas on 6/6/2018.
  */
object HelloWorldMain {
  def main(args: Array[String]): Unit = {
    println("Hello World from Main!" +
      "" +
      "")
    val fileContents = Source.fromFile("files/good.txt").getLines.mkString
    println(fileContents)
  }


}
