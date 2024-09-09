package kotlinEssentialsBeyondTheBasics.collection

fun main() {

    // List Collection
    println(reverseList(testList))
    println(reverseListAgain(testList))
    println(testList.reversed())

    listOf(1, 5, 3).sum() // 9

    listOf("a", "b", "cc").sumOf { it.length } // 4

    // Mutable List
    val symptoms = mutableListOf("White Spots", "Red Spots", "not eating", "bloated", "belly up")
    symptoms.add("White fungus")
    symptoms.remove("White fungus")

    symptoms.contains("Red") // false
    symptoms.contains("Red Spots") // true

    println(symptoms.subList(2, symptoms.size)) // from Index , to before Index

    // Map Collection
    val cures = mapOf("White Spots" to "Ich", "Red Spots" to "Hole disease")

    println(cures.get("White Spots"))
    println(cures["White Spots"])

    println(cures.getOrDefault("bloating", "Sorry I don't know"))

    cures.getOrElse("bloating") { println("Sorry I don't know") }

    // Mutable Map
    val inventory = mutableMapOf("fish net" to 1)
    inventory.put("tank scrubber", 3)
    //inventory["tank scrubber"] = 3
    inventory.remove("fish net")
}

val testList = listOf(11, 12, 13, 14, 15, 16, 17, 18, 19, 20)

fun reverseList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (i in list.indices) {
        result.add(list[list.size - 1 - i])
    }
    return result
}

fun reverseListAgain(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (i in list.size - 1 downTo 0) {
        result.add(list.get(i))
    }
    return result
}