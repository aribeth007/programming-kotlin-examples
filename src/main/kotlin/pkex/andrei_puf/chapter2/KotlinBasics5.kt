package pkex.andrei_puf.chapter2

//Explicit casts "as" operator

fun main() {
    println(length("asd"))
    println(length(1))
}

fun length(any: Any): Int {
    val string = any as String
    return string.length
}