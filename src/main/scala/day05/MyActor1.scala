package day05

import scala.actors.Actor


object ActorTest {
  def main(args: Array[String]): Unit = {
    // 创建线程
    MyActor1.start
    MyActor2.start
    MyActor3.start

    // 创建线程 传递消息

  }
}


// 2.11里已经废弃了scala-actor 使用了akka 这里做学习使用
object MyActor1 extends Actor {
  override def act(): Unit = {
    for (i <- 1 to 20) {
      println("use acotr1 :" + i)
      Thread.sleep(1000)
    }
  }
}


object MyActor2 extends Actor {
  override def act(): Unit = {
    for (i <- 1 to 20) {
      println("use acotr2 :" + i)
      Thread.sleep(1000)
    }
  }
}

object MyActor3 extends Actor {
  override def act(): Unit = {
    for (i <- 1 to 20) {
      println("use acotr3 :" + i)
      Thread.sleep(1000)
    }
  }
}

