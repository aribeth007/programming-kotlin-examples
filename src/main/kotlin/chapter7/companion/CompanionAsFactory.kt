package chapter7.companion

/**
 * - Provide a private constructor for the class
 *
 * - Provide one or more methods in the companion object that creates the instance and carries out
 * the desired steps on the object before returning to the caller.
 */
class CompanionAsFactory private constructor(val name: String) {
    fun println() = print("Print $name")

    companion object {
        // Don’t assume that the methods in a companion are static methods of a class.
        // When you reference a member of a companion object, the Kotlin compiler takes
        // care of routing the call to the appropriate singleton instance
        fun create(name: String): CompanionAsFactory {
            val instance = CompanionAsFactory(name)
            instance.println()
            return instance
        }
    }
}

fun main() {
    val myInstance = CompanionAsFactory.create("Alex")
    myInstance.println()
}