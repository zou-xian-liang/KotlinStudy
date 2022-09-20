package com.zxl.study.design

/**
 * 策略模式
 * 定义一系列算法，并将算法封装起来，使他们可以相互替换，且算法的变化不会影响使用者
 *
 */
interface ICalculator{
    fun calculator(exp:String):Int
}

open class AbstractCalculator{
    fun split(exp: String,opt:String):Array<Int>{
        var strList: List<String> = exp.split(opt)
        val intArr:Array<Int> = Array(2) { 0 }
        intArr[0]= strList[0].toInt()
        intArr[1]= strList[1].toInt()
        return intArr
    }
}

//求两数差
class Minus : AbstractCalculator(),ICalculator{
    override fun calculator(exp: String): Int {
        val intList = split(exp,"-")
        return intList[0]-intList[1]
    }
}

class Plus : AbstractCalculator(),ICalculator{
    override fun calculator(exp: String): Int {
        val intList = split(exp,"+")
        return intList[0]+intList[1]
    }
}

fun main() {
    val str = "2+8"//+分割，需要执行加
    val iCalculator:ICalculator = Plus()
    val calculator = iCalculator.calculator(str)
    println(calculator)
}