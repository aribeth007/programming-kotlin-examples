package chapter10

val Words = listOf("word1", "word2", "w3")

fun main() {
    //Store lambda as a variable
    val checkLength5 = { name: String -> name.length == 5 }

    println(Words.find(checkLength5))

    // Send an anonymous function as an argument in a function call
    Words.find(fun (word: String):Boolean {return word.length == 5})
}