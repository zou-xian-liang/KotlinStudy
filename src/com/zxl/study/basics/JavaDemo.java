package com.zxl.study.basics;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

import java.io.IOException;

public class JavaDemo {
    public static void main(String[] args) {
        //AnnotationDemoKt对应AnnotationDemoKt文件
        // 可以在该文件中使用@JvmName注解修改该文件的名称，这样在java中调用的时候就可以使用别的名称
        Annotation.print("测试java调用Kotlin中的顶层函数");
        MyAnnotation myAnnotation = new MyAnnotation();
        myAnnotation.testField = "dsd ";
        String tag = MyAnnotation.getTAG();

        //throwException 不加Throws,则无发捕获IoException，只能捕获Throwable
        //如果想捕获IoException，则kotlin中需加注解Throws
        try {
           Annotation.throwException();
        }catch (IOException ex){

        }
        //java中操作kotlin中函数类型
        //Kotlin函数类型使用FunctionN这样的名字的接口来表示，其中N代表值参数目，这样的Function接口有23个，
        // 每一个FunctionN都包含一个invoke函数，专用于调用函数类型函数
        Function1<String, Unit> function1 = Annotation.getTranslator();
        function1.invoke("test");
    }
}
