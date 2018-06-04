package day03

/**
  * 声明默认的是public关键字
  *
  * 一个类文件可以声明多个类
  *
  * 类文件的名字和类的名字可以不一样
  */
class Person {

  //属性 在scala里是不用 创建set 和get方法的
  // 使用val 就说明 这个属性只有 get方法 只读的
  val id: String = "0001"

  // 使用val 就说明 这个属性只有 get方法 和set方法 可以读写的
  var name: String = _

  // 用private 修饰的属性 改属性属于对象私有变量 只有本类和其伴生对象 访问
  private var age: Int = _

  // 用 private[this] 修饰的属性 改属性属于对象私有变量 只有本类才能访问 其伴生对象也无法访问
  private[this] var gender: String = _

  def ii=1
  def i():Int=1
}

/**
  * 伴生对象
  */
object Person {
  def main(args: Array[String]): Unit = {
    val p = new Person
   println(p.i)
    println(p.ii)
  }
}
