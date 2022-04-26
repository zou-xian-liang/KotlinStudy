package com.zxl.study.basics

class MyAnnotation constructor(){
    @JvmField
    var testField: String = ""


    companion object {
        //默认这种是不能直接在java中通过类名进行调用，可以通过使用JvmStatic注解
        @JvmStatic
        val TAG = "MyAnnotation"
    }
}