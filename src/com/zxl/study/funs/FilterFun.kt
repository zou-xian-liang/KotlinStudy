package com.zxl.study.funs

import com.zxl.study.basics.printlnMe

/**
 * 过滤函数:条件筛选
 * 接受一个predicate函数，用它按给定条件检查接收者集合里的元素并给出true或false的判定
 * 如果predicate函数返回true 受检元素就会添加到过滤函数返回的新集合里
 * 如果predicate返回false，那么受检元素就会被移出新集合
 */
fun main() {
    val result = listOf(0, 1, 2, 3, 4, 5, 6)
        .filter { it % 2 == 0 }//闭包中返回true，则该元素会被添加到新集合中，这里就是取出偶数

//    result.printlnMe()

    //flatMap和filter结合

    //下面两种结果一样，一种是函数嵌套，一种是函数链式调用
    val result1 = listOf(listOf(0, 1, 2), listOf(3, 4, 5, 6))
        .flatMap { it.filter { it > 2 && it % 2 == 0 } }//1、合并集合[0,1,2,3,4,5,6];2、过滤

    val result2 = listOf(listOf(0, 1, 2), listOf(3, 4, 5, 6))
        .flatMap { it }
        .filter { it > 2 && it % 2 == 0 }

//    result1.printlnMe()
//    result2.printlnMe()

    //找素数 除了1和他本身，不能被任何人整除的数

    var num1 = 0
    val number = listOf( 5)
    //none
    val prime = number
        .filter { num ->
            (2 until num).map {//只有>=2的元素才会执行map函数，【until 含头不含尾，所以当num=2时，是不进map的，也就是1,2肯定是素数】然后用本身除以2-n的元素
                    mapValue ->
//                println("num=$num  mapValue=$mapValue   num%mapValue=${num % mapValue}")
                num % mapValue//取余
            }//获得一个除数集合，就是当前num能整除除1以外的所有除数集合，如果这个集合是空的，说明这数除了1和它本身不能被其他数整除
                .none {
                    num1++
                    true
//                    println("$it+${System.currentTimeMillis()}"); it == 0
                }//所有余数里面，没有一个是等于0 的，那就说明这个数符合要求
        }
//    prime.printlnMe()
//    num1.printlnMe()

    val map = (-1 until 5).map {//只有>=2的元素才会执行map函数，【until 含头不含尾，所以当num=2时，是不进map的，也就是1,2肯定是素数】然后用本身除以2-n的元素
//                    println("num=$num  it=$it   num%it=${num % it}")
        it//取余
    }
    map.printlnMe()
    val none1 = map.none {//没有一个数字是大于0的吗？是则返回true
        //none里面会遍历集合所有元素，然后一个个和{}中的条件进行比对，只要找到一个满足的，说明none就是false了，可以中断了，不需要继续遍历了
        print(it)
        it > 0
    }
    none1.printlnMe()

    val none = listOf(2, 3).none {
//        print(it)
        true
    }

}

/**
 * 求素数
 * @receiver Int
 * @return Boolean
 */
fun Int.isPrime():Boolean{
    (2 until this).map {
        if (this%it==0) return false
    }
    return true
}