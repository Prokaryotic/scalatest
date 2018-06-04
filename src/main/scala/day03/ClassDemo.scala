package day03

object ClassDemo {

}

/**
  * 特质 基本上就跟java接口一样
  */
trait Flyable {
  // 声明 一个没有值的字段
  val distance: Int

  // 声明一个没有实现的方法
  def fight: String

  // 声明一个实现方法
  def fly: Unit = {
    println("i can fly")
  }
}


/**
  * 抽象类
  */
abstract class Animal {
  // 声明一个没有赋值的字段
  val name: String

  // 声明一个没有实现的方法
  def run: String

  // 声明一个没有实现的方法
  def climb: String = {
    "iiiii"
  }
}


// ctrl + i 自动补全需要 实现的方法  如果是只有一个特质需要继承的话需要直接 entends 特质 不用with
class Human extends Animal with Flyable {
  override val name: String = "215"

  // 这可以不用override
  override def run: String = "i can run"

  override val distance: Int = 5

  override def fight: String = "666"

  // 如果是已经有的方法要重写 就一定要用override
  override def climb: String = "override climb"


}




