package classes.constructorAndInheritance

fun main() {
    println("${spice.heat}")
    //println(spicelist)
    println(makeSalt().heat)

    spicelist.forEach {
        println("${ it.name} ${it.spiciness} - ${ it.heat }")
    }
}

class Spice(val name: String, val spiciness: String = "mild") {

    val heat: Int
        get() {
            return when (spiciness) {
                "mild" -> 1
                "medium" -> 3
                "spicy" -> 5
                "very spicy" -> 7
                "extremely spicy" -> 10
                else -> 0
            }
        }
    //init { println("Name. $name, Spiciness: $spiciness, Heat: $heat") }
}

val spices = listOf<Spice>(
    Spice("curry", "mild"),
    Spice("pepper", "medium"),
    Spice("cayenne", "spicy"),
    Spice("ginger", "mild"),
    Spice("red curry", "medium"),
    Spice("green curry", "mild"),
    Spice("hot pepper", "extremely spicy")
)

val spice = Spice("cayenne", spiciness = "spicy")

val spicelist = spices.filter {it.heat < 5}

fun makeSalt() = Spice("Salt")

    /*val name = spices[index].name
    private val spiciness = spices[index].spiciness
    val heat: Map<String, Int> get() = mapOf("mild" to 10, "spicy" to 20)
    init { println("Spice Created - Name: $name, Spiciness: $spiciness, Heat Level: ${heat[spiciness]}") }*/

open class Book(val title: String, val author: String){
    private var currentPage = 0
    open fun readPage(){currentPage++}
}
class eBook(title: String, author: String, var format: String = "text"): Book(title, author){
    private var wordCount = 0
    override fun readPage() {
        wordCount += 250
    }
}