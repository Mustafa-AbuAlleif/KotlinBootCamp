/*
package kotlinEssentialsBeyondTheBasics.generic

fun main(){
    genericExample()
}

fun genericExample() {
    val aquarium1 = Aquarium<TapWater>(TapWater())
    aquarium1.waterSupply.addChemicalCleaners()


//  val aquarium2 = Aquarium<String>("String")
//  println(aquarium2.waterSupply)
//  val aquarium3 = Aquarium<Nothing?>(null)
//  println(aquarium2.waterSupply)



    val aquarium4 = Aquarium(LakeWater())
    aquarium4.waterSupply.filter()
    aquarium4.addWater()
}

open class WaterSupply (var needsProcessed: Boolean)

class TapWater : WaterSupply(true){
    fun addChemicalCleaners()  { needsProcessed = false }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true){
    fun filter(){ needsProcessed = false }
}

class Aquarium<T: WaterSupply>(val waterSupply: T){
    fun addWater(){
        check(!waterSupply.needsProcessed) {"Water supply needs processed"}
        println("Adding water from $waterSupply")
    }
}*/
