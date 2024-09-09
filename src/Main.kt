fun main() {
    executeAction {
        println("Executing action")
        return // تعليمة "return" هنا
    }

    funLambda { println("crossinline action")
        return@funLambda "After crossinline"
    }

}




/*Return to labels is forbidden inside a lambda because a lambda cannot make the enclosing function "return"
To exit a lambda, use return labels after inlined lambda function*/
inline fun executeAction(action: () -> Unit) {
    println("Before action")
    action() // هنا يتم استدعاء اللامبدا
    println("After action")
}

/*Note that some inline functions may call the lambdas passed to them as parameters not directly from the function body,
* but from another execution context, such as a local object or a nested function.
* In such cases, non-local control flow is also not allowed in the lambdas.
* To indicate that the lambda parameter of the inline function cannot use non-local returns,
* mark the lambda parameter with the "crossinline" modifier*/
inline fun funLambda(crossinline body: () -> String) {
    println("before crossinline")

    println(object : Runnable {
        override fun run() { body() }
    })
}