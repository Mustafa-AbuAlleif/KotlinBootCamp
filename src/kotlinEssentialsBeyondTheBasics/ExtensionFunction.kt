package kotlinEssentialsBeyondTheBasics

fun main(){
 println("Mustafa Ahmed".hasSpaces())

 println(Shoes("black",50).isRed())

 staticExample()

 println(Shoes("black",50).isRed2)

 clothes(Jeans(50), Shoes("black",50)).myclothes
 clothes(Jeans(50), Shoes("black",50)).myclothes()
}

fun String.hasSpaces() = find { it == ' ' } != null

open class Shoes(val color: String, private val size: Int)

class Jeans(size: Int): Shoes("blue",size)

fun Shoes.isRed() = color == "Red"

//fun Shoes.isBig() = size > 50

fun Shoes.print() = println("Shoes class")
fun Jeans.print() = println("Jeans class")


/* The extension function is resolved statically, That is at compile time
 And the compiler, it just looks at the type of the variable */
fun staticExample(){

 val blueJeans = Jeans(50)
 blueJeans.print() // Jeans class

 val whiteShoes: Shoes = blueJeans
 whiteShoes.print() // Shoes class
 println(whiteShoes.color)
}

// extension properties
val Shoes.isRed2: Boolean
 get() = color == "Red"

fun propertyExample() {
 val shoes = Shoes("Red",50)
 shoes.isRed2
}

// Declaring extensions as members
class clothes(val jeans: Jeans, val shoes: Shoes){

  fun Jeans.printWithShoes() {
  println("Jeans color is ${jeans.color}  With  Shoes color is ${shoes.color}")
 }

 fun myclothes(){
  jeans.printWithShoes()
 }

 val myclothes: String
  get() = jeans.printWithShoes().toString()
}