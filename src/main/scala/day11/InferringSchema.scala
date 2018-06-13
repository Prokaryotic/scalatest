package day11

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object InferringSchema {
  def main(args: Array[String]): Unit = {

    // TODO 模板代码
    val conf = new SparkConf().setAppName("SQL_1").setMaster("local[*]")

    val sc = new SparkContext(conf)

    // TODO 已经过时了
    val sqlContext = new SQLContext(sc)

    // TODO 获取数据
    val lines = sc.textFile("")
    // 将 RDD[t] 和 class 进行关联    ,然后 to df
    val rdd = lines.map(_.split(" ")).map(x => Person(x(0).toInt, x(1), x(2).toInt, x(3).toInt))
    // TODO 创建DataFrame
    // 导入隐饰操作，否则RDD无法调用toDF方法
    import sqlContext.implicits._
    // 获取DataFrame
    val df = rdd.toDF


    // TODO 注册成为一张表
    df.registerTempTable("t_person")

    // TODO 查询
    val res = sqlContext.sql("select * from t_person order by age desc limit 2")

    // TODO 输出
    res.write.json("")

    sc.stop

  }
}


case class Person(id: Int, name: String, age: Int, faceValue: Int)
