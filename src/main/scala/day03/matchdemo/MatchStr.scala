package day03.matchdemo

import scala.util.Random

object MatchStr {
  def main(args: Array[String]): Unit = {
    val arr = Array("zhangsan","lisi","wangwu")

    val name = arr(Random.nextInt(arr.length))

    println(name)

    // 匹配字符串
    name match {

      case "zhangsan" => println("张三")
      case "lisi" => println("李四")
      case "wangwu" => println("王五")
      case _ => println("没有匹配到")

    }

  }
}


