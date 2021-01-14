package pkex.andrei_puf.chapter2

// Smart casts
fun main() {
    printStringLength("abecedar")
    println(isEmptyString(""))
    println(isNotStringOrEmpty(""))
}

fun printStringLength(any: Any) {
    var any_any = any
    if (any_any is String) {
        //any_any = 1
        println(any_any.length)
    }
}

fun isEmptyString(any: Any): Boolean {
    return any is String && any.length == 0
}

fun isNotStringOrEmpty(any: Any): Boolean {
    return any !is String || any.length == 0
}

/*
public void printStringLength(Object obj) {
    if (obj instanceof String) {
        String str = (String) obj
        System.out.print(str.length())
    }
}
 */