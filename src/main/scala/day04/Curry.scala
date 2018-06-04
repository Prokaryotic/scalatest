package day04

object Curry {

  // 柯里化
  def currying(x: Int)(y: Int): Int = x * y

  // 柯里化含隐式的值 implicit 关键字
  def curryImplicit(x: Int)(implicit y: Int = 10): Int = x * y

  // 这也是柯里化的方法
  def curry(x: Int):Int=>Int = (y: Int) => x * y

  def main(args: Array[String]): Unit = {

    println(currying(3)(4))

    // 变为 一个单一参数的函数 Int => 3 * y
    val curry = currying(3) _


    // 这里会根据上下文改变隐式值 implicit y: Int = 10  但是如果 下面还有 implicit val x = 101 则报错 第二个curryImplicit 会编译错误
    implicit val x = 100
    println(curryImplicit(4))
    //    implicit val xx = 101
    //    println(curryImplicit(4))


  }
}


object Test {

  def main(args: Array[String]): Unit = {
    // 求后面value的和
    val arr = Array(("scala1", 1), ("scala2", 2), ("scala3", 3))


    // 这里用不了reduce 因为reduce有一个要求 就是 返回值格式和第一个值的格式要一样  比如_._2 代表是一个元组 但是返回的值 是一个int 所以会报错
    //    val res = arr.reduce(_._2+_._2)


    // 这里可以用 foldLeft 因为 他实现了柯里化 第一个和第二个参数是分离的 这样 返回的格式就可以和传入的格式不相同
    val res = arr.foldLeft(0)(_ + _._2)

    println(res)
  }

}