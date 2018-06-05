package day04

object Exercise {

  def m1(str1:String)(implicit str2:String):Int = {
    str1.length + str2.length
  }



  def main(args: Array[String]): Unit = {

    // 传入一个隐式的值
    import ConsStr.language
    println(m1("123"))




  }
}
