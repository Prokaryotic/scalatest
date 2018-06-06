package day06


import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

import scala.collection.mutable
import scala.concurrent.duration._  //import context.dispatcher // 引入对的 影视函数 0 millis

// Akka 中负责监控和创建Actor的老大叫ActorSystem
// 负责正在通信的Actor
class Master(val masterHost: String, val masterPort: Int) extends Actor {

  val id2Worker = new mutable.HashMap[String, WorkerInfo]()

  val workers = new mutable.HashSet[WorkerInfo]()

  val CHECK_INTERVAL = 5000

  // preStart会被调用一次 在构造方法之后 receive方法之前
  override def preStart(): Unit = {
    // 在preStart启动一个定时器，用于周期检查超市的Worker
    import context.dispatcher // 引入对的 影视函数
    context.system.scheduler.schedule(0 millis, CHECK_INTERVAL millis, self, CheckTimeOutWorker)
  }

  override def receive: Receive = {

    // Worker -> Master
    case RegisterWork(id, host, port, memory, cores) => {
      if (!id2Worker.contains(id)){
        val workerInfo = new WorkerInfo(id, host, port, memory, cores)
        id2Worker += (id -> workerInfo)
        workers +=workerInfo
        println("a worker registered")
        sender ! RegisteredWork(s"akka.tcp://${Master.MASTER_SYSTEM}"+
        s"@$masterHost:$masterPort/user/${Master.MASTER_ACTOR}")
      }
    }

    case Heartbeat(workerId) =>{
      println("a worker Heartbeat")
      val workerInfo = id2Worker(workerId)
      val current_time = System.currentTimeMillis()
      // 更新最后一次心跳时间
      workerInfo.lastHeartbearTime = current_time

    }

    case CheckTimeOutWorker => {
      val currentTime =System.currentTimeMillis()
      val toRemove: mutable.HashSet[WorkerInfo] = workers.filter(w => currentTime - w.lastHeartbearTime > CHECK_INTERVAL)
      toRemove.foreach(deadWorker =>{
        // 将超时的worker从内存中移除掉
        id2Worker -= deadWorker.id
        workers -= deadWorker
        println("remove worker ： "+deadWorker.id)
      })

      println("num of workers "+workers.size)

    }


  }
}


object Master {

  val MASTER_SYSTEM = "MasterSystem"
  val MASTER_ACTOR = "Master"

  def main(args: Array[String]): Unit = {
    // 在创建Actor 之前 必须创建 ActorSystem(单例的 重量类)
    val host = args(0)
    val port = args(1).toInt

    val configStr =
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname = "$host"
         |akka.remote.netty.tcp.port = "$port"
        """.stripMargin
    val config = ConfigFactory.parseString(configStr)

    // 先创建一个ActorSystem 单例
    val actorSystem = ActorSystem(MASTER_SYSTEM, config)
    actorSystem.actorOf(Props(new Master(host, port)), MASTER_ACTOR)
    actorSystem.awaitTermination

  }
}
