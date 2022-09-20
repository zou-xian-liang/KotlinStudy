package com.zxl.study.design;

//饿汉式单例
class JavaSingleton {
    // 1、直接创建对象
    public static JavaSingleton instance = new JavaSingleton();
    // 2、私有化构造函数
    private JavaSingleton() {
    }
    // 3、返回对象实例
    public static JavaSingleton getInstance() {
        return instance ;
    }


    //懒汉式
    private static volatile JavaSingleton singleton2=null;
    public static JavaSingleton getInstance1(){
        if (singleton2==null){
            synchronized (JavaSingleton.class){
                if (singleton2==null){

                    singleton2 = new JavaSingleton();
                }
            }
        }
        return singleton2;
    }

    //静态内部类
    private static class Helper{

        private static JavaSingleton INSTANCE = new JavaSingleton();
    }
    public static JavaSingleton getInstance2(){
        return JavaSingleton.Helper.INSTANCE;
    }

}
