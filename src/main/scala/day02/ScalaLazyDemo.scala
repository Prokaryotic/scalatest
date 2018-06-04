package day02

class ScalaLazyDemo {

}
object ScalaLazyDemo1{
  def init(): Unit = {
    println("call init() ")
  }

  def main(args: Array[String]): Unit = {

    val property = init() // 没有用lazy修饰

    println("after init()")
    println(property)

  }
}


object ScalaLazyDemo2{
  def init(): Unit = {
    println("call init() ")
  }

  def main(args: Array[String]): Unit = {

    lazy val property = init() // 用lazy修饰
    println("after init()")
    println(property)

  }
}