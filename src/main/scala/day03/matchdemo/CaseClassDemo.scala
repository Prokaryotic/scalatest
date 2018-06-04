package day03.matchdemo

import scala.util.Random


object CaseClassDemo {
  def main(args: Array[String]): Unit = {

    val arr = Array(CheckTimeOutTask, SubmiTask("10000", "taskName"), HeartBeat(1000))

    arr(Random.nextInt(arr.length)) match {
      case CheckTimeOutTask => println("CheckTimeOutTask")
      case SubmiTask(port, task) =>println("SubmiTask")
      case HeartBeat(time) =>println("HeartBeat")
    }


  }
}

case class HeartBeat(time: Long)

case class SubmiTask(id: String, taskName: String)

case object CheckTimeOutTask
