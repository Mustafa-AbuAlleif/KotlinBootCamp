package functionManipulation

 open class Number(open val number: Int){
}

interface Numbers {
     val numbers: Int
}

val objects : Number = object : Number(10), Numbers {
    override val numbers: Int
        get() = super.number
}

fun getObjects(): Numbers = object : Number(10), Numbers{
    override val numbers: Int
        get() = super.number
}

fun main(){
    println(objects.number)

    println(getObjects().numbers)
}
