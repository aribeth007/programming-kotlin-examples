package chapter6

import java.lang.RuntimeException
import kotlin.math.sqrt

fun computeSqrt(n: Double): Double {

    // Else part returns Nothing
    // As a whole if statement returns Nothing which extends Double so the code compiles.
    if(n >= 0) {
        return sqrt(n)
    } else {
        throw RuntimeException("Not negative value allowed")
    }
}

fun main(){

}