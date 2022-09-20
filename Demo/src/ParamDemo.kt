/**
 * 字段定义以及非空安全测试
 */
class ArgumentsTest(name: String) {
    //lateinit：主要用于变量在定义的时候无法进行初始化，但是在调用的时候一般都是进行过初始化的，如Android中的findViewById
    lateinit var f: String
    //基本数据类型是不能用lateinit修饰的
//    lateinit var num:Int

    //直接这样定义是会报错的，因为这种引用类型在定义为null是会引发异常的，如空异常
//    var name:String=null
    //解除非空限制，使得字段值可以定义为空，这种在kotlin中叫可空类型，如解析服务器返回的json数据，事前不知道该字段是否会出现为空的情况
    var name: String? = name
    var tes: String?=""




    //Elvis 操作符?:操作示例，两个方法其实是等价的
    fun validate(user: User) {
        tes = null

        val id = user.id ?: return // 👈 验证 user.id 是否为空，为空时 return
    }
    // 等同于
    fun validate1(user: User) {
        if (user.id == null) {
            return
        }
        val id = user.id
    }
}

fun main(){
    var argumentsTest = ArgumentsTest("名称")
    //
    println(argumentsTest.name?.length)

    //类型推断---即在定义类型的时候可以不写变量类型，在使用该变量的时候会直接进行类型推断
    val name1 = "类型推断"
    //kotlin中方法的参数默认用val，类的参数用var
    val name2:String="类型推断"
    //下面两种方式是等价的，意思是只有当name不是null时才会调用lenght，调用前做了空安全检测，且可以保证多线程的情况下也是安全的
    var length = name1.length
    println(length)
    println(name2.length)

    //val和var的区别
    // var(variable变量)就是普通的参数声明，声明之后可以在使用的过程对值进行修改
    // val(value值)只能被初始化一次，设置值之后就不支持再次修改了 类型Java中的final

    val str: String? = "Hello"
    //?.和?:解释：?.表示当str不为null时才会调用length方法，?:表示当前面的str为空时，整个表达式返回值为-1
    val length1: Int = str?.length ?: -1
    val length2: Int = str?.length ?: return    //如果str为空，则结束方法

    var sr: String? = null
    //这种!!在为null的时候也会调用length，但是会直接抛出异常，意思是告诉编译期，保证sr是非空的，不用在编译期进行检查
//    println(sr!!.length)
}




