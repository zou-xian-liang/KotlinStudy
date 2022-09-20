package com.zxl.study.design

/**
 * 建造者模式
 * 工厂类提供的是创建单个类的模式，而建造者是将各种产品集中管理
 *
 * 个人认为其实建造者模式主要是用在类有多个属性，
 * 但是部分属性可能在使用的时候用不上，可以不用传
 */
class MyBuilder {
    private var list = ArrayList<Sender>()
     fun productMailSender(count:Int){
        repeat(count){
            list.add(MailSender())
        }
    }

     fun productSmsSender(count:Int){
        repeat(count){
            list.add(SmsSender())
        }
    }
}

fun main() {
    var myBuilder = MyBuilder()
    myBuilder.productMailSender(2);
}