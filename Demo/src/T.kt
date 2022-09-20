class T :T1{
    var name="Li"
    var age = 12
    var sex = false
    override var isTest: Boolean =false
//        get() = true
        set(value){}

    class innerClass{
       fun test()=2
    }

    var s = T.innerClass().test()

}


interface T1{
    var isTest:Boolean
}