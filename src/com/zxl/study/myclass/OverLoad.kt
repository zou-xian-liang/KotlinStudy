package com.zxl.study.myclass

data class OverLoad(var x: Int, var y: Int) {
    val isInBounds = x > 0 && y > 0

    //运算符重载需要在方法前使用operator
    operator fun plus(other: OverLoad) = OverLoad(x + other.x, y + other.y)

}

fun main() {
    val overLoad1 = OverLoad(1, 2)
    val overLoad2 = OverLoad(2, 3)
    println(overLoad1 + overLoad2)
}