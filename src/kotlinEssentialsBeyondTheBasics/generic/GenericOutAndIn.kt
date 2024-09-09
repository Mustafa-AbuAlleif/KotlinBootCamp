package kotlinEssentialsBeyondTheBasics.generic

fun main(){
    genericExample()
}

fun genericExample() {
    val cleaner = TapWaterCleaner()
    val aquarium = Aquarium<TapWater>(TapWater())
    aquarium.addWater(cleaner)

    addItemTo(aquarium)
}

open class WaterSupply (var needsProcessed: Boolean)

class TapWater : WaterSupply(true){
    fun addChemicalCleaners()  { needsProcessed = false }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true){
    fun filter(){ needsProcessed = false }
}

//(In types) can be used anytime the generic is only used as an argument to functions
// More specifically, (in types) can only be passed into an object
// (in types) can be used as parameters
interface Cleaner<in T: WaterSupply>{
    fun clean(waterSupply: T)
}

class TapWaterCleaner: Cleaner<TapWater>{
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

// Out types are type parameters that only ever occur in return values of functions or on Val properties,
// If we try to pass an out type as a parameter to a function, compiler will give us error
// Out types can only be passed out of an object or returned
// Out types can be used as return values
// There's one special time you can pass an (out type), Constructors can take (out types) as arguments but functions never can
class Aquarium<out T: WaterSupply>(val waterSupply: T){
    fun addWater(cleaner: Cleaner<T>) {
        if(waterSupply.needsProcessed) { cleaner.clean(waterSupply) }

        println("Adding water from $waterSupply")
    }
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")