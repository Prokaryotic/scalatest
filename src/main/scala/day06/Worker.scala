package day06

import java.util.UUID

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory


import scala.concurrent.duration._

class Worker(val host: String, val port: Int, val masterHost: String,
             val masterPort: Int, val memory: Int, val cores: Int) extends Actor {

  val worker_id = UUID.randomUUID.toString

  var masterUrl: String = _

  // TODO  注意worker的心跳时间 要小于 master的自我检测时间
  val HEARTBEAT_INTERVAL = 4000

  var master: ActorSelection = _

  override def preStart(): Unit = {
    master = context.actorSelection(s"akka.tcp://${Master.MASTER_SYSTEM}" +
      s"@$masterHost:$masterPort/user/${Master.MASTER_ACTOR}")
    master ! RegisterWork(worker_id, host, port, memory, cores)
  }

  override def receive: Receive = {
    case RegisteredWork(masterUrl) => {
      this.masterUrl = masterUrl
      // 定时发送心跳 心跳是一个case class
      // 导入一个隐式转换 才能启动定时器
      import context.dispatcher // 引入对的 影视函数
      context.system.scheduler.schedule(0 millis, HEARTBEAT_INTERVAL millis, self, SendHeartbeat)
    }

    // 注册完后 会一直对 自己定时检测 然后发送心跳包
    case SendHeartbeat => {
      master ! Heartbeat(worker_id)
    }
  }


}

object Worker {

  val WORK_UUID = UUID.randomUUID.toString

  val WORKER_SYSTEM = "WorkerSystem"

  val WORKER_ACTOR = "Worker"

  def main(args: Array[String]): Unit = {
    val host = args(0)
    val port = args(1).toInt  // 这边端口好不一样就可以做到 多个work  这是因为
    val masterHost = args(2)
    val masterPort = args(3).toInt
    val memory = args(4).toInt
    val cores = args(5).toInt
    val configStr =
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname = "$host"
         |akka.remote.netty.tcp.port = "$port"
        """.stripMargin
    val config = ConfigFactory.parseString(configStr)

    // 先创建一个ActorSystem 单例
    val actorSystem = ActorSystem(WORKER_SYSTEM, config)
    actorSystem.actorOf(Props(new Worker(host, port, masterHost, masterPort, memory, cores)), WORKER_ACTOR)
    actorSystem.awaitTermination
  }
}
