package com.zxl.study.design

//饿汉式单例
class Singleton {
    companion object {
        val instance by lazy(LazyThreadSafetyMode.NONE){Singleton()}
    }
}