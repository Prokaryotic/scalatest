package day02

object Exercise {

  def main(args: Array[String]): Unit = {
    // TODO 创建一个List
    val list0 = List(1, 7, 9, 8, 0, 3, 5, 4, 6, 2)

    // TODO 将lst0中每个元素乘以10后生成一个新的集合
    val list1 = list0.map(_ * 2)

    // TODO 将lst0中的偶数取出来生成一个新的集合
    val list2 = list0.filter(_ % 2 == 0)

    // TODO 将lst0排序后生成一个新的集合
    val list3 = list0.sorted

    // TODO 反转顺序
    val list4 = list0.reverse

    // TODO 将lst0中的元素4个一组,类型为Iterator[List[Int]]
    val it = list0.grouped(4)
    // 这里的res 是 List(1, 7, 9, 8)
    val res =it.next

    // TODO 将Iterator转换成List
    val list5 = it.toList

    // TODO 将多个list压扁成一个List
    val list_6_1 = List(List(1, 2), List(3, 9), List(11, 8))
    val list6 = list_6_1.flatten

    // TODO 先按空格切分 在压平  当list里面是(_,_)元组的时候才能 toMap
    val strs = List("1 2 3 4 5 6 7 8", "9 10 11", "12 13 14")
    val list7 = strs.flatMap(_.split(" ")) //等价于 strs.map(_.split(" ")).flatten

    // TODO 先按空格切分 在压平 然后计算里面字符出现频率 按频率高-》低 输入结果
    val res7_1 = strs.map(_.split(" ").map(_->1)).flatten.groupBy(_._1).mapValues(_.size).toList.sortBy(_._2)

    // TODO 并行求和计算  (并行 是一个时间点多个任务进行  并发是 一个时间段内多个任务进行)
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
    // 先调用par相当于并行去调用 一旦是调用par的话 那么他就不是顺序执行了 因为每个线程的完成顺序是有随机性的
    // 调用了几个线程也是随机的
    val res0 = arr.par.sum

    // TODO 按照特定的顺序进行聚合
    // 第一个下划线表示 拿到的第一个元素 第二个下划线表示拿到的第二个元素
    // 第一个下划线是前面的结果 第二个是接下来的元素 这样进行递归
    // 这种情况下和 arr.reduceLeft(_+_) 一样 这是从左往右  如果是right的话是从右往左进行
    val res1 = arr.reduce(_ + _)


    // 调用了几个线程也是随机的
    // 你会发现 结果是会变的 这是因为线程数是改变的
    val resPar = arr.par.reduce(_ - _)
    // 你会发现 结果是不会变的 因为顺序是固定的
    val res1_left = arr.par.reduceLeft(_ - _)
    // 你会发现 结果是不会变的 因为顺序是固定的
    val res1_right = arr.par.reduceRight(_ - _)
    // TODO 折叠：有初始值(无特定顺序)
    // 调用折叠方法fold 在给一个初始值 的情况下 就是说第一个下划线_ 是给的初始值 然后再从arr里拿第一个作为第二个_ 然后才是开始递归
    val res2 = arr.fold(0)(_ + _)

    // TODO 折叠：有初始值(有特定顺序) 使用par的话也是固定的结果
    // 从左往右开始 就是说第一个下划线_ 是给的初始值0 然后再从arr里拿第一个作为第二个_ 然后才是开始递归
    val res3 = arr.foldLeft(0)(_ + _)
    // 从右往左开始 就是说第一个下划线_ 是给的初始值0 然后再从arr里拿第一个作为第二个_ 然后才是开始递归
    val res4 = arr.foldRight(0)(_ + _)
    // 你会发现 结果是不会变的 因为顺序是固定的
    val res3_left = arr.par.foldLeft(0)(_ - _)
    // 你会发现 结果是不会变的 因为顺序是固定的
    val res4_right = arr.par.foldRight(0)(_ - _)

    // TODO 聚合 如果是数字的话所有的数组加起来 如果是字符的话是有的字符拼接起来
    val list8 = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
    val res8_fla = list8.flatten.reduce(_ + _)
    // 等价于  第一个下划线_ 代表的是初始值0 第二个下划线代表的是里面的每个小的List 注意每一个部分的 List都要与初始值进行 比如上面的list8 就是要进行3次的_ + _.sum
    // 0+list.sum 返回的值是小的list一个总的值+初始值
    // 注意每个List都要和初始值进行_ + _.sum
    // 后面就相当于是 对这个结果的List 进行_ + _
    val res8_agg = list8.aggregate(0)(_ + _.sum, _ + _)


    val l1 = List(5, 6, 7, 1)
    val l2 = List(1, 4, 3)
    // TODO 求并集
    // l1 中的元素 和l2 中2个加起来的元素  可以有重复值
    val res9 = l1 union l2

    // TODO 求交集
    // l1 中的元素 和 l2中 相同的元素 例如 1
    val res10 = l1 intersect l2

    // TODO 求差集
    // l1 中的元素 去除 l2 的元素 5,6,7  去除了1
    val res11 = l1 diff l2

    // 交集的结果和差集的结果 的并集 是l1


    println(res11)

  }
}

object Es {

  def main(args: Array[String]): Unit = {


    // TODO 创建一个List
    val list0 = List(1, 7, 9, 8, 0, 3, 5, 4, 6, 2)


    // TODO 将lst0中每个元素乘以10后生成一个新的集合



    // TODO 将lst0中的偶数取出来生成一个新的集合


    // TODO 将lst0排序后生成一个新的集合 升序


    // TODO 反转顺序



    // TODO 将lst0中的元素4个一组,类型为Iterator[List[Int]]

    // TODO 将Iterator转换成List


    val lists = List(List(1,5,8,7,7),List(9,9,8,7,52),List(8,5,6,2,4))
    // TODO 将多个list压扁成一个List


    val lines = List("4 5 8 4 1","5 7 8 9 8 7 8 8 5 49 8 7 89 45 54 654"," ")
    // TODO 先按空格切分 在压平



    // TODO 并行求和计算  (并行 是一个时间点多个任务进行  并发是 一个时间段内多个任务进行) 458415789878854987894554654



    // TODO 先按空格切分 在压平 然后计算里面字符出现频率 按频率高-》低 输入结果



    // TODO 按照特定的顺序进行聚合



    // TODO 折叠：有初始值(无特定顺序)


    // TODO 折叠：有初始值(有特定顺序) 使用par的话也是固定的结果


    val list7 = List(List(4, 5, 4), List(6, 8, 7, 4, 5, 4, 2, 1, 10, 45), List(9, 8, 7, 4, 88, 4, 7, 1, 2, 0))
    // TODO 聚合 如果是数字的话所有的数组加起来 如果是字符的话是有的字符拼接起来



    val list8 = List(1,2,3,5,8,9)
    val list9 = List(1,5,7,8,9)

    // TODO 求并集


    // TODO 求交集


    // TODO 求差集



//    println(res)
  }
}
