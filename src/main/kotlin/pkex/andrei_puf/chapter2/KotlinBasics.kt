package pkex.andrei_puf.chapter2

fun main() {
    //Vals and vars

    // val declares a mutable variable
    val name = "kotlin"

    // var declares a read-only variable (can be mutable) but it cannot be reassigned
    var name2: String
    name2 = "kotlin"

    //Type inference

    val string = "kotlin" // Type inferred from the rexpression
    val string2: String = "kotlin" // Explicit type

    //Basic types

    // Numbers
    //=========
    //Long 64 bits
    //Int 32 bits
    //Short 16 bits
    //Byte 8 bits
    //Double 64 bits
    //Float 32 bits

    val int = 123
    val long = 123456L
    val double = 12.34
    val float = 12.34F
    val hexadecimal = 0xAB
    val binary = 0b01010101

    val longFromInt: Long = int.toLong()

    // The full set of functions for conversions between types is toByte(), toShort(), toInt(),
    //toLong(), toFloat(), toDouble(), toChar().

    //Bitwise opperators
    //The usual bitwise operators – left shift, right shift, unsigned right shift, logical and, logical
    //or and exclusive logical or – are supported by Kotlin.

    val leftShift = 1 shl 2
    val rightShift = 1 shr 2
    val unsignedRightShift = 1 ushr 2
    val and = 1 and 0x00001111
    val or = 1 or 0x00001111
    val xor = 1 xor 0x00001111
    val inv = 1.inv()

    //Booleans
    //Booleans are rather standard, and support the usual negation, conjunction, and disjunction
    //operations.

    val x = 1
    val y = 2
    val z = 2
    val isTrue = x < y && x < z
    val alsoTrue = x == y || y == z

    //Chars
    //Represents a single character
    val char: Char = 'a'
    // Note: char type is not treated as a number as in java

    //Strings
    /**
     * Notes:
     * Strings are immutable
     * String literals can be created using double or triple quotes
     */

    val escapedString = "Escaped \n String"
    val rawString =  """Unsecaped 
    String """

    println(escapedString)
    println(rawString)

    //Arrays
    val array = arrayOf(1,2,3,4,5)

    val perfectSquares = Array(10, { k -> k * k })
    println(perfectSquares[2])

    //Packages
    //Imports
    //Wildcard imports
    //Import renaming

    // import com.packt.otherproject.Foo as Foo2

    //String templates

    val yy: Int =2
    val s= "This is yy: $yy. YY squared is: ${yy * yy}"

    //Ranges
    // Can be declared for with any type that is comparable
    val aToz = "a".."z"
    val digits = 0..9

    // in operator

    val found = 8 in digits

    // rangeTo(), downTo()

    val countingDown = 100.downTo(0)
    val rangeTo = 10.rangeTo(20)

    // step()
    val oddNumbers = rangeTo.step(2)

    // reversed()
    val reversedOddNumbers = oddNumbers.reversed()

    //Loops

    while(true) {
        println("Endless")
    }

    for(i in listOf(1,2,3,4,5)) {
        println(i)
    }

    // Exceptions
    /**
     * Handling exception is almost identical with the java ones. Except the fact that all of them are unchecked.
     */

    //Instantiating classes

    val ss = String("abc".toByteArray())

    // Referential equality and structural equality
    val a:String = "a"
    val b:String = "a"
    println(a === b)
    println(a == b)

    //Visibility modifiers

    // public - the default one accessible to all 
    // private - accessible only from the same file
    // protected - accessible only from the same class or subclasses
    // internal - accesible only from the same module


}