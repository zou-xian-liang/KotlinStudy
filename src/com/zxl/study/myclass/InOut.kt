package com.zxl.study.myclass

//out协变 泛型作为输出，返回
interface Production<out T>{
    fun product():T
    //作为函数输入就会报错
    //fun consume(item:T)
}

//in逆变  泛型作为输入
interface Consumer<in T>{
    fun consume(item:T)
}

//不变,泛型既可作为输出也可作为输入，类型投影
interface ProductionConsumer<T>{
    fun product():T
    fun consume(item:T)
}
open class Food
open class FastFood:Food()
class Burger:FastFood()

//生产者
class FoodStore:Production<Food>{
    override fun product(): Food {
        println("product->Food")
        return Food()
    }
}
class FastFoodStore:Production<FastFood>{
    override fun product(): FastFood {
        println("product->FastFood")
        return FastFood()
    }
}
class BurgerStore:Production<Burger>{
    override fun product(): Burger {
        println("product->Burger")
        return Burger()
    }
}

//消费者
class EveryBody:Consumer<Food>{
    override fun consume(item: Food) {
        println("consume->Food")
    }
}
class ModernPeople:Consumer<FastFood>{
    override fun consume(item: FastFood) {
        println("consume->FastFood")
    }
}
class American:Consumer<Burger>{
    override fun consume(item: Burger) {
        println("consume->Burger")
    }
}
fun main() {
    //子类对象赋值给父类变量
    val production1:Production<Food> = FoodStore()

    //父类对象赋值给子类变量
    val consumer1:Consumer<Burger> = ModernPeople()
    //调用的实际是=右边的对象的方法
    consumer1.consume(Burger())
}