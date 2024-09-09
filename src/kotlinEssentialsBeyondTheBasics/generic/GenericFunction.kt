package kotlinEssentialsBeyondTheBasics.generic


fun main(){
    genericExample2()
}

fun genericExample2() {
    val cleaner = TapWaterCleaner2()
    val aquarium = Aquarium2<TapWater2>(TapWater2())
    aquarium.addWater2(cleaner)

    println(aquarium.hasWaterSupplyOfType<TapWater2>())  // True
    println(aquarium.waterSupplyOfType<LakeWater2>()) // False
    println(aquarium.waterSupply.isOfType<LakeWater2>()) // False
    isWaterClean(aquarium)

}

open class WaterSupply2 (var needsProcessed: Boolean)

class TapWater2 : WaterSupply2(true){
    fun addChemicalCleaners2()  { needsProcessed = false }
}

class FishStoreWater2 : WaterSupply2(false)

class LakeWater2 : WaterSupply2(true){
    fun filter(){ needsProcessed = false }
}


interface Cleaner2<in T: WaterSupply2>{ fun clean(waterSupply: T) }

class TapWaterCleaner2: Cleaner2<TapWater2>{
    override fun clean(waterSupply: TapWater2) { waterSupply.addChemicalCleaners2() }
}


class Aquarium2<out T: WaterSupply2>(val waterSupply: T){
    fun addWater2(cleaner: Cleaner2<T>){
        if(waterSupply.needsProcessed) { cleaner.clean(waterSupply) }
        println("Adding water from $waterSupply")
    }

    inline fun <reified T: WaterSupply2> waterSupplyOfType() = waterSupply is T
}
/* Here, we're saying isWaterCleaner is a function with a generic argument T, T is constrained by water supply
 T is a type parameter to isWaterClean that is being used to specify the generic type of the aquarium*/


fun <T: WaterSupply2> isWaterClean(aquarium: Aquarium2<T>){
    println("Aquarium Water is clean ${aquarium.waterSupply.needsProcessed}")
}

/* Here, we're declaring a function hasWaterSupplyOfType that has a generic parameter R. R is bound by WaterSupply
In the body, we're going to return "true" if the water supply parameter is of type R. (Remember WaterSupply Type is T)
A reified type is a real type. we're said, declare a type parameter R but make it a real type
Kotlin does this by inlining the function to the call
A inline Anytime you call this function it will automatically be dropped in place of the call.
Once a type is a reified you can use it just like a normal type
and that's because non reified types are only available at compile time, but can't be used at runtime by your program.*/

inline fun <reified R: WaterSupply2> Aquarium2<*>.hasWaterSupplyOfType() = waterSupply is R

inline fun <reified R: WaterSupply2> WaterSupply2.isOfType() = this is R

/* Type "erasure"
 All generic types are only used at compile time by Kotlin
 at runtime, all the generic types are erased
 without keeping the generic types to runtime*/