package com.zxl.study.myclass

open class OpenClass {

    open fun say() {
        println("OpenClass")
    }
}

class SonClass : OpenClass() {
    override fun say() {
        println("sonClass")
    }

    fun sonSay(){
        println("My--sonClass")
    }
}

fun main() {
    val open: OpenClass = SonClass()
    /**
     * as 智能类型转换，父类在使用as转换成子类后，后续的代码不需要再次进行类型转换，直接就可以使用子类的方法
     */
    (open as SonClass).sonSay()
    //如果没有上一步，使用as进行类型强转，此处则会报错
    open.sonSay()

    val open1 = object : OpenClass() {

    }

    val open2 = object : OpenClass() {

    }

    println(open1)
    println(open2)
}