package day03.matchdemo

/**
  * 偏函数的应用  PartialFunction[A,B] 其中A是参数类型 B是返回值类型
  * PartialFunction(偏函数) 常用作模式匹配
  */
object PartialFunctionDemo {

  // 偏函数的应用  第一个是 参数 第二个是返回值 下面是匹配的 条件
  def m1:PartialFunction[String,Int] = {
    case "one" => {
      println("one")
      1
    }
    case "wwo" => {
      println("two")
      2
    }
  }
// m1等价于m2
  def m2(num:String):Int = num match{
    case "one" => {
      println("one")
      1
    }
    case "wwo" => {
      println("two")
      2
    }
  }

  def main(args: Array[String]): Unit = {

    println(m1("one"))

  }
}
