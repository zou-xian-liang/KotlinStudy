package com.zxl.study.myclass

class JieGou(val name: String = "张三", val age: Int = 12) {

    operator fun component1() = name
    operator fun component2() = age
}

data class JieGou1(val name: String = "张三", val age: Int = 12) {

}

fun main() {
    val (name, age) = JieGou()
    val (x, y) = JieGou1()

    println("$name $age")
    //数据类data 自带解构，普通类需要自己实现
    println("$x $y")
}