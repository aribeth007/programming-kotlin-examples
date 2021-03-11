package chapter6

open class Fruit
class Banana : Fruit()
class Orange: Fruit()

fun receiveFruits(fruits: Array<Fruit>) {
    println("Number of fruits: ${fruits.size}")
}

fun receiveFruits2(fruits: List<Fruit>) {
    println("Number of fruits: ${fruits.size}")
}

fun main() {
    val bananasArray: Array<Banana> = arrayOf()
    val bananasList: List<Banana> = listOf()

    //receiveFruits(bananasArray) // This makes generic type safe
    //receiveFruits2(bananasList)
}