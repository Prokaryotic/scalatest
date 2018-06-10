package Day08

import org.apache.spark.{SparkConf, SparkContext}

object SparkRDDExercise {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("SparkRDDExercise").setMaster("local")
    val sc = new SparkContext(conf)


    // TODO 通过并行化生成 rdd
    val rdd1 = sc.parallelize(List(1, 5, 4, 8, 6, 2, 5, 565, 56, 78, 110, 10))


    // TODO 对rdd1里的每个元素乘以2然后排序
    // 第一个是 输出什么 第二个是升序 还是倒叙  true 是升序  false 是倒叙
    //    val rdd1_1 = rdd1.map(_*2).sortBy(x=>x,true)

    //    println(rdd1_1.collect.toBuffer)

    // TODO 过滤出大于等于10的元素
    //    val rdd1_2 = rdd1.filter(_ >= 10)
    //    println(rdd1_2.collect.toBuffer)

    // TODO 将元素以数组的方式打印出来


    val rdd2 = sc.parallelize(Array("a b c", "e f s", "h i d"))
    // TODO 将rdd2里面的每个元素先切分在压平
    //    val res = rdd2.flatMap(_.split(" "))

    val rdd3 = sc.parallelize(List(List("A D G", "D F G"), List("Q I O", "P L N"), List("Z C B", "M D T")))
    // TODO 将rdd3里的每个元素先切分在压平
    //    val res = rdd3.flatMap(_.flatMap(_.split(" ")))

    val rdd4 = sc.parallelize(List(5, 9, 6, 3, 3))
    val rdd5 = sc.parallelize(List(45, 9, 3, 15, 5))
    // TODO 求并集
    //    val res = rdd4 union rdd5


    // TODO 求交集
    //    val res = rdd4 intersection rdd5

    // TODO 去重
    //    val res = rdd4.distinct


    // 单词 ->个数
    val rdd6 = sc.parallelize(List(("tom", 1), ("jerry", 3), ("kitty", 2)))
    val rdd7 = sc.parallelize(List(("lijun", 5), ("tom", 99), ("kitty", 2)))

    // TODO 求join
    // 在类型（K，V）和（K，W）的数据集上调用时，返回包含每个键的所有元素对的（K，（V，W））对的数据集。
    // 就比如 rdd6 里面的 tom -> 1 和 tom ->99 会形成 tom ->(1,99)
    // val res = rdd6 join rdd7

    // TODO 求左连接和右连接  和数据库的一个意思 笛卡尔积
    //    val res = rdd6 leftOuterJoin rdd7
    //    val res = rdd6 rightOuterJoin  rdd7


    // TODO 求并集
    // 结果 ArrayBuffer((tom,1), (jerry,3), (kitty,2), (lijun,5), (tom,99), (kitty,2))
    //    val res = rdd6 union rdd7

    // TODO 按key进行分组
    //    val res = rdd6.groupByKey

    // TODO 分别用groupByKey 和 reduceByKey 实现单词计数 注意groupByKey与reduceByKey的区别
    // groupByKey 是生成 一个key - list的形式 list里是一个一个（key-value）
    //    val res = rdd6.union(rdd7).groupByKey.mapValues(_.sum)
    // reduceByKey 是直生成key -value 其中的value 是同一个key的所有value通过func: (V, V) => V
    // 第一个V 会是上一次计算的result
    //    val res = rdd6.union(rdd7).reduceByKey(_ + _)


    // 单词 ->个数
    val rdd8 = sc.parallelize(List(("tom", 1), ("tom", 2), ("jerry", 3), ("kitty", 2)))
    val rdd9 = sc.parallelize(List(("jerry", 2), ("tom", 99), ("shuke", 2)))

    // TODO cproup 注意cogroup和groupByKey 的区别
    // 结果    ArrayBuffer((tom,(CompactBuffer(1, 2),CompactBuffer(1))), (jerry,(CompactBuffer(3),CompactBuffer(2))), (shuke,(CompactBuffer(),CompactBuffer(2))), (kitty,(CompactBuffer(2),CompactBuffer())))
    //    cogroup 生成的结果是 key -> (CompactBuffer(RDD8 里面 对应key 的value 的集合),CompactBuffer(RDD9 里面 对应key 的value 的集合))
    //    val res = rdd8 cogroup rdd9

    val rdd10 = sc.parallelize(List(1, 2, 3, 4, 5))
    // TODO reduce 聚合
    //    val res = rdd10.reduce(_+_)
    //    println(res)

