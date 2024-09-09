package kotlinEssentialsBeyondTheBasics.collection

fun main() {

    val allBooks = setOf("Macbeth", "Romeo and Juliet", "Hamlet", "A Midsummer Night's Dream")

    val library = mapOf("Shakespeare" to allBooks)

    println(library.any { it.value.contains("Hamlet") })

    val moreBooks = mutableMapOf<String, String>("Wilhelm Tell" to "Schiller")

    moreBooks.getOrPut("Jungle Book") { "Kipling" }

    moreBooks.getOrPut("Hamlet") { "Shakespeare" }

    moreBooks.put("Mustafa", "NoMercy2020")

    moreBooks["Mustafa Ahmed"] = "NoMercy2020_20"

    println(moreBooks)
}