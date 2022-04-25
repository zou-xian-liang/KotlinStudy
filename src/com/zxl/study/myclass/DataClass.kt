package com.zxl.study.myclass

/**
 * 数据类
 * 内部自己已实现了个性化的toString方法
 * copy函数的注意点：copy的时候，只是将主构造中的参数值复制了，至于次构造函数中赋值的字段值是没有复制的，需要手动进行赋值
 */
data class DataClass(var name: String, var age: Int) {
    private val hobby = "music"
    val subject: String
    var score = 0

    init {
        println("initializing")
        subject = "math"
    }

    constructor(_name: String) : this(_name, 10) {
        score = 10
    }

    override fun toString(): String {
        return "DataClass(name='$name', age=$age, hobby='$hobby', subject='$subject', score=$score)"
    }

}

data class ChongZai(var x:Int,var y:Int){
    //data类进行预算符的重载，如，+，+=，==,>,[]get获取指定位置元素

    //加入此处是坐标位置，可以通过重载实现求两个坐标地址之和
    operator fun plus(other:ChongZai)=ChongZai(x+other.x,y+other.y)
}

fun main() {
    val dataClass = DataClass("Jack")
    //copy的时候，只是将主构造中的参数值复制了，至于次构造函数中赋值的字段值是没有复制的，需要手动进行赋值
    val copy = dataClass.copy("Rose")
    println(dataClass)
    println(copy)

    val chongZai1 = ChongZai(1,2)
    println(chongZai1)
    val chongZai2 = ChongZai(2,3)
    println(chongZai1+chongZai2)
}