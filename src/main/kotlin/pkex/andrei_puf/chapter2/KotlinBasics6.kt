package pkex.andrei_puf.chapter2

//When expression

fun main() {
    binaryDigit(3)
    isMinOrMax(x = 3)
}


// Classical switch case example
fun binaryDigit(x: Int) {
    when (x) {
        0 -> println("x is zero")
        1 -> println("x is 1")
        else -> println("X is neither 0 or 1") // must be here or it won't compile
    }
}

// When as an expression
fun isMinOrMax(x: Int): Boolean {
    val isZero = when (x) {
        Int.MIN_VALUE -> true
        Int.MAX_VALUE -> true
        else -> false
    }
    return isZero
}

// Constants
fun isZeroOrOne(x: Int): Boolean {
    return when (x) {
        0, 1 -> true
        else -> false
    }
}

// Functions
fun isAbs(x: Int): Boolean {
    return when (x) {
        Math.abs(x) -> true
        else -> false
    }
}

// Ranges are also supported
fun isSingleDigit(x: Int): Boolean {
    return when (x) {
        in -9..9 -> true
        else -> false
    }
}

// Also smart casts are supported
fun startsWithFoo(any: Any): Boolean {
    return when (any) {
        is String -> any.startsWith("Foo")
        else -> false
    }
}

// Also it can be used without arguments
fun whenWithoutArgs(x: Int, y: Int) {
    when {
        x < y -> println("x is less than y")
        x > y -> println("X is greater than y")
        else -> println("X must equal y")
    }
}