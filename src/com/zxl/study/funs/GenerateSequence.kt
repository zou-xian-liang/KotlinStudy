package com.zxl.study.funs

import com.zxl.study.basics.printlnMe

/**
 * 迭代器函数：针对某个序列，你可能会定义一个只要序列有新值产生就被调用一下的函数，这样的函数叫迭代器函数
 * generateSequence 函数接受一个初始种子值作为序列的起步值，在用generateSequence定义的序列上调用一个函数时，
 * generateSequence函数会调用你指定的迭代器函数，决定下一个要产生的值
 */

fun main() {
    val oneThousandPrimes = generateSequence(2, { value -> value + 1 }).filter { it.isPrime() }.take(1000)

    oneThousandPrimes.toList().size.printlnMe()

}