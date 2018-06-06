package day04.TTTTTTTTT
import day04.Girl

class ContextBoundDemo[T: Ordering] {
  def select(first: T, second: T): T = {
    val ord:Ordering[T] =implicitly[Ordering[T]]
    if(ord.gt(first,second)) first else second

  }
}

object ContextBoundDemo{
  def main(args: Array[String]): Unit = {
    import day04.FilePredef.OrderingGirl

    val contextBoundDemo = new ContextBoundDemo[Girl]

    val g1 = new Girl("se",132)
    val g2 = new Girl("gge",122)

    contextBoundDemo.select(g1,g2)





  }
}
