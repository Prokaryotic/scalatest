package day05

import scala.actors.Actor
import scala.collection.mutable.ListBuffer
import scala.concurrent.Future
import scala.io.Source


/**
  * 使用actor 并发编程实现 WordCount
  */
object ActorWordCount {
  def main(args: Array[String]): Unit = {

    // 文件路径
    val files = Array("F:\\test\\scala\\words\\a.txt","F:\\test\\scala\\words\\b.txt","F:\\test\\scala\\words\\c.txt")

    // 存放文件的结果
    val futures = new ListBuffer[actors.Future[Any]]

    // 存最后结果
    val res: ListBuffer[Map[String, Int]] = new ListBuffer[Map[String, Int]]


    for (file <- files) {
      val task = new Task
      task.start
      val replyMsg = task !! SmTask(file)

      futures += replyMsg // 添加到futures
    }

    while (futures.size > 0) {

      // 过滤每个 Future对象， 如果None 类型的，就过滤掉
      val dones = futures.filter(_.isSet)
      for (done <- dones) {
        res += done.apply.asInstanceOf[Map[String, Int]] // asInstanceOf[Map[String, Int]] 相当于java里的 (int)12L 强转

        // 使用完了之后移除
        futures -= done
      }
      Thread.sleep(500)

    }

    val resMap = res.flatten.groupBy(_._1).mapValues(_.foldLeft(0)(_+_._2))
println("----------------WordsCount :")
    println(resMap)

  }


}


class Task extends Actor {
  override def act(): Unit = {
    while (true) {
      receive {
        case SmTask(file) => {
          val lines = Source.fromFile(file).getLines().toList
          println(lines)
          val res = lines.flatMap(_.split(" ")).map(_ -> 1).groupBy(_._1).mapValues(_.size)
          // 异步发送
          sender ! res
        }
      }
    }
  }
}


case class SmTask(file: String)
