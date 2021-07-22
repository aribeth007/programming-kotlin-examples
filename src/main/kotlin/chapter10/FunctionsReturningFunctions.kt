package chapter10

//Example of a case where having a function returned makes sense
val words = listOf("word1", "word2", "w3")

fun predicateOfLength(length: Int): (String) -> Boolean {
    return {input:String -> input.length == length}
}
fun main() {
    println(words.find { word -> word.length == 5 })
    println(words.find { word -> word.length == 2 })

    // Finding the first words of different sizes in style

    println(words.find(predicateOfLength(5)))
    println(words.find(predicateOfLength(2)))


}