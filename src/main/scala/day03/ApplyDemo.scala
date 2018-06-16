package day03

class ApplyDemo(val name: String, var age: Int, var faceValue: Int) {

}

object ApplyDemo {

  // 下面2个一般都是隐式调用
  // 一般被称为 注入方法 用来初始化类
  def apply(name: String, age: Int, faceValue: Int): ApplyDemo = new ApplyDemo(name, age, faceValue)

  def apply(name: String, age: Int): Int = 3

  // 提取方法 使用unapply 方法来提取 固定的对象数量的对象  unapply 和 UNapplyseq 只能有一个 存在 有效 如果2个同是存在则 是以unapply为主
  // unapply 方法会返回一个序列 (Option) ，内部产生了 Some 对象来存放一些值
  def unapply(applyDemo: ApplyDemo): Option[(String, Int, Int)] = {
    if (applyDemo == null) {
      None
    } else {
      Some(applyDemo.name, applyDemo.age, applyDemo.faceValue)
    }

  }
//  def unapply(applyDemo: ApplyDemo): Option[(String, Int, Int,Int)] = {
//    if (applyDemo == null) {
//      None
//    } else {
//      Some(applyDemo.name, applyDemo.age, applyDemo.faceValue,applyDemo.faceValue)
//    }
//
//  }
  def unapplySeq(applyDemo: ApplyDemo): Option[Seq[String]] = {
    if (applyDemo == null) {
      None
    } else {
      Some(applyDemo.name.split(" "))
    }
  }
}

object Test2 {
  def main(args: Array[String]): Unit = {
    // 相当于创建一个实例 调用了 ApplyDemo 伴生对象里的apply方法
    val applyDemo = ApplyDemo("jingjing", 24, 90)
    val applyDemo1 = ApplyDemo("jingjing", 24)

    println(applyDemo1)
    applyDemo match {
      // 这里使用了unapply方法  ApplyDemo("jingjing", age, faceValue) 等于调用了 def unapply(applyDemo: ApplyDemo)
      case ApplyDemo("jingjing", w1, w2) => println(s"age: ")
      case _ => println("No match nothing")
    }
  }
}

