package classes

import classes.interfaces.FishAction
import classes.interfaces.Plecostomus
import classes.interfaces.Shark
import kotlin.math.PI

fun main(){
    buildAquarium()
}
/* public fun nameFunction - Default. Everywhere
private fun nameFunction - Visible in same file
internal fun nameFunction - Visible in Module
 */
fun buildAquarium(){
    //Create a new instance of Aquarium
    val myAquarium = Aquarium()
    println("Length: ${myAquarium.length} + Width: ${myAquarium.width} + Height: ${myAquarium.height}")

    myAquarium.height = 80
    println("Height: ${myAquarium.height} cm")
    println("Volume: ${myAquarium.volume} liters")

    val smallAquarium = Aquarium(length = 20 , width = 15, height = 30)
    println("Small Aquarium: ${smallAquarium.volume} liters")


    val myAquarium2 = Aquarium(numberOffFish = 9)
    println("Small Aquarium: ${myAquarium2.volume} liters, Length: ${myAquarium2.length} + Width: ${myAquarium2.width} + Height: ${myAquarium2.height}")

    //Nested Classes
    println(myAquarium.StockFish().stockNumberOffFish())
}
/* public class nameClass -  ByDefault
private class nameClass - Visible inside class - Subclasses can't see
protected class nameClass - Visible inside class - Subclasses can see
internal class nameClass - Visible in Module
*/
open class Aquarium(var length: Int = 100, var width: Int = 20 , var height: Int = 40){

    /*var width: Int = 20
    var height: Int = 20
    var length: Int =20*/

    //var volume : () -> Int = {width * height * length / 1000}
    /*var volume : () -> Int
            get() = { width * height * length / 1000 }*/
    open var volume : Int
        //get() {return width * height * length / 1000}
        get() =  width * height * length / 1000
        protected set(value) { height = (value * 1000) / (width * length) }

    open var water = volume * 0.90

    constructor(numberOffFish: Int): this(){
        val water: Int = numberOffFish * 2000 // CM3
        val tank = water + water * 0.10
        height = (tank / (length * width)).toInt()
    }

    // A nested class (inner) can access the members of its outer class
    inner class StockFish() {
        fun stockNumberOffFish() = water / 2000
    }
}

class TowerTank(): Aquarium() {
    override var water = volume * 0.80

    override var volume : Int
    get() =  (width * height * length / 1000 * PI).toInt()
    protected set(value) { height = (value * 1000) / (width * length) }
}

// Abstract & Interface
fun makeFish(){
    val shark = Shark()
    val Plecostomus = Plecostomus()

    println("Shark: ${shark.color} \n Plecostomus: ${Plecostomus.color}")

    shark.eat()
    Plecostomus.eat()
}

fun feedFish(fish: FishAction){
    fish.eat()
}