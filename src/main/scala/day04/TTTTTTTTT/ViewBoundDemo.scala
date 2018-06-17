package day04.TTTTTTTTT

import day04.Girl


class ViewBoundDemo[T <% Ordered[T]] {

  def select(first: T, second: T): T = {

    if (first > second) first else second
  }

}


object ViewBoundDemo {
  def main(args: Array[String]): Unit = {
    import day04.FilePredef.selectGirl

    val viewBoundDemo = new ViewBoundDemo[Girl]

    val g1 = new Girl("se", 132)
    val g2 = new Girl("gge", 122)

    viewBoundDemo.select(g1, g2)
  }
}
