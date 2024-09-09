package functionManipulation

import java.util.*

fun main(){
    fishExamples()
}

data class Fish (var name: String)

fun String.capitalizeLetter() = replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

fun fishExamples() {
    val fish = Fish("splashy")

    //With is an extension that doesn't work with Null data types, With returns the result of executing the lambda
    with(fish.name){ this.capitalizeLetter()}

    //myWith(fish.name, {fish.name.capitalize() })
    myWith(fish.name) { println(this.capitalizeLetter()) }

    //Run is an extension that works with all data types, Run returns the result of executing the lambda
    println( fish.run { this.name.capitalizeLetter() } )

    //Apply is an extension that works with all data types, Apply returns the object after the lambda has been applied
    println(fish.apply { this.name.capitalizeLetter() })
    val fish2 = Fish("splashy").apply { this.name = "Sharky" }

    //Also is an extension that doesn't work with Null data types, Also returns the object after the lambda has been applied
    println(fish.also { it.name.capitalizeLetter() })
    val fish3 = Fish("splashy").also { it.name = "Sharky" }

    // .let { Method log } :- it's particularly useful for chaining manipulations together
    println(fish.name.capitalizeLetter().let { it + "fish" }.length.let { it + 31 })
    //println( fish.let { it.name.capitalize() }.let { it + "fish" }.let { it.length }.let { it + 31 } )

}
// with "inline" no new object is created, and lambda body is inlined here
inline fun<T, R> myWith( name: T, block: T.() -> R){
    name.block()
}
/* A Lambda expression is an instance of a function interface, which is itself a subtype of object.
* inLine every time Function is called it will actually transform the source code to inLine
* that is, the compiler will change the code to replace the Lambda with the contents inside the Lambda
* when we apply the transform "block()" is called directly on properties.
* It's worth noting, inlining large functions does increase your code size, so it's best used for simple functions */

inline fun<T, R> myWith1(name: T, noinline block: T.() -> R){ name.block() }