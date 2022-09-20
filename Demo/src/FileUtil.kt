/**
 * top-level property：顶层声明
 *
 * 将属性和方法不写在类中，而直接写在文件中，然后供整个包下的类直接使用，创建的时候直接创建file即可
 *
 * 这种属性和方法不属于单个类，而是属于所有该包下的所有类共享
 */
val share = "供包下所有类直接使用"

fun forAll():String{
    return "供包下所有类调用的方法"
}