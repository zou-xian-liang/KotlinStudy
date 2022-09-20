/**
 * 主要用来学习类的构造函数
 */
class constructorTest {
    /**
     * kotlin中构造函数不像java中以类名作为函数名来定义
     * 而是直接使用constructor来申明
     */

    /**
     * java中初始化代码块直接使用大括号包裹就可以
     *
     * kotlin中需要在代码块中增加init关键字
     */
    init {
        // 初始化代码块，先于下面的构造器执行
    }
    var id: Int=0
    lateinit var name: String
    constructor(id: Int, name: String) {
        //👆 没有 public
        this.id = id
        this.name = name
    }

}