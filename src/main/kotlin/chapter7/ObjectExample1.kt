package chapter7

class ObjectExample1 {
    // Private function, so the return type is the anonymous object type
    private fun foo() = object {
        val x: String = "x"
    }

    // Public function, so the return type is Any
    fun publicFoo() = object {
        val x: String = "x"
    }

    fun bar() {
        // which one do you think it will work
        // val x1 = foo().x
        // val x2 = publicFoo().x
    }
}

fun main() {
    ObjectExample1().bar()
}