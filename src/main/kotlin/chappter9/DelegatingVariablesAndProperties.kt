package chappter9.inheritance

import kotlin.properties.Delegates.observable
import kotlin.reflect.KProperty

//// String delegates to PoliteString
//fun beingpolite(content: String) = PoliteString(content)
//
//class PoliteString(var content: String) {
//
//    operator fun getValue(thisRef: Nothing?, property: KProperty<*>): String {
//        return content.replace("stupid", "s*****")
//    }
//
//    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
//        content = value
//    }
//}
//
//// intercepting calls to read and write
//fun main() {
//    //    var comment: String = "Some nice message"
//    var comment: String by beingpolite("Some nice message")
//    println(comment)
//    comment = "This is stupid"
//    println(comment)
//    println("comment is of length: ${comment.length}")
//}


/// delegating properties
//class PoliteString(val dataSource: MutableMap<String, Any>) {
//    operator fun getValue(thisRef: Any?, property: KProperty<*>) =
//        (dataSource[property.name] as? String)?.replace("stupid", "s*****") ?: ""
//
//    operator fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
//        dataSource[property.name] = value
//    }
//}
//
//class PostComment(dataSource: MutableMap<String, out Any>) {
//    val title: String by dataSource
//    var likes: Int by dataSource as MutableMap<String, Any>
//    val comment: String by PoliteString(dataSource as MutableMap<String, Any>)
//    override fun toString() = "Title: $title Likes: $likes Comment: $comment"
//}
//
//
//fun main() {
//    val data = listOf(
//        mutableMapOf(
//            "title" to "Using Delegation",
//            "likes" to 2,
//            "comment" to "Keep it simple, stupid"
//        ),
//        mutableMapOf(
//            "title" to "Using Inheritance",
//            "likes" to 1,
//            "comment" to "Prefer Delegation where possible"
//        )
//    )
//
//    val forPost1 = PostComment(data[0])
//    val forPost2 = PostComment(data[1])
//    forPost1.likes++ // this use the setValue method and updated the value in the map
//    println(forPost1)
////    When the title property of an instance of PostComment is read, Kotlin will invoke the getValue() method of the delegate dataSource by passing the property name title to it. Thus, the map will return the value for the key title, if present.
//
//    println(forPost2)
//}
//


//// Lazy
//fun getTemperature(city: String): Double {
//    println("fetch from webservice for $city")
//    return 30.0
//}
//
//fun main() {
//    val showTemperature = false
//    val city = "Boulder"
////    if (showTemperature && getTemperature(city) > 20) //(nothing here) println("Warm") getTeperature call is avoided
////    else
////        println("Nothing to report") //Nothing to report
//
//// refactoring and even if we don;t want that, the getTemperature method is called
////    val temperature = getTemperature(city) //fetch from webservice
////    if (showTemperature && temperature > 20) println("Warm")
////    else
////        println("Nothing to report") //Nothing to report
//
//    // we can use lazy delegate
//    val temperature by lazy { getTemperature(city) }
//    if (showTemperature && temperature > 20) //(nothing here) println("Warm")
//    else
//        println("Nothing to report") //Nothing to report
//
//    //if we change the value of showTemperature to true, then the execution of getTem- perature() will take place—not where temperature is defined, but where the com- parison to > 20 happens, which is after the evaluation of the expression showTemperature in the Boolean condition.
//}

//Observable Delegate
fun main() {
    var count by observable(0) { property, oldValue, newValue ->
        println("Property: $property old: $oldValue: new: $newValue")
    }
//    var count = 0
    println("The value of count is: $count")
    count = count + 1
    println("The value of count is: $count")
    count = count - 1
    println("The value of count is: $count")
}
