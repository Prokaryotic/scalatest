package day05

import scala.actors.Actor
import scala.concurrent.Future






class MyActor4 extends Actor{

  override def act(): Unit = {
    while (true){

      // 偏函数
      receive{
        case "START" => println("START ....")
        case AsynMsg(id,msg) => {
          println(s"id :$id, AsynMsg: $msg")
          Thread.sleep(2000)
          sender ! ReplyMsg(2,"success") // 异步使用 ！
      }

        case SyncMsg(id,msg) => {
          println(s"id :$id, AsynMsg: $msg")
          Thread.sleep(2000)
          sender ! ReplyMsg(2,"success") // 同步使用 ！
        }
        case ReplyMsg(id,msg) => {

        }
      }
    }

  }
}

// 创建case 类 最多能写22 个参数

case class AsynMsg(id:Int, msg:String)

case class SyncMsg(id:Int, msg:String)

case class ReplyMsg(id:Int, msg:String)





object ActorTest4{
  def main(args: Array[String]): Unit = {
    val actor :MyActor4= new MyActor4

    actor.start()
    // 没有返回值的异步消息
    actor ! AsynMsg(1,"双击666")
    println("没有返回值的异步消息")

    // 同步发送消息 线程等待
   val content = actor !? SyncMsg(1,"llll---***")
    println("同步发送消息")
    println(content)

    // 异步发送消息 有返回值 返回类型是Future[Any]
    val replyMsg:actors.Future[Any] = actor !! AsynMsg(1,"双击555")
    Thread.sleep(2000)
    if (replyMsg.isSet){ // isSet 是否有值 如果了没有 那么就返回false
      val value = replyMsg.apply()
      println(value)
    } else{
      println("None")
    }
    println("没有返回值的异步消息")

  }
}