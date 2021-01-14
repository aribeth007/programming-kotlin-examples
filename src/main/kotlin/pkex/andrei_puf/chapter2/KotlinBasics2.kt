package pkex.andrei_puf.chapter2

fun main() {
    //Control flow as expressions
    println(isZero(2))
    println(if(2==0) true else false)


    val success = try {
        true
    } catch (e:Exception) {
        false
    }

    println(success)
}

// 'Control flow' Java like
fun isZero(x:Int):Boolean {
     var isZero: Boolean
    if (x == 0)
        isZero = true
    else
        isZero = false
    return isZero;
}