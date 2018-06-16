package day04

import scala.io.Source
//import day04.FilePredef.fileToRichFile
//import day04.FilePredef.fileToRichFile1

/**
  * 应是调用的笔记具体看word笔记
  *
  * @param filePath
  */
class RichFile(val filePath: String) {

  def read(): String = {
    Source.fromFile(filePath).mkString + "RichFile" //读取所有的行
  }
}

class RichFile1(val filePath: String) {

  def read(): String = {
    Source.fromFile(filePath).mkString + "RichFile1" //读取所有的行
  }
}

object RichFile {
  def main(args: Array[String]): Unit = {

    // 这个过程是显示的调用过程read
    //    val lines = RichFile("F:\\test\\io\\测试文件2.txt").read()
    //    println(lines)


    // 隐式的实现这个调用过程read  RichFile("F:\\test\\io\\测试文件2.txt") 的过程被import day04.FilePredef.fileToRichFile 代替了
    //  这个类是我自己建立的  可以声明在外面package day04 的下面 实现全局调用
    //    import day04.FilePredef.fileToRichFile
    //    val lines2 = "F:\\test\\io\\测试文件2.txt".read() //引用隐式转换函数后 等价于 RichFile("F:\\test\\io\\测试文件2.txt").read()
    //    println(lines2)
  }

  def apply(filePath: String): RichFile = new RichFile(filePath)

}

object RichFile1 {
  def main(args: Array[String]): Unit = {

    // 这个过程是显示的调用过程read
    val lines = RichFile("F:\\test\\io\\测试文件2.txt").read()
    println(lines)


    // 隐式的实现这个调用过程read  RichFile("F:\\test\\io\\测试文件2.txt") 的过程被import day04.FilePredef.fileToRichFile 代替了
    //  这个类是我自己建立的  可以声明在外面package day04 的下面 实现全局调用

    //    val lines2 = "F:\\test\\io\\测试文件2.txt".read() //引用隐式转换函数后 等价于 RichFile("F:\\test\\io\\测试文件2.txt").read()

  }

  def apply(filePath: String): RichFile1 = new RichFile1(filePath)

}
