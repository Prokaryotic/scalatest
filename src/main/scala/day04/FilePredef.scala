package day04

object FilePredef {


  implicit def fileToRichFile1(filePath: String): RichFile1 = RichFile1(filePath) //
  //  相当于可以隐式转换类了  比如 string 就可以转换成 RichFile类了
  // 隐式转换函数 以后就可以直接用 字符串 就是创建 RichFile(filePath) 然后可以使用 RichFile的各种方法了
  implicit def fileToRichFile(filePath: String): RichFile = RichFile(filePath)

  //对应 ViewBoundDemo
  // 隐式转换函数 转换成拎一个对象 并实现里面的特性  传入一个g:Girl =>返回一个Ordering[Girl]
  implicit val selectGirl = (g: Girl) => new Ordered[Girl] {
    override def compare(that: Girl): Int = {
      if (g.faceValue == that.faceValue) {
        -1
      } else {

        1
      }
    }
  }


  // 对应 ContextBoundDemo  这是一个隐式转换 把
  implicit object OrderingGirl extends Ordering[Girl] {
    override def compare(x: Girl, y: Girl): Int = {
      if (x.faceValue > y.faceValue){
        1
      } else{
        -1
      }

    }
  }


}
