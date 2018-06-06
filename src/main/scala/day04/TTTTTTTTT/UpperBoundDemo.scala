package day04.TTTTTTTTT

/**
  * [ B<:A]  upperBound 上界 ：B类型的上界是A类型  即B类型的父类是A类型
  */
class UpperBoundDemo[T <: Comparable[T]] {

  def select(first: T, second: T): T = {
    if (first.compareTo(second) > 0) first else second
  }

}

object UpperBoundDemo {

  def main(args: Array[String]): Unit = {

    val g1 = new Goddess("范小爷", 120)
    val g2 = new Goddess("范冰冰", 119)
    val ud = new UpperBoundDemo[Goddess]

    val res = ud.select(g1,g2)
  }

}


class Goddess(val name: String, var faceValue: Int) extends Comparable[Goddess] {
  override def compareTo(o: Goddess): Int = {
    this.faceValue - o.faceValue
  }
}
