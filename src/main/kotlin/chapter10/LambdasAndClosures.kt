package chapter10

fun main() {
    val factor = 2
    val doubleIt = { e:Int -> e * 2 } // This is a lambda
    val factorIt = { e:Int -> e * factor} // This is a closure
}