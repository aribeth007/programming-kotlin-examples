package chapter7.classes

/**
 * Simplest syntax
 */
class SimpleClass

/**
 * With constructor that initializes a read only property => only getter is generated
 */
class Car(val yearOfMake: Int)

/**
 * Above is a shortcut of this
 * The keyword constructor isn’t needed unless we want to
 * change the access modifier or place an annotation for the primary constructor.
 */
public class CarLongDef public constructor(public val yearOfMake: Int)

/**
 * With read/ write param
 */
class CarReadWrite(val yearOfMake: Int, var color: String)

fun main() {
    val car = Car(2019)
    println(car.yearOfMake)
    //car.yearOfMake = 2019 //ERROR: val cannot be reassigned

    val car1 = CarReadWrite(2019, "Red")
    car1.color = "Green"
    println(car1.color) //GREEN

}