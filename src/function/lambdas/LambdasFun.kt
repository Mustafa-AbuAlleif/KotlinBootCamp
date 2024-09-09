package function.lambdas

fun main (){
    run { println("Hello World") }

    val swim = { print("swim \n") }
    swim()

    println(waterFilter(numDirty))

}

var numDirty = 20

//Lambda Syntax: dirty is Argument & after (->) it's fun body
val Filter = {dirty: Int -> dirty / 2}

//Lambda Syntax: (Int) before (->) it's Type of Argument and
//After (->) it's Type of return value from Lambda function and
//dirty is an Argument name
//Long Line Lambda: val waterFilter1: (Int) -> Int = {dirty : Int -> dirty / 2}
val waterFilter: (Int) -> Int = {dirty -> dirty / 2}

fun feedFish(dirty: Int) = dirty + 10

//Here we use a Lambda Function as an Argument,
//Note Kotlin prefer function argument to be the last parameter
inline fun updateDirty(dirty: Int, operation: (Int) -> Int): Int{
    return operation(dirty)
}

fun dirtyProcessor(){
    numDirty = updateDirty(numDirty , waterFilter)
    //Because feedFish it's NamedFunction we used (::)
    //for tell kotlin we're not trying to call feedFish & it let we parse a reference
    numDirty = updateDirty(numDirty, ::feedFish)
    //Long Line Lambda: numDirty = updateDirty(numDirty, {dirty -> dirty +50})
    numDirty = updateDirty(numDirty) { dirty -> dirty + 50 }
}