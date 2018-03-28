fun main(args:Array<String>):Unit{
    var myClass = MyCalss(1,"hello");
    println(myClass)
}

class MyCalss(id:Int=1){
    constructor(id:Int,name:String):this(id)
    {
        this.name = name
        this.fullName = "deng"+name
    }
    // var id
    // var name
    // var fullName
    public override fun toString():String{
        return "id:$id,name:$name,fullName:$fullName"
    }
}