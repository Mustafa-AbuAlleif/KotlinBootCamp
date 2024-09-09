package kotlinEssentialsBeyondTheBasics.labeledBreaks

fun main() {
    labels()
}

fun labels() {
    mustafa@ for (i in 1..10) {
                for (x in 1..10) {
                    if (i > 4) break@mustafa
                    if (x > 3) break
                    println("i = $i, x = $x")
                }
    }
}

fun returnLabels(){
    listOf(1,2,3,4,5).forEach { if (it == 3) return
    println(it) // 1 2
    }
    println("this point is unreachable")
}

fun returnLabels2(){
    listOf(1,2,3,4,5).forEach mustafa@ { if (it == 3) return@mustafa
        println(it) // 1 2 4 5
    }
    println("done with explicit label")
}

fun returnLabels3(){
    listOf(1,2,3,4,5).forEach { if (it == 3) return@forEach
        println(it) // 1 2 4 5
    }
    println("done with explicit label")
}

fun returnLabels4(){
    listOf(1, 2, 3, 4, 5).forEach( fun(value: Int) { if (value == 3) return
        print(value) }) // 1 2 4 5
    print(" done with anonymous function")
}

fun foo() {
    run loop@{
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@loop // non-local return from the lambda passed to run
            print(it) // 1 2
        }
    }
    print(" done with nested loop")
}