package com.zxl.study.basics

/**
 * 扩展函数和扩展属性
 */
val String.numVowels
    //统计字符串中元音字母个数
    get() = count {
        "aeiou".contains(it)
    }

fun <T> T.printlnMe():T{
    println(this)
    return this
}

/**
 * 可空类扩展
 * 定义扩展函数用于可空类型，在可空类型上定义扩展函数，就可以直接在扩展函数体内解决可能出现的空值问题
 */
infix fun String?.printWithDefault(default:String) = println(this?:default)

fun main() {
    val numVowels = "abjdsadi".numVowels
    numVowels.printlnMe()

    val nullAbleString :String? = null
    nullAbleString.printWithDefault("123")
    //printWithDefault方法fun 前增加infix后，可以这样写
    nullAbleString printWithDefault "test"
}