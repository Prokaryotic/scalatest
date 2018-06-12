package day11

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.types._

object DataFrameDemo {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[2]")
    conf.set("spark.sql.warehouse.dir","file:/E:/scala_workspace/z_spark_study/")
    conf.set("spark.sql.shuffle.partitions","20")
    val sparkSession = SparkSession.builder().appName("RDD to DataFrame")
      .config(conf).getOrCreate()

    val sc = new SparkContext(conf)

    val lines = sc.textFile("")

    // 这里一行是一个数组
    val line = lines.map(_.split(" "))
    // 将 RDD[t]   转为一个 object ,然后 to df
    val personRdd = line.map(x => Person(x(0).toInt, x(1), x(2).toInt, x(3).toInt))

    //导入隐饰操作，否则RDD无法调用toDF方法
    import sparkSession.implicits._
    val personDataFrame = personRdd.toDF

  }


}


case class Person(id: Int, name: String, age: Int, faceValue: Int)
