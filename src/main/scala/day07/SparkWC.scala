package day07

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object SparkWC {
  def main(args: Array[String]): Unit = {
    // 文件信息配置类
   val conf = new SparkConf()
    // 任务的名字  第二列 Name 例如 Spark shell 如果不指定则会自动生成UUID
    // local[1] 起一个线程  local[*]有多少空闲的CUP就起多少线程
    conf.setAppName("task1").setMaster("local[*]")

    // 创建一个上下文对象
    val sc = new SparkContext(conf)

//   // TODO 第二种方式 生成 RDD 能往里面传 Seq[T]
//   val rdd1 = sc.parallelize(Array(12,78,898,444,44,9))
//   val rdd2 = sc.parallelize(ArrayBuffer(12,78,898,444,44,9))
//   val rdd3 = sc.parallelize(List(12,78,898,444,44,9))
//   val rdd4 = sc.parallelize(ListBuffer(12,78,898,444,44,9))

    // 读取数据  这是生成 RDD的一种方式
    val lines = sc.textFile(args(0))
    // 处理数据
    val words = lines.flatMap(_.split(" "))
    val paired = words.map(_ -> 1)
    val reduced = paired.reduceByKey(_+_)
    val res = reduced.sortBy(_._2,false)
    // 保存
    res.saveAsTextFile(args(1))
    // 打印一下
    println(res.collect.toBuffer)


    // 结束任务
    sc.stop
  }
}
