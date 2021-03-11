package chapter7

/**
 * The Util object we created using the object declaration is a singleton. We can’t create objects of
 * Util—it’s not considered to be a class by the Kotlin compiler; it’s already an object.
 */
object Util {
    fun numberOfProcessors() = Runtime.getRuntime().availableProcessors()
}

fun main() {
    println(Util.numberOfProcessors())
}