 class User constructor(var sex:String="男"){

     var id:Int = 0
     var name: String=""
     constructor(id:Int, name: String=""):this("女"){
         this.id= id
         this.name = name
     }


 }