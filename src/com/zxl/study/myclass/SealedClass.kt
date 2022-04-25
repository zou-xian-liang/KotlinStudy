package com.zxl.study.myclass

/**
 * 密封类
 * 密封类可以用来定以一个类似枚举类的ADT，但时可以更灵活地控制某个子类型
 * 密封类可以有若干个子类，要继承密封类，这些子类必须和它定义在同一个文件里
 */
sealed class SealedClass {
    //以下模仿当前任务驾照状态，没资格和在学此时所有人员用户状态一致，没有特殊的标记，可以直接使用object，以免过多创建对象，
    // 但是已拿证状态设计证书编号需要新创建对象
    //没资格
    object UnQualified : SealedClass()
    //在学
    object Learning : SealedClass()
    //已拿证，证件编号
    class Qualified(val licenseId: String) : SealedClass()
}

class Driver(var status:SealedClass){
    fun checkLicenseStatus():String{
        return when(status){
            is SealedClass.UnQualified->"没资格"
            is SealedClass.Learning->"正在学"
            is SealedClass.Qualified->"已拿证，证件编号:${(status as SealedClass.Qualified).licenseId}"
        }
    }
}

fun main() {
    val driver= Driver(SealedClass.Qualified("2022年4月18日"))
    println(driver.checkLicenseStatus())
}