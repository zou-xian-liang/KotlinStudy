package com.zxl.study.design

//饿汉式单例
class Singleton {
    companion object {
        //法一：懒加载
        val instance by lazy(LazyThreadSafetyMode.NONE) { Singleton() }

        //方法二：同步锁
        private var instance1:Singleton?=null
        @Synchronized
        fun get():Singleton{
            return if (instance1 == null) Singleton()
            else instance1 as Singleton
        }

        //方法三：双重检验锁
        val instance3 by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { Singleton() }
    }
}

//静态内部类
class Config private constructor(){
    companion object{
        fun getInstance() = Helper.instance
    }
    private object Helper{
        val instance = Config()
    }
}