    val rdd11 = sc.parallelize(List(("tom", 1), ("jerry", 3), ("kitty", 2), ("shuke", 1)))
    val rdd12 = sc.parallelize(List(("jerry", 2), ("tom", 3), ("shuke", 2), ("kitty", 5)))

    val rdd13 = rdd11.union(rdd12)

    // TODO 按value的降序排序
    // TODO 第一种 sortBy(第一个参数表示 按照元组里的什么进行排序 第二个表示是否是 升序 true 是升序 false 是降序)
//        val res = rdd11.reduceByKey(_+_).sortBy(_._2,false)
    // TODO 第二种 两极反转 7777777777777
    //    val res = rdd11.reduceByKey(_+_).map(e =>(e._2,e._1)).sortByKey(false).map(e=>(e._1,e._2))

    // TODO 笛卡尔积
    // 结果 ArrayBuffer(((tom,1),(jerry,2)), ((tom,1),(tom,3)), ((tom,1),(shuke,2)), ((tom,1),(kitty,5)), ((jerry,3),(jerry,2)), ((jerry,3),(tom,3)), ((jerry,3),(shuke,2)), ((jerry,3),(kitty,5)), ((kitty,2),(jerry,2)), ((kitty,2),(tom,3)), ((kitty,2),(shuke,2)), ((kitty,2),(kitty,5)), ((shuke,1),(jerry,2)), ((shuke,1),(tom,3)), ((shuke,1),(shuke,2)), ((shuke,1),(kitty,5)))
//    val res = rdd11.cartesian(rdd12)

    // 其他 count top take first takeOrdered
//    println(res.collect.toBuffer)
  }
}


object Exercise {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("SparkRDDExercise").setMaster("local")
    val sc = new SparkContext(conf)


    // TODO 通过并行化生成 rdd
    val rdd1 = sc.parallelize(List(1, 5, 4, 8, 6, 2, 5, 565, 56, 78, 110, 10))


    // TODO 对rdd1里的每个元素乘以2然后排序
    // 第一个是 输出什么 第二个是升序 还是倒叙  true 是升序  false 是倒叙




    // TODO 过滤出大于等于10的元素


    // TODO 将元素以数组的方式打印出来


    val rdd2 = sc.parallelize(Array("a b c", "e f s", "h i d"))
    // TODO 将rdd2里面的每个元素先切分在压平


    val rdd3 = sc.parallelize(List(List("A D G", "D F G"), List("Q I O", "P L N"), List("Z C B", "M D T")))
    // TODO 将rdd3里的每个元素先切分在压平


    val rdd4 = sc.parallelize(List(5, 9, 6, 3, 3))
    val rdd5 = sc.parallelize(List(45, 9, 3, 15, 5))
    // TODO 求并集



    // TODO 求交集


    // TODO 去重



    // 单词 ->个数
    val rdd6 = sc.parallelize(List(("tom", 1), ("jerry", 3), ("kitty", 2)))
    val rdd7 = sc.parallelize(List(("lijun", 5), ("tom", 99), ("kitty", 2)))

    // TODO 求join
    // 在类型（K，V）和（K，W）的数据集上调用时，返回包含每个键的所有元素对的（K，（V，W））对的数据集。
    // 就比如 rdd6 里面的 tom -> 1 和 tom ->99 会形成 tom ->(1,99)


    // TODO 求左连接和右连接  和数据库的一个意思 笛卡尔积



    // TODO 求并集



    // TODO 按key进行分组


    // TODO 分别用groupByKey 和 reduceByKey 实现单词计数 注意groupByKey与reduceByKey的区别



    // 单词 ->个数
    val rdd8 = sc.parallelize(List(("tom", 1), ("tom", 2), ("jerry", 3), ("kitty", 2)))
    val rdd9 = sc.parallelize(List(("jerry", 2), ("tom", 99), ("shuke", 2)))

    // TODO cproup 注意cogroup和groupByKey 的区别


    val rdd10 = sc.parallelize(List(1, 2, 3, 4, 5))
    // TODO reduce 聚合


    val rdd11 = sc.parallelize(List(("tom", 1), ("jerry", 3), ("kitty", 2), ("shuke", 1)))
    val rdd12 = sc.parallelize(List(("jerry", 2), ("tom", 3), ("shuke", 2), ("kitty", 5)))

    val rdd13 = rdd11.union(rdd12)

    // TODO 按value的降序排序
    // TODO 第一种 sortBy(第一个参数表示 按照元组里的什么进行排序 第二个表示是否是 升序 true 是升序 false 是降序)

    // TODO 第二种 两极反转 7777777777777


    // TODO 笛卡尔积

    // 其他 count top take first takeOrdered

//    println(res.collect.toBuffer)
  }
}
