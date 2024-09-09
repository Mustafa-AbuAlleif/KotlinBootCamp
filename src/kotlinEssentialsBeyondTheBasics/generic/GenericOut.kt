package kotlinEssentialsBeyondTheBasics.generic

abstract class Car

object BMW: Car()

object Mercedes: Car()

// Here (Out T) It's Always Accept SubClass
class CarMechanic<out T: Car>{
    fun repair() {}
}

class WorkShop{
    fun addMechanic(mechanic: CarMechanic<Car>) {}
    // Common Pattern for Generic Fun
    fun <T : Car> addProMechanic(mechanic: CarMechanic<T>){}
}

fun main(){
    val mechanic = CarMechanic<BMW>()
    val workShop = WorkShop()

    workShop.addMechanic(mechanic)
    workShop.addProMechanic(mechanic)
}

interface Comparable<in T>{ fun comapreTo(other: T): Int }

fun doSomething(comparable: Comparable<Number>){
    val number: Comparable<Double> = comparable
}