package chapter10

fun doubleOfEvenImperative(): List<Int> {
    var doubleOfEven = mutableListOf<Int>()
    for (i in 1..10) {
        if (i % 2 == 0) {
            doubleOfEven.add(i * 2)
        }
    }

    return doubleOfEven
}

fun doubleOfEvenFunctional(): List<Int> {
    return (1..10).filter { e -> e % 2 == 0 }.map { e -> e * 2 }
}

fun main() {
    doubleOfEvenImperative()
    doubleOfEvenFunctional()
}

