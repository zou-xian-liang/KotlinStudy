/**
 * Kotlin 基础知识
 */
fun main(){
    println(testParam(b = "cba"))
}

/**
 * 变量定义
 */
fun variable(){
    var aInt = 1
    //如果需要给变量赋null值，则需要在定义变量的时候，指定该变量可空
    var string:String?
    string = null

}
/**
 * 参数默认值，以及调用时需要使用具名参数
 */
fun testParam(a: Int=0,b:String="abc"):String{
    return "$a$b"
}