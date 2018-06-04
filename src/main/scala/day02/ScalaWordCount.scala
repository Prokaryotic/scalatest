package day02

object ScalaWordCount {

  def main(args: Array[String]): Unit = {

    val lines = List("hello java hello C#", "hello c hello c++", "hello python hello scala")

    // 压平并切分
    val words = lines.flatMap(_.split(" ")).sorted

    // 把每个单词 生成一个一个的tuple 元组
    val tuples = words.map((_ -> 1))
    println(tuples)
    // 以key (单词) 进行分组  外面是一个大的map map里的value 是一个list list里的东西是一个一个元组
    val groups =  tuples.groupBy(_._1)

    // 统计 mapValues (忽略 key) 第一个_表示每个value 这里表示一个list
    // 返回的是 map 每个key对应一个  _.size
    val sumed = groups.mapValues(_.size)

    // 排序 map不能进行排序 先转换成 list 然后再排序
    // 升序
    val sumed_asc = sumed.toList.sortBy(_._2)
    // 降序
    val sumed_desc = sumed_asc.reverse
  }
}
