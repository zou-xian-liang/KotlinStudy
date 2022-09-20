package com.zxl.study.design

/**
 * 适配器设计模式
 * 1、类的适配器
 * 2、对象的适配器模式
 * 3、接口的适配器模式
 */

/**
 * 类的适配器，如充电器adapter，220V是src，5v充电是dst
 * https://www.cnblogs.com/lifegoeson/p/13500465.html
 */
open class Src220v() {
    fun Src220v(){}
    fun output220v() :Int{
        println("this is original method!")
        return 220
    }
}

interface Dest5v {
   fun output5v():Int
}

class Adapter : Src220v(), Dest5v {
    override fun output5v(): Int {
        println("this is the targetable method!")
        //获得标准电压
        val src = output220v();
        //转成目标电压
        return src / 44
    }
}
class Phone{
    fun chongDina(dest5v:Dest5v){
        if (dest5v.output5v()==5) println("电压5v")
    }
}


/**
 * 对象适配器
 */

class Adapter1 constructor() :Dest5v{
    lateinit var src220v: Src220v
     constructor(src220v: Src220v):this(){
        this.src220v =src220v
    }
    override fun output5v(): Int {
        var dest=0
        val src = src220v.output220v()
        dest = src / 44
        return dest
    }
}

/**
 * 接口适配器
 * 接口中含有很多不需要的方法，可以用一个抽象类实现接口，然后需要的类直接实现中间的抽象类
 */

abstract class AdapterDest5v :Dest5v{
    override fun output5v(): Int {
        return 0
    }
}

class Adapter2 constructor() :AdapterDest5v(){
    lateinit var src220v: Src220v
    constructor(src220v: Src220v):this(){
        this.src220v =src220v
    }
    override fun output5v(): Int {
        var dest=0
        val src = src220v.output220v()
        dest = src / 44
        return dest
    }
}


fun main() {
    //类的适配器模式
    val  phone = Phone()
    phone.chongDina(Adapter())

    //对象适配器
    phone.chongDina(Adapter1(Src220v()))

    //接口适配器
    phone.chongDina(Adapter2(Src220v()))
}


