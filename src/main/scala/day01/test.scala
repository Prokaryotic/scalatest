package day01

import scala.collection.mutable.ArrayBuffer

class test {

}

object test {
  def main(args: Array[String]): Unit = {
    //创建一个List
    val list0 = List(1,7,9,8,0,3,5,4,6,2)
    val list1 = for(e <- list0) yield e*10
    val list2 = for(e <- list0 if e%2 == 1) yield e
//    val list3 = list0.sortBy(e)
    val list4 = list0.reverse


  }

}
