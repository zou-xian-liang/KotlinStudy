/**
 * 静态工具类的两种定义方法
 */
class StaticTest :Extend(){

    companion object {
        val test = "Test"
        var test1 = fun(name: String): String {
            println("test")
            return name
        }("cesh")

    }

    //也可以在object后加伴生对象companion的名称，通过类名+伴生对象名+字段名进行调用
   /* companion object T{
        val test = "Test"
    }*/
}

/**
 * 当只需要类中部分方法或者参数是静态的时候，可以使用这种方式创建
 * 在类中定义一个内部对象，注：一个类中只能有一个内部对象，然后将所有的静态方法和字段都放在内部对象中，而将非静态的方法和属性放在外部
 *
 * 使用companion修饰的object可以省略掉后面的类名，
 */
class A {


    //此处可以省略B，companion object{ var c: Int = 0 }
    companion object B {
        var c: Int = 0
    }

    fun test(){

    }
    //被object修饰的类只能有静态方法和静态字段，如果需要
    object C{

    }
}

/**
 * 类默认使用final修饰的是不可以继承的，如果需要类被进程需要用open修饰
 */
open class Extend{
   init {
        println("Extend")
    }
}

/**
 * 通过这个可以代替java中的单例
 */
object Singleton{
    var sex = "女"

    fun getSexTest():String{
        return this.sex

    }

}

fun main(){
    //静态工具类使用

//    println(StaticTest.test)
//    println(StaticTest.test1)
//    println(StaticTest().toString())

    //可以省略B，直接通过外部类调用伴生对象方法和参数
    println(A.B.c)
    println(A.c)
    println(share)
    println(forAll())
}