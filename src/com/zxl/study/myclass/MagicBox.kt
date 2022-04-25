package com.zxl.study.myclass

open class Human(val age:Int)
class Boy(val name:String,age:Int):Human(age){
    override fun toString(): String {
        return "Boy(name='$name' age=$age)"
    }
}
class Man(val name: String, age: Int) : Human(age) {
    override fun toString(): String {
        return "Man(name='$name' age=$age)"
    }
}

class MagicBox<T : Human> {
    //随机产生一个对象，如果不是指定类型，则返回backup方法生成的对象
    /*fun <T> randomOrBackup(backup:()->T):T{
        val items: List<Human> = listOf(
            Boy("Jack", 12),
            Man("Jack", 32)
        )
        val random = items.shuffled().first()
        //直接采用这种写法，is这里会报错
        return if (random is T) random else backup()
    }*/
    inline fun <reified T> randomOrBackup(backup:()->T):T{
        val items: List<Human> = listOf(
            Boy("Jack", 12),
            Man("Jack", 32)
        )
        val random = items.shuffled().first()
        //直接采用这种写法，is这里会报错
        return if (random is T) random else backup()
    }
}

fun main() {
    val box1: MagicBox<Human> = MagicBox()
    //传入的是man对象，如果方法随机产生的是man对象，则返回随机产生的对象，否则直接返回方法传入的对象
    val randomOrBackup = box1.randomOrBackup {
        Man("张三", 36)
    }
    println(randomOrBackup)
}