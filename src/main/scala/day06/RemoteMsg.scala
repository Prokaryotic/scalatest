package day06

import scala.concurrent.duration.FiniteDuration

trait RemoteMsg extends Serializable


// Worker -> Master
case class RegisterWork(id:String, host:String, port:Int, memory:Int, cores:Int) extends RemoteMsg

case class Heartbeat(workerId:String) extends RemoteMsg

// Master -> Worker
case class RegisteredWork(masterUrl:String) extends RemoteMsg

// Worker -> self
case object SendHeartbeat

//master -> self
case object CheckTimeOutWorker



