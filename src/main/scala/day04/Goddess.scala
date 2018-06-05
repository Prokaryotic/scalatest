package day04

object ImplicitContext {

  implicit object OderingGirl extends Ordering[Girl] {
    override def compare(x: Girl, y: Girl): Int = if (x.faceValue > y.faceValue) 1 else -1
  }

}

class Goddess[T: Ordering](val v1: T, val v2: T) {

  def choose()(implicit ord: Ordering[T]) = if (ord.gt(v1, v2)) v1 else v2

}

object Goddess {

  def main(args: Array[String]): Unit = {
    // 比较2个自定义对象里的属性

    import ImplicitContext.OderingGirl

    val g1 = new Girl("范冰冰", 95)
    val g2 = new Girl("范小爷", 96)

    val goddess = new Goddess(g1, g2)

    val myGoddess = goddess.choose()

    println(myGoddess)


  }

}


class Girl(val name: String, var faceValue: Int) {

}
