package pkex.andrei_puf.chapter2

//Function return

fun main() {

}

// Classical return
fun addTwoNumbers(a: Int, b: Int): Int {
    return a + b
}

// Nested function behaviour
fun largestNumber(a: Int, b: Int, c: Int): Int {
    fun largest(a: Int, b: Int): Int {
        if (a > b) return a
        else return b // returns stops only this function
    }
    return largest(largest(a, b), largest(b, c))
}

// Nested anonymous function
fun printLessThanTwo() {
    val list = listOf(1, 2, 3, 4)
    list.forEach(fun(x) {
        if (x < 2) println(x)
        else return
    })
    println("This line will still execute")
}

// Return from closure
fun printUntilStop() {
    val list = listOf("a", "b", "stop", "c")
    list.forEach stop@ {
        if (it == "stop") return@stop
        else println(it)
    }
}
// Return from closure without label
fun printUntilStop2() {
    val list = listOf("a", "b", "stop", "c")
    list.forEach {
        if (it == "stop") return@forEach
        else println(it)
    }
}