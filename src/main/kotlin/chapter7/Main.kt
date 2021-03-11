package chapter7

fun main() {
    // Kotlin object expressions are like JavaScript objects and Anonymous Types in C#,
    // although they’re also useful to create instances of anonymous classes, like in Java
    val simple = object {}
    // groups variables together
    val adHoc = object {
        var x: Int = 10
        var y: Int = 21
    }
    println(adHoc.x + adHoc.y)
    println(adHoc.javaClass)
    println("adHoc x: ${adHoc.x} y: ${adHoc.y}")
    println()

    // Anonymous objects can be useful as implementors of interfaces—that is, as anonymous inner classes like in Java.
    val aRunnable = createRunnable()
    aRunnable.run()
}

fun createRunnable(): Runnable {
    val runnable = object: Runnable {
        override fun run() { println("You called...") }
    }
    return runnable
}

/**
 * If the interface implemented by the anonymous inner class is a single abstract method interface
 * (what Java 8 calls a functional interface), then we can
 * directly provide the implementation without the need to specify the method name, like so:
 */
fun createRunnableFunctional(): Runnable = Runnable { println("You called...") }

/**
 * If the anonymous inner class implements more than one interface, you have to specify the type
 * the instance should represent upon return
 */
fun createRunnableClosable(): Runnable = object: Runnable, AutoCloseable {
    override fun run() { println("You called...") }
    override fun close() { println("closing...") }
}