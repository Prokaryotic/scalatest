package day03

import scala.collection.mutable.ArrayBuffer

/**
  * 在scala中没有静态方法和静态字段，但是可以使用object关键字加类名的语法结构实现同样的功能
  * 1.实现工具类 存放常量和工具方法
  * 2.实现单例模式
  */
object SingletonDemo {

  def main(args: Array[String]): Unit = {

  }
}

object SessionFactory{
  println("SessionFactory 被执行了")

  var i = 5
  private val sessions = new ArrayBuffer[Session]

  while(i >0){
    sessions += new Session
    i -=1
  }

  def getSessions = sessions
  def remove :Unit ={
    val s = sessions(0)
    sessions.remove(0)
    println("session remove" +s)
  }


}

class Session{}
