package day03

/**
  * 主构造器的参数列表要放到类名的后面 和类名放在一起
  *
  * @param name      val 修饰的参数具有不可变性
  * @param age       var 修饰的参数可变
  * @param faceValue 对于没有 var或val的参数 只能在本类中调用 伴生对象也无法调用
  *                  faceValue 虽然没有用val或var修饰，默认是val
  */
//主构造器 没有 用val 或者 var 声明的话 就是访问不到的
class StructDemo(val name: String, var age: Int, faceValue: Int) {

  var gender: String = _

  //辅助构造器
  def this(name: String, age: Int, faceValue: Int, gender: String) {
    this(name, age, faceValue) // 辅助构造器第一行必须先调用主构造器
    this.gender = gender
  }
}

object StructDemo {
  def main(args: Array[String]): Unit = {
    //    val s = new StructDemo("huahua", 26, 98)
    //    println(s.name)
    //    println(s.age)
    //    s.age = 30
    val s = new StructDemo("ningning", 26, 98, "女")

  }
}