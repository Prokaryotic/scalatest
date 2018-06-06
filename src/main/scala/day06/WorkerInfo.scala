package day06

class WorkerInfo(val id:String, val host:String, val port:Int, val memory:Int, val cores:Int) {

  var lastHeartbearTime : Long =_
}
