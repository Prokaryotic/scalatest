package day11

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object CheckPoint {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("SparkRDDExercise").setMaster("local")
    val sc = new SparkContext(conf)
    val girlInfo: RDD[(String, Int, Int)] = sc.parallelize(Array(("tingting", 80, 25), ("ningning", 90, 26), ("mimi", 90, 27)))
    sc.setCheckpointDir("hdfs://master:9000/具体路径")
    girlInfo.cache()
    // 要在shuffle之后进行  一般都是在前面先cache  设立检查点  都是2进制的数据存储
    girlInfo.checkpoint()


  }
}
