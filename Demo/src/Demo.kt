import com.zxl.kotlin.Out
import java.io.File

fun main() {
    val md5 = "A2:22:B3:65:3C:E2:3C:47:C9:58:24:A8:27:5D:66:8C"
//    println(md5.replace(":", "").toLowerCase())
    val s = repeat(10){
//        print(it)
    }

//    print(s)

/*    var md51 = "F37701E853A256743587677A1A29FFCA"
    print(md51.toLowerCase())
    test(Out.One())*/
    files(arrayOf("1"))


}

fun files(args: Array<String>) {
    val fileNames: MutableList<String> = mutableListOf()
    //在该目录下走一圈，得到文件目录树结构
    val fileTree: FileTreeWalk = File("E:\\Decompile\\apkTool_New\\mingyuan\\lib\\armeabi-v7a").walk()
    fileTree.maxDepth(1) //需遍历的目录层次为1，即无须检查子目录
        .filter { it.isFile } //只挑选文件，不处理文件夹
//        .filter { it.extension == "txt"  } //选择扩展名为txt的文本文件
        .filter { it.extension in listOf("so","mp4") }//选择扩展名为txt或者mp4的文件
        .forEach { fileNames.add(it.name) }//循环 处理符合条件的文件
    fileNames.forEach(::println)
}

fun test(sca:Out){
    when(sca){
        is Out.One -> TODO()
        is Out.Two -> TODO()
    }
}

val <T> T.exhaustive: T
    get() = this