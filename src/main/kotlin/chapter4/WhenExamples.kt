package chapter4

import kotlin.random.Random

fun main() {
    println(doCheck(1))
    println(doCheck(4))

    println(doCheckWithWhen(1))
    println(doCheckWithWhen(4))

    println(doComplexCheckWithWhen("bala"))
    println(doComplexCheckWithWhen("one"))
    println(doComplexCheckWithWhen(3000))
    println(doComplexCheckWithWhen("nothing"))

    println(doCheckWithWhenAsStatement(4))
    println(doCheckWithWhenAsStatementWithVariable())
}

fun doCheck(number: Int): String {
    if (number == 1) { return "one" }
    if (number == 2) { return "two" }
    if (number == 3) { return "three" }
    return number.toString()
}

/**
 * When as an expression
 */
fun doCheckWithWhen(number: Int) = when {
    number == 1 -> "one"
    number == 2 -> "two"
    number == 3 -> "three"
    else -> number.toString()
}

/**
 * When as an expression
 */
fun doComplexCheckWithWhen(something: Any) = when (something) {
    "ala", "bala" -> "portocala"
    in listOf("one", "two", "three", "four") -> "I'm a small number"
    in 1000..4000 -> "I'm a large number"
    is String -> "I do not understand"
    else -> "No clue"
}

/**
 * When as a statement
 */
fun doCheckWithWhenAsStatement(number: Int): String {
    when(number) {
        1 -> return "one"
        2 -> return "two"
        3 -> return "three"
        in 4..5 -> return "four-five"
        else -> return number.toString()
    }
}

/**
 * When as a statement
 */
fun doCheckWithWhenAsStatementWithVariable(): String {
    when(val number = (1..6).random()) {
        1 -> return "one"
        2 -> return "two"
        3 -> return "three"
        in 4..5 -> return "four-five"
        else -> return number.toString()
    }
}

