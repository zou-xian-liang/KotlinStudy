@file:JvmName("Annotation")

package com.zxl.study.basics

import java.io.IOException
import java.util.*

/**
 * 详解kotlin中的常用注解
 */
fun main() {

    //1、使用@JvmName注解指定编译类的名字
    //@file:JvmName("Annotation")
    //2、JvmField Java中在使用类的参数时，可以直接通过类名.参数名进行使用；消除了变量的getter与setter方法； 把变量用 public 暴露出来
    //3、JvmOverloads，对于Kotlin中函数多参数都有默认值的情况，使用该注解可以类似java的重载，会生成对应的重载方法
    //4、Throws
    // 5、JvmStatic作用于伴生对象

    //throwException 不加Throws
    try {
        throwException()
    } catch (ex: IOException) {

    }

}

/**
 * Kotlin顶层函数在Java里都被当做静态方法看待和调用
 * @param str String
 */
@JvmOverloads
fun print(str: String = "default", age: Int = 0) {
    str.printlnMe()
}

@Throws(IOException::class)
fun throwException() {
    throw IOException()
}

val translator = { utterance: String ->

    println(
        utterance.lowercase().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
    )
}

