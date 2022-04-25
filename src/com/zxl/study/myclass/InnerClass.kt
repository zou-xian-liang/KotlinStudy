package com.zxl.study.myclass

class InnerClass {

    /**
     * 嵌套类的使用场景
     * 1、如果一个类只对另一个类有用，那么就可以将其嵌入到该类中，并使这两个类保持在一起是合乎逻辑的，此时
     * 就可以使用嵌套类
     */
   class SonClass{
        fun sonFun(){
            println("sonFun")
        }
   }
}

fun main() {
    //实例化kotlin内部类只需要通过外部访问内部类进行实例化
    val sonObj = InnerClass.SonClass()
    sonObj.sonFun()

    //实例化Java内部类,需要先实例化外部类对象才可以实例化内部类
    val javaInnerClass = JavaInnerClass()
    val javaSonClass = javaInnerClass.SonClass()
}

