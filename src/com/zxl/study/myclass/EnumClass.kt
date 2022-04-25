package com.zxl.study.myclass

/**
 * 枚举，可以用来表述一组子类型的闭集，枚举类就是一种简单的ADT
 */
enum class EnumClass( val age: String) {
    EAST("0"),WEST("9"),SOUTh("00"),NORTH("90")
}

fun main() {
    println(EnumClass.WEST.ordinal)
    println(EnumClass.EAST is EnumClass)
}