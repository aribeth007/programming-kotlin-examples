package chapter7.classes

/**
 * Notice no val or var on theColor
 */
class ClassWithSetter(val yearOfMake: Int, theColor: String) {
    // notice public is redundant
    public var fuelLevel = 100
    var color = theColor
        set(value) {
            if (value.isBlank()) {
                throw RuntimeException("no empty, please")
            }
            println("I'm using this")
            field = value
        }
}

fun main() {
    val myObj = ClassWithSetter(1000, "red")
    myObj.color = "blue"
}