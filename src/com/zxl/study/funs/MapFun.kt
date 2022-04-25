package com.zxl.study.funs

import com.zxl.study.basics.printlnMe

/**
 * 演示变换函数
 *
 * flatMap：操作一个集合的集合，将其中多个集合中的元素合并后返回一个包含所有元素的单一集合
 */
fun main() {
    val animals = listOf("zebra", "giraffe", "elephant", "rat")
    val babies = animals
        .map { animal -> "A baby $animal" }//遍历每一个元素，然后对每一个元素执行{}中的操作，然后返回所有元素
        .map { baby -> "$baby is second map" }
//    animals.printlnMe()
//    babies.printlnMe()


    //flatMap 将多个集合元素取出来，单独组成一个新的集合，新集合含有多个集合中的额所有元素
    var result = listOf(listOf(1, 2, 3), listOf(4, 5, 6)).flatMap {
        it
    }
//    result.printlnMe()


    val map = "d:sda".filter { it!=':' }
    map.printlnMe()

}