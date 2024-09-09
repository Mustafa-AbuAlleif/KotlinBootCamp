package classes.specialPurposeClasses

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

fun main() {
    val number1 = 13
    val number2 = 31

    for (value in EnumArithmetics.entries) {
        println("$value($number1, $number2) = ${value.apply(number1, number2)}")
    }

    val enums = EnumArithmetics.PLUS
    enums.applyAsInt(number1,number2)

    val color = Color.RED
    println("${color.name} = ${color.RGB} , ${color.number}")
}

/* enumerate items:- Enums are like (object)
 Kotlin will make exactly one red, exactly one green, and exactly one blue
 There's no way to create more than one color object.
 Each enum constant is an object. Enum constants are separated by commas.
 Example:- we create one interface is color and Three object class Inherits color
*/
enum class Color(val RGB: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF);

    val number = Color.entries
}

enum class EnumArithmetics : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };

    override fun applyAsInt(t: Int, u: Int) = apply(t, u)
}