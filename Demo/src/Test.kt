fun main() {
    var a = 1
    val s1 = "a is $a"// 模板中的简单名称：
    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"// 模板中的任意表达式：
    println(s2)
    println("max of 0 and 42 is ${maxOf(0, 42)}")// $如果后面跟的是表达式，表达式小用{}包起来
    println(arrayOfMinusOnes(5).forEach { print(it) })
    exchangeValue(2, 5)
    InitOrderDemo("hello")
    var t = T()
//    t.isTest=true
    println(t.isTest)

    println(t.age)

    //带有默认值的参数不在第一位，这第一位可以直接给具体值即可
    val param = param(2,param3 = 3)
/*    println("不给param2的值$param")
    //默认带参数值的参数在首位，则每个参数的值都应按参数名=参数值的形式给出(且此处的参数名跟方法中形参名需保持一致)
    println(param1(paramB = 2))

    param2(1, qux = { println("这是lambda表达式中输出的内容") })
    param2(1) { println("hello") } // 使用默认值 baz = 1
    param2(qux = { println("hello") }) // 使用两个默认值 bar = 0 与 baz = 1
    param2 { println("hello") }//使用三个默认值，将lambda参数在()外传入*/


    inList()


}

/**
 * 方法参数中带有lambda
 * 那么它既可以作为命名参数在括号内传入，也可以在括号外传入：
 */
fun param2(bar: Int = 0, baz: Int = 1, qux: () -> Unit) {}

/**
 * 方法有多个参数的时候，如果带有默认值的参数不在首位，则调用方式和在首位的调用方式是不一样的
 */
fun param(param1: Int, param2: Int = 5,param3:Int): Int {
    return param1 + param2
}

/**
 * 方法有多个参数的时候，如果带有默认值的参数不在首位，则调用方式和在首位的调用方式是不一样的
 * 默认带参数值的参数在首位，则每个参数的值都应按参数名=参数值的形式给出(且此处的参数名跟方法中形参名需保持一致)
 */
fun param1(paramA: Int = 2, paramB: Int): Int {
    return paramA + paramB
}

/**
 * 创建指定长度的数组，并将数组元素的值设为-1
 */
fun arrayOfMinusOnes(size: Int): IntArray {
    return IntArray(size).apply { fill(-1) }
}

/**
 * 交换两个变量的值
 */
fun exchangeValue(value1: Int, value2: Int) {
    var a1 = value1
    var a2 = value2
    a1 = a2.also { a2 = a1 }
    println("交换之后a2的值$a2")
}

/**
 * 创建对象的方式
 */
fun testCreateObject() {
    val rectangle = Rectangle(5.0, 2.0) // 创建不需要“new”关键字
    val triangle = Triangle(3.0, 4.0, 5.0)
//sampleEnd
    println("Area of rectangle is ${rectangle.calculateArea()}, its perimeter is ${rectangle.perimeter}")
    println(rectangle.isSquare)
    println("Area of triangle is ${triangle.calculateArea()}, its perimeter is ${triangle.perimeter}")
}

/**
 * 用in来判断集合中是否包含实例
 */
fun inList() {
    val items = setOf("apple", "banana", "kiwifruit")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }

    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")

    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach {

            println("这是测试"+it) }
}

/**
 * 迭代测试
 */
fun iteration() {
//区间迭代，打印1-5
    for (x in 1..5) {
        print(x)
    }
//    数列迭代
    println("打印以2位差值的等差数列")
    for (x in 1..10 step 2) {
        print(x)
    }
    println()
    for (x in 9 downTo 0 step 3) {
        print(x)
    }
//sampleEnd
}

fun forTest() {
    //遍历
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }

    println(items.size)

    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

/**
 * 方法定义
 * a:Int:表示变量a，类型是Int
 * 方法名maxOf后面的：Int表示返回值类型
 */
fun maxOf(a: Int, b: Int): Int {
    return if (a > b) a else b
}