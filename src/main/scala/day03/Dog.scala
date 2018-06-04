package day03

/**
  * 与类名相同 并且用object修饰的对象叫做伴生对象
  * 类和其伴生对象之间可以相互访问私有的方法和属性
  */
class Dog {
  private var name = "erha"
  def printName():Unit = {
  //在Dog类中 访问其伴生对象的私有属性
  println(Dog.VOICE)
  }
}

/**
  * 伴生对象
  */
object Dog{
  private val VOICE = "WANG WANG"

  def main(args: Array[String]): Unit = {
    val p = new Dog
    println(p.name)
    p.printName()
  }
}
