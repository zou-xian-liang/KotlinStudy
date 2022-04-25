package com.zxl.study.basics

/**
 * 详解kotlin中的常用注解
 */
@file JvmName("Annotation")
fun main() {

    //1、使用@JvmName注解指定编译类的名字



}

/**
 * Kotlin顶层函数在Java里都被当做静态方法看待和调用
 * @param str String
 */
fun print(str :String){
    str.printlnMe()
}