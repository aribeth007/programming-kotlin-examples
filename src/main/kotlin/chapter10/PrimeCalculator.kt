package chapter10

// Passing lambdas as parameters

fun isPrime(n: Int) = n > 1 && (2 until n).none { i: Int -> n % i == 0 }

//If the lambdas passed to a function take only one parameter then we can omit the parameter declaration and use a special implicit name it instead.
fun isPrimeIt(n: Int) = n > 1 && (2 until n).none {n % it == 0 }

fun main() {
    println(isPrime(5901))
    println(isPrimeIt(5901))
}