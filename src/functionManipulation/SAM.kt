package functionManipulation

fun main(){
    val num = SAM { x, y -> x * y }
    println(num.int(2,5))

    itEven.accept(5)
    isEven.accept(5)
    isEvento(7)

    //Printer( { println("NoMercy2020") } ).print()
    Printer { println("NoMercy2020") }.print()

}

//Functional interfaces (SAM)
fun interface SAM {
    fun int(x:Int, y:Int): Int
}

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

val isEven = IntPredicate { it % 2 == 0 }

// Creating an instance of a class
val itEven = object : IntPredicate {
    override fun accept(i: Int): Boolean {
        return i % 2 == 0
    }
}

// Migration from an interface with constructor function to a functional interface
interface Printer {
    fun print()
}

fun Printer(block: () -> Unit): Printer = object : Printer { override fun print() = block() }

typealias aliasMap = Map<String, Int>

fun list(): aliasMap {
    val map = mapOf("String" to 0)
    return map
}

// Functional interfaces vs. type aliases
typealias predicate = (i: Int) -> Boolean

val isEvento: predicate = { it % 2 == 0 }