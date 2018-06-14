package day10

/**
  * def sortBy[K](
  * f: (T) => K,
  * ascending: Boolean = true,
  * numPartitions: Int = this.partitions.length)
  * (implicit ord: Ordering[K], ctag: ClassTag[K]): RDD[T]
  *
  *
  * 第一种  排序 implicit ord: Ordering[K]  引入隐式 变量 实现 compare方法
  */
//
//import org.apache.spark.rdd.RDD
//import org.apache.spark.{SparkConf, SparkContext}
//
//object MySort{
//  implicit val girlOrdering = new Ordering[Girl]{
//    override def compare(x: Girl, y: Girl): Int = {
//      if (x.faceValue != y.faceValue){
//        x.faceValue - y.faceValue
//      } else {
//        if(x.age > y.age){
//          x.age -y.age
//        } else {
//          -1
//        }
//      }
//    }
//  }
//}
//object CustomSort {
//
//  def main(args: Array[String]): Unit = {
//
//    val conf = new SparkConf().setAppName("SparkRDDExercise").setMaster("local")
//    val sc = new SparkContext(conf)
//
//
//    val girlInfo: RDD[(String, Int, Int)] = sc.parallelize(Array(("tingting", 80, 25), ("ningning", 90, 26), ("mimi", 90, 27)))
//    MySort.girlOrdering
//    // 这里的sortBy 要看源码
//    val res = girlInfo.sortBy(x=>Girl(x._2,x._3),false)
//
//
//
//  }
//
//}
//
//
//case class Girl(faceValue:Int, age:Int){
//
//
//}
