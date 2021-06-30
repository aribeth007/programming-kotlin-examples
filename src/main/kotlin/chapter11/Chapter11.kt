package chapter11

fun main() {
    // external vs internal iterator by example
    val numbers = listOf(10, 12, 15, 17, 18, 19)

    // external
    for (i in numbers) {
        if (i % 2 == 0) {
            print("$i ")
        }
    }
    println()

    // internal
    numbers.filter { element -> element % 2 == 0 }.forEach { element -> print("$element ") }
    println()

    // external
    val doubled = mutableListOf<Int>()
    for (i in numbers) {
        if (i % 2 == 0) {
            doubled.add(i * 2)
        }
    }
    println(doubled)

    // internal
    // map function transforms the collection into a result collection, it applies the lambda
    // functional pipeline: a collection of functions that will be applied to values that flow through the pipeline
    val doubledEven = numbers.filter { e -> e % 2 == 0 } .map { e -> e * 2 }
    println(doubledEven)

    // filter, map, reduce: fundamental functions
    // filter: picks certain values based on condition
    // map: transforms the values
    // reduce: performs a cumulative operation on the elements
    val people = listOf(
        Person("Sara", 12),
        Person("Jill", 51),
        Person("Paula", 23),
        Person("Paul", 25),
        Person("Mani", 12),
        Person("Jack", 70),
        Person("Sue", 10))
    val result = people.filter { person -> person.age > 20 }
        .map { person -> person.firstName }
        .map { name -> name.toUpperCase() }
        .reduce { names, name -> "$names, $name" } // first param: the accumulated value, second param is an element from the original collection
    println(result)



}

data class Person(val firstName: String, val age: Int)