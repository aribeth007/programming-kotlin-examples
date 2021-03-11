package chapter6

class Animal {
    override operator fun equals(other: Any?) = other is Animal
}

class Animal2(var age:Int) {
//    override operator fun equals(other: Any?): Boolean {
//       return if (other is Animal2) age == other.age else false // Smart cast
//    }

    override operator fun equals(other: Any?) =
            other is Animal2 && age == other.age
}

//Smart cast with when

fun whatToDo(dayOfWeek: Any) = when (dayOfWeek) {
    "Saturday", "Sunday" -> "Relax"
    in listOf("Monday", "Tuesday", "Wednesday", "Thursday") -> "Work hard"
    in 2..4 -> "Work hard"
    "Friday" -> "Party"
    is String -> "What?" //After the check the we can use the properties and functions of String without any restrictions
    else -> "No clue"
}
// Explicit cast
fun fetchMessage(id: Int): Any =
        if (id == 1) "Record found" else StringBuilder("data not found")

fun main() {
    val a: Any = "test"
    val b: Any = Animal()
    val c: Any = Animal()

    print(b == a)
    print(b == c)

    val a1: Any = "test"
    val b1: Any = Animal2(2)
    val c1: Any = Animal2(3)

    print(b1 == a1)
    print(b1 == c1)

    var msg = fetchMessage(1) as String
    var msg2 = fetchMessage(3) as? String
}