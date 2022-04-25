package com.zxl.study.funs

import com.zxl.study.basics.printlnMe

/**
 * zip 合并函数
 * 用来合并两个集合，返回一个包含键值对的新集合
 *
 * 返回的集合数取两个集合的最小交集，如集合1有2个元素，集合2有3个元素，则最终的集合只会有2个元素
 */
fun main() {
    val list1 = listOf("1-a","1-b","1-c","1-d","1-2")
    val list2 = listOf("2-a","2-b","2-c","2-d")
    val zip = list1.zip(list2).toMap()
    zip.printlnMe()


}