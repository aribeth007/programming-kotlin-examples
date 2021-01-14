package chapter4

fun main() {
    // Ranges
    val oneToFive: IntRange = 1..5
    println(oneToFive.contains(2))
    println(oneToFive.contains(6))

    val aToE: CharRange = 'a'..'e'
    println(aToE.contains('c'))
    println(aToE.contains('g'))

    val seekHelp: ClosedRange<String> = "hell".."help"
    println(seekHelp.contains("helm"))
    println(seekHelp.contains("helq"))
    println(seekHelp.contains("halp"))

    // Iterating ranges
    for (i in 1..5) { print("$i, ") }
    println()

    for (ch in 'a'..'e') { print(ch) }
    println()

    //for (word in "hell".."help") { print("$word, ") }
    // ERROR //for-loop range must have an 'iterator()' method

    // Reverse iteration
    for (i in 5.downTo(1)) { print("$i, ") }
    println()

    for (i in 5 downTo 1) { print("$i, ") } // inflix notation removing the dot and paranthesis
    println()

    // Skipping values
    for (i in 1 until 5) { print("$i, ") }
    println()

    for (i in 1 until 10 step 3) { print("$i, ") }
    println()

    for (i in 10 downTo 0 step 3) { print("$i, ") }
    println()

    for (i in (1..9).filter { it % 3 == 0 || it % 5 == 0 }) {
        print("$i, ")
    }
    println()

    // Iterating arrays
    val array = arrayOf(1, 2, 3) // arrayOf function belongs to the kotlin package
    val array1 = kotlin.arrayOf(1, 2, 3) // arrayOf function belongs to the kotlin package
    val array2 = intArrayOf(1, 2, 3) // arrayOf function belongs to the kotlin package

    println(array.javaClass)
    println(array2.javaClass)

    for (e in array) { print("$e, ") }

    val list = listOf(1, 2, 3)
    println(list.javaClass)
    for (e in list) { print("$e, ") }
    println()
    for (index in list.indices) {
        println("Position of ${list.get(index)} is $index")
    }
    println()
    for ((index, value) in list.withIndex()) {
        println("Position of $value is $index")
    }
}