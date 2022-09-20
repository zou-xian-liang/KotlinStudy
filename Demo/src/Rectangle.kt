class Rectangle(
    var height: Double,
    var length: Double
) : Shape(listOf(height, length, height, length)), RectangleProperties {
    override val isSquare: Boolean get() = length == height
    override fun calculateArea(): Double = height * length
}
interface RectangleProperties {
    val isSquare: Boolean
}

abstract class test(){
    abstract fun fun1()
}

class child : test(){
    final override fun fun1() = Unit
}

fun main() {

}