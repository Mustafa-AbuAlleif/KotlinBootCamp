package classes.specialPurposeClasses



//  we don't make instance of this class (object)
object SpecialPurposeClasses {
    val Name = { "Mustafa Ahmed" }
}




//we do make instance of this class only in the SameFile
sealed class Seal

class SeaLion:Seal()
class Walrus: Seal()

fun matchSeal(seal: Seal): String {
    return when(seal) {
        is Walrus -> "walrus"
        is SeaLion -> "Sea Lion"
    }
}
