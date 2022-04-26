package com.zxl.study.basics

import java.io.File

/**
 * 标准 函数中的  作用域函数
 * Kotlin 标准库包含几个函数，它们的唯一目的是在对象的上下文中执行代码块。
 * 当对一个对象调用这样的函数并提供一个 lambda 表达式时，它会形成一个临时作用域。在此作用域中，可以访问该对象而无需其名称。
 * 这些函数称为作用域函数。共有以下五种：let、run、with、apply 以及 also
 *
 *
 * 调用一个个函数类配置接收者时，变量名省略掉了，这是因为在lambda中表达式中，apply能让每一个配置函数都作用于接收者
 * 这种行为有时又叫做相关作用域，因为lambda表达式里的所有函数调用都是针对接收者，或者说是针对接收者的隐式调用
 *
 * https://note.youdao.com/web/#/file/recent/markdown/WEBebccc34ba2d467a8ebfdbbd05a342d27/
 */
fun main() {

    //1、使用let进行安全调用，it指代调用对象，返回值为lambda表达式的值
    var string: String? = "letTest"
    string = string?.let {
        if (it.isNotBlank()) it.capitalize() else "空白字符"
    } ?: "string对象为null"

    //2、apply 使用this指代调用者对象，返回调用者
    var file = File("")
    file = file.apply {
        setReadable(true)
        setWritable(true)
    }

    //3、run函数 与apply类似，使用this指代调用者对象，返回的是lambda结果
    val run = "test".run {
        9
    }


    //4、 also 返回调用者对象    使用also交换两个变量的值
    var a = 2;
    var b =3;
    //首先 将原始a的值赋值给b，b就是2,原始b=3，also的返回值是原始调用对象，也就是3，将3赋值给a，达到交换两个变量值
    a= b.also { b=a }
    println(a.hashCode())
    println(b)

}