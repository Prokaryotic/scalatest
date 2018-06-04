package day03

class Exercise {





}
object Exercise{
  def main(args: Array[String]): Unit = {

    val num = -123890000055000L
    var isFrist = true
    val res =  (for (str <- num.toString.reverse ) yield {
      if(isFrist){
        if (str != '0'){
          isFrist = false
          str
        } else {
          '#'
        }
      } else {
        str
      }
    }).filter(e =>e != '#'&&e != '-').toLong

    println(res-1)
  }
}