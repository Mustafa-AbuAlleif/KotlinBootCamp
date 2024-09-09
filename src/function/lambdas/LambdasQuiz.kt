package function.lambdas
import java.util.*


fun main(){
    println(rollDice())
    println(rollDice1(12))
    gamePlay(rollDice2(12))
}

//val rollDice =  {Random().nextInt(12) + 1}
val rollDice =  {(1..12).random() + 1}

val rollDice1 =  {sides : Int -> Random().nextInt(sides) + 1}
val rollDiceWithSides =  {sides: Int -> (1..<sides).randomOrNull() ?: 0 }

val rollDice2 = {sides: Int -> if (sides == 0) 0 else Random().nextInt(sides) +1}

// Try return This Value/Method ( otherwise " ?: " ) return the alternative value after the colon
val rollDiceWithSides2: (Int) -> Int = {sides -> if (sides != 0) (1..<sides).randomOrNull() ?: 0 else 0}

val rollDice3: (Int) -> Int ={sides -> if (sides == 0) 0 else Random().nextInt(sides) + 1}

fun gamePlay(rollDice: Int) { println(rollDice3(rollDice)) }

fun gamePlayDice(function: (Int) -> Int)  { println("Dice Roll ${function(rollDice())}") }