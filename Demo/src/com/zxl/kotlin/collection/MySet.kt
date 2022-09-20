package com.zxl.kotlin.collection
import java.util.*


fun main(){

    var treeSet = TreeSet<Person>()
    treeSet.add(Person("张三",2))
    treeSet.add(Person("李四",3))
    treeSet.forEach {
        println("it = ${it}")
    }
}

data class Person constructor(var name: String, var age: Int) : Comparable<Int> {
    override fun compareTo(other: Int): Int {
        /**
         * Set特点，不重复
         * 0-认为所有元素相等，所以最后只存了一个元素
         * 1-正数，怎么存怎么取
         * 负数-先存后取
         */
        return 1
    }
}
class MySet {
}