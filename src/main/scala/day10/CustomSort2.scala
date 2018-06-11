package day10

/**
  * 第二种排序 让Girl对象继承 Orderd[K]  实现compare方法
  */

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object CustomSort {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("SparkRDDExercise").setMaster("local")
    val sc = new SparkContext(conf)


    val girlInfo: RDD[(String, Int, Int)] = sc.parallelize(Array(("tingting", 80, 25), ("ningning", 90, 26), ("mimi", 90, 27)))

    // 这里的sortBy 要看源码 
    val res = girlInfo.sortBy(x=>Girl(x._2,x._3),false)



  }

}


case class Girl(faceValue:Int, age:Int) extends Ordered[Girl]{
  override def compare(that: Girl): Int = {
    if (this.faceValue != that.faceValue){
      this.faceValue - that.faceValue
    } else {
      if(this.age > that.age){
        this.age -that.age
      } else {
        -1
      }
    }
  }

}
