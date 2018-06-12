package day11

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object SpecifyingSchema {

  def main(args: Array[String]): Unit = {

    // TODO 模板代码
    val conf = new SparkConf().setAppName("SQL_1").setMaster("local[*]")

    val sc = new SparkContext(conf)

    // TODO 已经过时了
    val sqlContext = new SQLContext(sc)

    // TODO 获取数据
    val lineRdd = sc.textFile("").map(_.split(" "))
    // 将 RDD[t] 和 class 进行关联    ,然后 to df

    // TODO 通过 StructType 指定么个字段的schema
    val schema = StructType(
      List(
        StructField("id", IntegerType, true),
        StructField("name", StringType, true),
        StructField("age", IntegerType, true),
        StructField("faceValue", IntegerType, true)
      )
    )

    // TODO 不同点
    // TODO 将RDD 映射到 rowRDD 并创建 DataFrame

    // 获取DataFrame
    val rowRDD = lineRdd.map(x => Row(x(0).toInt, x(1), x(2).toInt, x(3).toInt))
    // 把2个东西的映射起来
    val persionDF = sqlContext.createDataFrame(rowRDD,schema)

    // TODO 注册成为一张表
    persionDF.registerTempTable("t_person")

    // TODO 查询
    val res = sqlContext.sql("select * from t_person order by age desc limit 2")

    // TODO 输出
    res.write.json("")

    sc.stop
  }

}
