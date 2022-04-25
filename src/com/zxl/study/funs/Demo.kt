package com.zxl.study.funs

import com.zxl.study.basics.printlnMe

fun main() {
    //假定需要产生1000个素数，但是我们不知道要产生1000个素数需要从1到多少，此时直接取值进行测试显然不够科学
    //实际0-5000只有670个素数
    val toList = (1..5000).toList().filter { it.isPrime() }.take(1000)
    //升级版 直接产生一个序列，然后只要最终需要的素数没有满足个数要求就直接继续取数
    val oneThousandPrimes = generateSequence(2, { value -> value + 1 }).filter { it.isPrime() }.take(1000)

    oneThousandPrimes.toList().size.printlnMe()
    //到7919才可以产生1000个素数
    oneThousandPrimes.toList().last().printlnMe()


    val jhava = Jhava()
    //String! 平台类型，java和kotlin相互操作，但是java中返回的数据是否为null无法确定，所以有String!进行标识
    val test = Jhava().nullString()

    // int 而不是Int 这属于类型映射，代码运行时，所有的映射类型都会重新映射回对应的Java类型
    // 属性访问：不需要调用相关setter方法，可以直接使用赋值语法来设置Java字段的值
    jhava.hitPoints.javaClass.printlnMe()

}


