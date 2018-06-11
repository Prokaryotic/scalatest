package day09

import java.net.URL
import java.util.UUID

import org.apache.spark.rdd.RDD
import org.apache.spark.{HashPartitioner, Partitioner, SparkConf, SparkContext}

import scala.collection.mutable

object WebNetCount {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("SparkRDDExercise").setMaster("local")
    val sc = new SparkContext(conf)


    // 获取数据
    val file: RDD[String] = sc.textFile("F:\\test\\spark\\input")


    // 取出 url 并生成一个元组
    val urlAndOne: RDD[(String, Int)] = file.filter(_.split(" ").length == 2) map (line => {
      val fields = line.split(" ")
      val url = fields(1)
      (url, 1)
    })

    // 把相同的url聚合
    val sumedUrl: RDD[(String, Int)] = urlAndOne.reduceByKey(_ + _)


    // 获取学科信息并缓存  因为这边的数据以后可能还会用到
    val cachedProject: RDD[(String, (String, Int))] = sumedUrl.map(x => {
      val url = x._1
      val project = new URL(url).getHost
      val count = x._2
      (url, (project, count))
    }).cache()


    // 调用Spark自带的分区器此时会发生哈希碰撞，需要自定义分区器
    //    val res = cachedProject.partitionBy(new HashPartitioner(3))
    //    res.saveAsTextFile("")


    // 得到所有学科
    val porjects = cachedProject.keys.distinct.collect
    println(porjects.toBuffer)
    // 调用自定义分区器 并得到分区号
    val partitioner = new WebNetPartitioner(porjects)

    // 分区
    val partitioned = cachedProject.partitionBy(partitioner)

    // 对每个分区的数据进行排序并去top3
    val res = partitioned.mapPartitions(it => {
      it.toList.sortBy(_._2._2).reverse.iterator
    })

    res.saveAsTextFile("F:\\test\\spark\\out\\" + UUID.randomUUID())

    sc.stop
  }
}


class WebNetPartitioner(projects: Array[String]) extends Partitioner {


  // 用来存放科学和分区号
  private val projectsAndPartNum = new mutable.HashMap[String, Int]

  // 计数器 用于指定分区号
  var n = 0

  for (pro <- projects) {
    projectsAndPartNum += (pro -> n)
    n += 1
  }

  // 得到分区数
  override def numPartitions: Int = projects.length

  // 得到分区号
  override def getPartition(key: Any): Int = {

    projectsAndPartNum.getOrElse(key.toString, 0)

  }


}

object TTT {

  def main(args: Array[String]): Unit = {



  }

}
