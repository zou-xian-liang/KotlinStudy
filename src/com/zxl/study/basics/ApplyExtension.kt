package com.zxl.study.basics

import java.io.File

fun String.convert()= "!".repeat(this.count())

/**
 * apply 作用域函数详解
 *
 * https://www.kotlincn.net/docs/reference/scope-functions.html
 */


/**
 * 已apply来详解作用域函数
 *
 * T.()->Unit 表示的是：传入的要是泛型T的扩展函数，而不是一个普通的匿名函数，因为在扩展函数里自带了this的隐式调用
 *
 * 如果是()->Unit 则表示普通的匿名函数即可
 *
 * T.() 带接收者的函数字面量
 */
public inline fun <T> T.apply(block: T.() -> Unit): T {
    //this.block()
    block()
    return this
}

//将泛型apply拆解，以File类进行具象化演示
public inline fun File.apply(block: File.() -> Unit): File {
    //this.block()
    block()
    return this
}

fun main() {

    "abc".convert().printlnMe()
    //将这个函数进行分解
    //DSL 写法
    val file = File("").apply {
        setReadable(true)
    }
    //1、定义扩展函数
    fun File.ext():Unit{
        setReadable(true)
    }

    //File::ext 函数对象
    //2、给apply中的block赋值
    val block = File::ext

    //3、传入apply函数
    File("").apply(block)
    File("XXX").apply { block }

}