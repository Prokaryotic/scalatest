package day04

object FilePredef {
  implicit def fileToRichFile1(filePath:String):RichFile1 = RichFile1(filePath)
  // 隐式转换函数 以后就可以直接用 字符串 就是创建 RichFile(filePath) 然后可以使用 RichFile的各种方法了
  implicit def fileToRichFile(filePath:String):RichFile = RichFile(filePath)

}
