package kotlinEssentialsBeyondTheBasics

fun main() {

    val fishnet = "fishnet" to "catching fish"

    val (tool, use) = fishnet

    println("The $tool is a tool for $use.")

    println("This is Pair $fishnet and this list ${fishnet.toList()}")

    val mixedList: List<Any> = Triple(1, "a", 0.5).toList()
    println(mixedList) // [1, a, 0.5]
    println("mixedList[0] is Int is ${mixedList[0] is Int}")
    println("mixedList[1] is String is ${mixedList[1] is String}")
    println("mixedList[2] is Double is ${mixedList[2] is Double}")

    val book = Book("Romeon and Juliet", "William Shakespeare", 1597)
    val bookTitleAuthor = book.getTitleAuthor()
    val bookTitleAuthorYear = book.getTitleAuthorYear()

    println("Here is your book ${bookTitleAuthor.first} by ${bookTitleAuthor.second}")

    println("Here is your book ${bookTitleAuthorYear.first} by ${bookTitleAuthorYear.second} written in ${bookTitleAuthorYear.third}")

}

val equipment =
    "fishnet" to "catching" to "of big size" to "and strong" // ((("fishnet" , "catching" ), "of big size" ), "and strong")

val equip =
    ("fishnet" to "catching") to ("of big size" to "and strong") // ("fishnet" , "catching") , ("of big size" , "and strong")

fun giveMeATool(): Pair<Pair<String, String>, Int> {
    return "fishnet" to "catching" to 7
}

fun gimmeATool() = (("fishnet" to "catching") to 7) // Lambada Pair

fun giveMeTool(): Triple<String, String, Int> {
    return Triple("fishnet", "catching", 7)
}

fun gimmeTool() = Triple("fishnet", "catching", 7) // Lambada Triple

class Book(private val title: String, private val author: String, private val year: Int) {

    fun getTitleAuthor() = (title to author)

    fun getTitleAuthorYear() = Triple(title, author, year)
}
