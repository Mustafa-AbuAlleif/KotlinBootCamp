package classes

fun main(){
    val ages = GetterAndSetter(25)
    ages.age = 26
    println("First -> ${ages.age}")


}

class GetterAndSetter(val get: Int) {
    var age: Int = 25
         get() {
            println("Getter is Applied")
            return  field
        }
        set(value) {
            println("Setter is Applied")
            field = value - get
        }

    inline var name: String
        get() = get.toString()
        set(value) { value + "Amer"}


     var amer: (Int) -> Int
        get() = { get }

        set(value) {value}
}