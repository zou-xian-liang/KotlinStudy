package com.zxl.study.design

import java.util.*

/**
 * 观察者模式
 *
 * 如博客订阅者，当 博客更新后，就会通知所有订阅者
 */
interface Observer {
    fun update()
}

class Observer1 : Observer {
    override fun update() {
        println("Observer1")
    }
}

class Observer2 : Observer {
    override fun update() {
        println("Observer2")
    }
}

interface Subject {
    fun add(observer: Observer)
    fun del(observer: Observer)
    fun notifyObservers()
    //自身操作，执行后一般会通知订阅者
    fun operation()
}

abstract class AbstractSubject : Subject {
    var vector:Vector<Observer> = Vector()
    override fun add(observer: Observer) {
        vector.add(observer)
    }
    override fun del(observer: Observer) {
        vector.remove(observer)
    }
    override fun notifyObservers() {
        val elements = vector.elements()
        while (elements.hasMoreElements()){
            elements.nextElement().update()
        }
    }
}
class MySubject : AbstractSubject(){
    override fun operation() {
        //通知观察者
        notifyObservers()
    }
}

fun main() {
    val subject = MySubject()
    subject.add(Observer1())
    subject.add(Observer2())
    subject.operation()
}

