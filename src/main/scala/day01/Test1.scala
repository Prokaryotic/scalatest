package day01


import scala.collection.mutable._



class Test1 {
  def method(x: Int, y: Int): Int = x + y

  def method(f: (Int, Int) => Int) = f(3, 4)

  val f1 = (x: Int, y: Int) => x + y
}

object Test1 {
  def main(args: Array[String]): Unit = {
    //    var str = "aaa"
    //    println(str)
    //    val x = 3
    //    val y = if(x>1) 1 else -1
    //    for (i<- 1 to 10){
    //      println(i)
    //    }

    //    val arr = Array("java","scala","C#")
    //    for(i <- arr){
    //      println(i)
    //    }

    //    val arrs = for(i <- 1 to 3;j <- 1 to 3 )   yield  (i+""+j)
    //
    //    println(arrs)


    //    val arr = new Array[Int](8)


    //  val arr3 = ArrayBuffer[Int]()
    //    //追加 一个元素1
    //    arr3+=1
    //    //追加 一个元组
    //    arr3+=(2,3,4)
    //    // 追加 一个定量数组
    //    arr3 ++=Array(5,6)
    //    // 追加一个变长数组
    //    arr3 ++=ArrayBuffer(7,8)
    //    // 第一个参数是下标  后面是要在第0个参数前面插入的东西
    //    arr3.insert(0,-1,0)
    //    // 第一个参数是下标 后面表示要在第2个参数开始删除 2个参数 就是要删除 下标为0和1的参数
    //    arr3.remove(0,3)


    //
    //    // 遍历输出 arr里的东西
    //    for (i<-arr) println(i)
    //    // 根据下标取
    //    for(i <-0 until arr.length) println(arr(i))
    //    // 根据下标取 倒着来
    //    for(i <-(0 until arr.length).reverse) println(arr(i))


    //    val arr = Array(1,2,3,4,5,6)
    //    // 产生一个新的数组
    //    val res = for (i <- arr) yield i*10

    //    // 通过->
    //    val map1 = Map("scala" -> 1, "java"->2)
    //    //通过元组的方式
    //    val map2 = Map(("scala",1),("java",2))

    //    // 获取值 如果没有的对应的 就会报错
    //    map1("scala")
    //    // 第一个参数是key值 第二个是如果没有第一个key的值 那么就返回第二个默认的值
    //    map1.getOrElse("scala",-1)
    //    // 修改
    //    map1("scala") = 3


    //    // 创建一个元组 元组里可以有元组
    //    val t = ("scala",100L,3.14,("java",1))
    //    // 获取元组里 第一个值
    //    println(t._1)
    //    // 获取元组里 第四个值(他也是一个元组) 然后再获取这个元组里第一个值
    //    println(t._4._1)


    //    // 在里面的时候直接给这些元素给一个名称
    //    val t,(a,b,c,d) = ("scala",100L,3.14,("java",1))
    //    // 直接输出a
    //    println(a)

    //    // 创建一个元组数组
    //    val arr = Array(("zhangsan", 23), ("lisi", 30), ("wangwu", 50), ("zhangliu", 10))
    //    // 把他装换成map
    //    arr.toMap


        // 拉链操作
        val arr1 = Array("tingting", "ninging", "zhangsan")
        val arr2 = Array(20, 45, 10)
        // 前面的数组是key 后面的是value

        val res = arr1.zip(arr2)

        println(res.toMap)


        println()
        println


//    val set1 = new HashSet[Int]()
//    val set2 = set1 + 1
//    val set3 = set2 ++ Set(2,3,4)

//    val set1 = new HashSet[Int]()
//    set1 += 1
//    set1.add(3)
//    set1 ++=Set(4,5,6)  // set添加的时候有一个随机性 有去重的功能
//    set1 -=1  // 把1删除
//    set1.remove(3) // 把3移除掉


    val map1 = new HashMap[String,Int]()
    map1("scala") = 1
    map1 += (("java",2))
    map1 += (("python",3),("C",4))
    map1 +=(("C++"->5))
    map1.put("C#",6)

    map1 -="java"
    map1.remove("java")

//
//    println(map1)
  }

}
