package com.zxl.study.design

/**
 * 装饰模式
 * 给一个对象动态的增加一些功能
 * 要求装饰对象和被装饰对象实现同一接口，且装饰对象持有被装饰对象的实例
 */
interface Sourceable {
    fun method()
}

class Source : Sourceable {
    override fun method() {
        System.out.println("the original method!");
    }
}

class Decorator constructor() : Sourceable {
    private lateinit var source: Sourceable

    constructor (source: Sourceable) : this() {
        this.source = source
    }

    override fun method() {

        System.out.println("before decorator!");
        source.method();
        System.out.println("after decorator!");
    }
}

fun main() {
    val sourceable :Sourceable = Source()
    //装饰对象在抽象方法中执行被装饰对象的对应方法时增加了新的功能
    val decorator = Decorator(sourceable)
    decorator.method()

}