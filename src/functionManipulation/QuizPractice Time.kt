package functionManipulation

enum class Directions {
    NORTH, SOUTH, EAST, WEST, START, END
}

class Game {
    var path = mutableListOf(Directions.START)

    val north = {path.add(Directions.NORTH)}
    val south = {path.add(Directions.SOUTH)}
    val east = {path.add(Directions.EAST)}
    val west = {path.add(Directions.WEST)}

    val end = {
        path.add(Directions.END)
        println("Game Over: $path")
        path.clear()
        false
    }
}

fun main(){
    val game = Game()

    println(game.path)
    game.north
    game.south
    game.east
    game.west
    game.end
    println(game.path)

    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)

    val result = numbers.divisibleBy { it.rem(3) == 0 }
    println(result)
}

typealias Predicate<T> = (T) -> Boolean

inline fun <reified T> List<T>.divisibleBy(predicate: Predicate<T>): List<T> = this.filter(predicate)

inline val <reified T> List<T>.divisibleBy: (predicate: Predicate<T>) -> List<T> get() = { predicate -> this.filter(predicate) }