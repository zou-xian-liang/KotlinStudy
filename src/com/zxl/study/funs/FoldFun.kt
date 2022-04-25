package com.zxl.study.funs

/**
 * fold 可以用来合并值的合并函数
 * 这个合并函数接受一个初始累加器值，随后会根据匿名函数的结果更新。
 */
fun main() {
    //accoumulator开始对应的值是initial-->0;number对应的listof的集合的第一个元素的值
    //第一次执行结束后，accoumulator对应的就是第一次的结果值，也就是3了
    val foldValue = listOf(1, 2, 3, 4)
        .fold(0) { accoumulator, number ->
            println("Accoumulator=$accoumulator")
            accoumulator + (number * 3)
        }

    println(foldValue)

}