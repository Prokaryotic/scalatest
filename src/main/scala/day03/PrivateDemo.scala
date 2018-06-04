package day03

// private [day03] PrivateDemo 是day03包的 私有类 其他包是不能访问的
// 构造器参数列表前加private 是指只有半生对象才能访问 这个构造器
private [day03]class PrivateDemo private (val gender:Int,var faceValue:Int) {

  // private  name 是 PrivateDemo的私有属性 但是伴生对象 可以访问
  private val name = "jingjing"

  // private[this]  name 是 PrivateDemo的私有属性 且伴生对象 不可以访问
  private[this] var age = 24

  // private  sayHello 是 PrivateDemo的私有方法 但是伴生对象 可以调用
  private def sayHello():Unit={
    println(s"$name age is $age")
  }
}
object PrivateDemo{

}