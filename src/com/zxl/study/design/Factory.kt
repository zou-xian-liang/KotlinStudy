package com.zxl.study.design;

/**
 * 工厂设计模式
 * 一：工厂方法
 *  普通工厂：创建一个工厂类，对实现了同一接口的一些类进行实例创建
 *  多个工厂：升级版普通工厂方法，提供多个工厂方法分别创建对象
 *  静态工厂方法：将多个工厂的方法中的方法设置为静态，不需要创建实例，直接调用
 * 二：抽象工厂
 */

//-----普通工厂---
open interface Sender {
    fun Send()
}

class MailSender : Sender {
    override fun Send() {
        println("this is mail sender!")
    }
}

class SmsSender : Sender {
    override fun Send() {
        println("this is sms sender!")
    }
}

class SendFactory {
    fun produce(type: String): Sender? {
        return if ("mail" == type) {
            MailSender()
        } else if ("sms" == type) {
            SmsSender()
        } else {
            println("请输入正确的类型 !")
            null
        }
    }
}

//-----多个工厂方法------每一个对象都有自己对应的创建方法--------
class SendFactory1 {
    fun produceMail(): MailSender {
        return MailSender()
    }

    fun produceSms(): SmsSender {
        return SmsSender()
    }

}

//-----------静态工厂方法，将多个工厂方法变为静态，不需要创建对象就可调用
object SendFactory2 {
    fun produceMail(): MailSender {
        return MailSender()
    }

    fun produceSms(): SmsSender {
        return SmsSender()
    }
}


//-----------抽象工厂------------
//类的创建依赖工厂类，有新的类对象需要创建，就增加工厂类即可
open interface Provider {
    fun produce(): Sender1
}

open interface Sender1 {
    fun send()
}

class MailSender1() : Sender1 {
    override fun send() {

    }
}

class SmsSender1 : Sender1 {
    override fun send() {

    }
}

class SendSmsFactory : Provider {
    override fun produce(): SmsSender1 {
        return SmsSender1()
    }
}

class SendMailFactory : Provider {
    override fun produce(): MailSender1 {
        return MailSender1()
    }
}

fun main() {
    var sendFactory = SendFactory()
    val produce = sendFactory.produce("sms") as SmsSender

    var sendFactory1 = SendFactory1()
    val produceSms = sendFactory1.produceSms()

    //静态工厂方法
    val produceMail = SendFactory2.produceMail()

    //抽象工厂
    var sendSmsFactory = SendSmsFactory()
    val smsSender1 = sendSmsFactory.produce()

}



