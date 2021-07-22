package chapter10

// Receiving lambdas as parameters

//First parameter is a lambda using the syntax (types list) - > output type
fun walk1To(action: (Int) -> Unit, n: Int) = (1..n).forEach { action(it) }

// Let's rearrange the parameters to make the code more readable

fun walk1ToMoreReadable(n: Int, action: (Int) -> Unit) = (1..n).forEach{ action(it) }

fun main() {
    // Good but not as good as it gets in kotlin
    walk1To({ i -> print("$i ")}, 6)
    println()
    // Better but still it can get messy with lambdas having multiple lines of code
    walk1ToMoreReadable(6, { i -> print(i)})
    println()
    // A bit better than previous call but since it only has one parameter it can get better
    walk1ToMoreReadable(6) {i -> print(i)}
    println()
    // The best you can write a function call passing a lambda with a sinble argument
    walk1ToMoreReadable(6) { print(it)}
    println()
    // An even simpler way to do it
    walk1ToMoreReadable(6, ::print)
    // Referencing a static method
    walk1ToMoreReadable(6, System.out::print)



}