package chapter5

fun main() {

    // Any Java collection can be used with Kotlin.

    // + Kotlin offers a few interfaces over Java collections
    //   which offer a pleasant & safer coding experience :)
    //   through convenience methods and views
    // Examples:

    // Pair   - collection/tuple of 2 values
    println(Pair("Tom", "Jerry")) //(Tom, Jerry)

    // to() can be used to create Pairs of entries for a Map
    println(mapOf("Tom" to "Cat", "Jerry" to "Mouse")) //{Tom=Cat, Jerry=Mouse}

    // using Pair<String,Long>
    val airportCodes = listOf("CLJ", "BUC", "LTN", "LHR")
    val temperatures = airportCodes.map { code -> code to getTemperatureAtAirport(code) }
    for (temp in temperatures) {
        println("Airport: ${temp.first}: Temperature: ${temp.second} C")
    }

    // Triple - collection/tuple of 3 values
    val circle = Triple(0,5, 2.5) //(0,5,2.5)
    println("Circle x: ${circle.first}; y: ${circle.second}; radius: ${circle.third}")

    // Array of Objects and Primitives
    val friends = arrayOf("Tom", "Jerry", "Spyke", "Tyke")
    println(friends.javaClass) //class [Ljava.lang.String;
    println("${friends[0]} and ${friends[1]}") //Tom and Jerry

    val numbers = arrayOf(1, 2, 3)
    println(numbers.javaClass) //class [Ljava.lang.Integer;
    println(numbers.size) //3
    println(numbers.average()) //2.0
    println(numbers.reversed()) //[3, 2, 1]

    // other useful functions
    val array = intArrayOf(5,10,15,20,25,30,35, 40, 45, 50) // using primitive types => less overhead
    println("First element in array: " + array.first()) //5
    println("Last element of array: " + array.last()) //50
    println("Array before drop: " + array.toList()) //[5, 10, 15, 20, 25, 30, 35, 40, 45, 50]
    println("After drop with 3 value: " + array.drop(3)) //[20, 25, 30, 35, 40, 45, 50]
    println("After dropLast with 3 value: " + array.dropLast(3)) //[5, 10, 15, 20, 25, 30, 35]

    // compute values when creating an array
    println(Array(5) { i -> (i + 1) * (i + 1) }.sum()) //55
    val computedArray = Array(5) { i -> (i + 1) * (i + 1) }
    println(computedArray.toList()) //[1, 4, 9, 16, 25]

    // List
    // withIndex() allows to get both the index and value at iteration
    val fruits = listOf("Apple", "Banana", "Grape")
//    println(names.javaClass)
    for ((index, value) in fruits.withIndex()) {
        println("$index $value")
    }

    println(fruits) //[Apple, Banana, Grape]
    println("first's ${fruits[0]}, that's ${fruits.get(0)}")

    println(fruits.contains("Apple")) //true
    println("Apple" in fruits) //true

    // + Kotlin provides both mutable and immutable flavors of collections
    // Examples:

    // Immutable/Read-only view
    val immutableFruits = listOf("Apple", "Banana", "Grape")
    // any attempt to write using an immutable ref will fail at compile time
//    immutableFruits.add("Orange") //ERROR: unresolved reference: add

    val immutableFruits2 = immutableFruits + "Orange"
    println(immutableFruits) //[Apple, Banana, Grape]
    println(immutableFruits2) //[Apple, Banana, Grape, Orange]

    val noBanana = immutableFruits - "Banana"
    println(noBanana) //[Apple, Grape]

    //Mutable view
    var mutableFruits = mutableListOf("Apple", "Banana", "Grape")
    println(mutableFruits) //[Apple, Banana, Grape]
    mutableFruits.add("Orange")
    println(mutableFruits) //[Apple, Banana, Grape, Orange]

    // Set
    val fruitSet: Set<String> = setOf("Apple", "Banana", "Apple")
    println(fruitSet) //[Apple, Banana]

    // Map
    val sites = mapOf(
        "pragprog" to "https://www.pragprog.com",
        "agiledeveloper" to "https://agiledeveloper.com"
    )
    println(sites.size) //2

    println(sites.containsKey("agiledeveloper")) //true
    println(sites.containsValue("http://www.example.com")) //false
    println(sites.contains("agiledeveloper")) //true
    println("agiledeveloper" in sites) //true

    // fetching a value from a Map by key
    // - the key is not guaranteed to exist -> below won't work:
//    val pragProgSite: String = sites.get("pragprog") //ERROR
    // - get() returns a nullable type:
    val pragProgSite: String? = sites.get("pragprog")
    val pragProgSite2: String? = sites["pragprog"]
    // avoid the nullable reference by providing an alternative, default value:
    val agiledeveloper =
        sites.getOrDefault("agiledeveloper", "http://www.example.com")
    println(agiledeveloper)

    val sitesWithExample = sites + ("example" to "http://www.example.com")
    println(sitesWithExample)

    val withoutAgileDeveloper = sites - "agiledeveloper"
    println(withoutAgileDeveloper)

    // standard Map iteration
    for (entry in sitesWithExample) {
        println("${entry.key} --- ${entry.value}")
    }
    //simpler
    for ((key, value) in sitesWithExample) {
        println("$key --- $value")
    }
}

fun getTemperatureAtAirport(code: String): Long = Math.round(Math.random() * 30) + code.count()