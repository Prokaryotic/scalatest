package day03.matchdemo

import scala.util.Random

object MatchType {
  def main(args: Array[String]): Unit = {
    val arr = Array("abcd",100,3.14,true,new TTT)

    val element = arr(Random.nextInt(arr.length))

    println(element)

    // 匹配类型
    element match {
      case str:String => println(s"match String $str")
      case int:Int => println(s"match int $int")
      case bool:Boolean => println(s"match bool $bool")
      case double:Double => println(s"match double $double")
      case ttt:TTT => println(s"match ttt $ttt")
      case _:Any =>println("match nothing")
    }
  }
}

class TTT{

}
