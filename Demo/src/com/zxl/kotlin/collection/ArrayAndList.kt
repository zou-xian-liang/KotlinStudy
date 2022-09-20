package com.zxl.kotlin.collection

import java.util.Collections.copy

/**
 * 主要用来学习array+list+set+map
 */
class ArrayAndList {

    init {
        println("init")
    }
    var array: Array<Int> = arrayOf(1, 2)
    //这种方法数组元素免于装箱，不需要转为Integer，可以节省内存
    var arr: IntArray = intArrayOf(1,2)

    var list:List<String> = listOf("a","b")

    var set1: Set<String> = setOf("1", "2")

    //使用to将键和值关联    直接使用mapOf创建的map是不能修改值的但是可以通过toMutableMap转成新的集合，该方法返回的是一个新的map
    //原始的map还是不可变的，对map的操作需要在toMutableMap的返回map上进行操作
    var map: Map<String, Int> = mapOf("1" to 1,"2" to 2)
    var value = map["1"]

    //使用mutableMapOf创建的map可以进行值的修改
    var mutableMap: Map<String, Int> = mutableMapOf("a" to 1)



}

fun main(){
    var arr: IntArray = intArrayOf(1,2)
//    println(ArrayAndList().map.get("1"))
//    println(ArrayAndList().map["1"])
//    var map1 = ArrayAndList().map.toMutableMap()
//    map1["1"] = 3
//    println(map1["1"])
    var arr1 = intArrayOf(1,3,2)

    //遍历数组
//    arr1.forEach { println(it) }
    //使用filter过滤元素后，下例返回的是元素值!=2的元素，最后结果返回的是一个集合了，不再是一个数组
    var list = arr1.filter { i: Int -> i!=2 }
    println(list)
//    list.forEach{println(it)}

    //对list中的每一个元素执行map方法中的指定操作，返回一个新的list
    var newList = list.map { i -> i+3 }
//    newList.forEach{ println(it)}

    var flatMapList = arr1.flatMap { i ->
        listOf("${i + 1}", "a") // 👈 生成新集合
    }

    flatMapList.forEach{ println(it)}
    val number = listOf("one", "two", "three", "four")
    val plusList = number + "five"
    val minusList = plusList-"one"
//    plusList.forEach{println(it)}
//    minusList.forEach{println(it)}
    val numbers = listOf("one", "two", "three", "four", "five")
    println(numbers.groupBy { it.first().toUpperCase() })
    println(numbers.groupBy(keySelector = { it.first() }, valueTransform = { it.toUpperCase() }))
    println(numbers.groupingBy { it.first() }.eachCount())
}