package day04

/**
  * 隐式转换
  */
object ImplicitContext {

  implicit object OderingGirl extends Ordering[Girl] {
    override def compare(x: Girl, y: Girl): Int = if (x.faceValue > y.faceValue) 1 else -1
  }

}

// [T: Ordering] 必须存在一个“B[A]”的隐士值。  是有B[A]的隐士参数 比如有  implicit object OderingGirl extends Ordering[Girl]

class Goddess[T: Ordering](val v1: T, val v2: T) {

  // ord就相当于 OderingGirl 在隐式 完成的时候如下面第29行import
  def choose()(implicit ord: Ordering[T]) = if (ord.compare(v1, v2)>0) v1 else v2

}

// ctrl + d  复制当前行
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

  override def toString = s"Girl($name, $faceValue)"
}
