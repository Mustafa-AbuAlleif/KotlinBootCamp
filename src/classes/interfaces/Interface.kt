package classes.interfaces

import kotlin.reflect.KProperty

/*Abstract and Interface Both are classes that can't be instantiated on their own,
 which means you can't create objects of those types yet
*/
abstract class AquariumFish() {
    abstract val color: String
}

interface FishAction {
    fun eat()
}

class Shark: AquariumFish(), FishAction{
    override val color: String
        get() = "gray"

    override fun eat() = println("hunt and eat fish")
}
// Use normal Syntax interface
class Plecostomus: AquariumFish(), FishAction{
    override val color: String = "gold"

    override fun eat() {
        println("munch on algae")
    }
}

// Syntax Abstract and Interface and know Singleton pattern (object)
fun main(args: Array<String>){
    delegate()

    println(Plecostomus1().fishName)
}

fun delegate() {
    val pleco = Plecostomus()
    println("Fish has color ${pleco.color}")
    pleco.eat()
}

interface FishColor {
    val color: String
}
// Use Syntax interface delegation
class Plecostomus1(fishColor: FishColor = GoldColor): FishColor by fishColor , FishAction by FishEatFood("a lot of algae"){
    var fishName: String by Pleco()
}

// Use Singleton pattern (object)
object GoldColor : FishColor {
    override val color: String
         get() = "Gold"
}

class FishEatFood(private val food: String): FishAction {
    override fun eat() {
        println(food)
    }
}

// delegation properties
interface  FishName {
     var name: String
}

class Pleco(): FishName{
    override var name: String = "Plecostomus_ 20"

    operator fun getValue(plecostomus1: Plecostomus1, property: KProperty<*>): String {
        return name
    }

    operator fun setValue(plecostomus1: Plecostomus1, property: KProperty<*>, fishName: String) {
        println("$fishName has been assigned to '${property.name}' in $plecostomus1.")
    }



}