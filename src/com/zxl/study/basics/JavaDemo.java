package com.zxl.study.basics;

public class JavaDemo {
    public static void main(String[] args) {
        //AnnotationDemoKt对应AnnotationDemoKt文件
        // 可以在该文件中使用@JvmName注解修改该文件的名称，这样在java中调用的时候就可以使用别的名称
        AnnotationDemoKt.print("测试java调用Kotlin中的顶层函数");
    }
}
