package function

import java.util.*

fun main(args: Array<String>) {
    //mainArguments()

    feedTheFish()


}

// Main Arguments 4 & Second Quiz
/*fun mainArguments() {
    val isUnit = println("This is an expression")
    println(isUnit)

    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)

    val message = "You are ${if (temperature > 50) "fried" else "safe"} fish"
    println(message)
}*/

// Random Food Fish in the Day & Third Quiz
fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")

    shouldChangeWater(day, 20,50)
    shouldChangeWater(day = "Monday", temperature = 22, dirty = 30)
    shouldChangeWater(day, temperature = 22)

    if (shouldChangeWater(day)) println("Change the water today")
}

fun randomDay(): String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}
// Four Quiz Continue Third Quiz
fun fishFood(day : String) : String {
    return when (day){
        "Monday" -> "flakes"
        "Wednesday" -> "redWorms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}
// Default value of Argument
fun shouldChangeWater(day: String , temperature: Int = 22 , dirty: Int = 20): Boolean {

    //return day == "Wednesday" || temperature != 22 || dirty != 20

    val isTooHot = temperature > 30
    val isDirty = dirty > 30
    val isWednesday = day == "Wednesday"

    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isWednesday(day) -> true
        else -> false
    }
}
fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isWednesday(day: String) = day == "Wednesday"