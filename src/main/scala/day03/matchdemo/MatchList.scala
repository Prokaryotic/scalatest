package day03.matchdemo

/**
  * 匹配数组元组、元组、集合
  */
object MatchList {

  def main(args: Array[String]): Unit = {

    // 匹配 数组  case 后面接的东西要跟match的东西一个东西 比如都是数组就都是数组
    val arr = Array(3, 2, 1, 5)
    arr match {
      case Array(a, b, c, d) => println(s"case :$a,$b,$c,$d")
      case Array(_, x, y) => println(s"case:$x,$y")
      case _ => println("no matched")
    }

    //




  }
}
