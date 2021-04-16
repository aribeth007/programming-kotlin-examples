package chapter9

import kotlin.reflect.KProperty

// Delegating variables:
// Delegate for filtering out offensive words
class PoliteString1(var content: String) {

    operator fun getValue(thisRef: Any?, property: KProperty<*>) =
            content.replace("stupid", "s*****")

//    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
    operator fun setValue(thisRef: Nothing?, property: KProperty<*>, value: String) {
        content = value
    }
}

// Delegating properties:
class PoliteString2(val dataSource: MutableMap<String, Any>) {

    operator fun getValue(thisRef: Any?, property: KProperty<*>) =
        (dataSource[property.name] as? String)?.replace("stupid", "s*****") ?: ""

    operator fun setValue(thisRef: Nothing?, property: KProperty<*>, value: String) {
        dataSource[property.name] = value
    }
}

class PostComment(dataSource: MutableMap<String, Any>) {
    val title: String by dataSource
    var likes: Int by dataSource
    val comment: String by PoliteString2(dataSource)

    override fun toString() = "Title: $title Likes: $likes Comment: $comment"
}

fun main() {

    // Delegating variables:

    var comment: String = "Some nice message"
    println(comment)
    comment = "This is stupid"
    println(comment)
    println("comment is of length: ${comment.length}")

    // passing an instance of PoliteString as the delegate
    var comment2: String by PoliteString1("Some nice message")
    println(comment2)
    comment2 = "This is stupid"
    println(comment2)
    println("comment is of length: ${comment2.length}")
    // or
    // using a function that return a delegate instance
    fun beingpolite(content: String) = PoliteString1(content)
    var comment3: String by beingpolite("Some nice message")
    println(comment3)
    comment3 = "This is stupid"
    println(comment3)
    println("comment is of length: ${comment3.length}")

    // Delegating properties:

    // instances of PostComment act as a facade for the mutable maps
    // - they delegate ANY access to their properties to their datasource
    val forPost1 = PostComment(
        mutableMapOf(
            "title" to "Using Delegation",
            "likes" to 2,
            "comment" to "Keep it simple, stupid"
        )
    )
    val forPost2 = PostComment(
        mutableMapOf(
            "title" to "Using Inheritance",
            "likes" to 1,
            "comment" to "Prefer Delegation where possible"
        )
    )
    forPost1.likes++
    println(forPost1)
    println(forPost2)

}
