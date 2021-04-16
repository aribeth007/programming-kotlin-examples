package chapter9

import kotlin.properties.Delegates.observable
import kotlin.properties.Delegates.vetoable

fun main() {
    // Lazy delegate
    // - useful to defer creating objects or executing computations until the result is truly needed

    fun getValueFromRemoteWebService(): Double {
        println("fetch value from webservice...")
        return 30.0
    }

    // Let's try to avoid calling the remote web service!
    // option 1: using short-circuit evaluation
    val callRemoteWebService = false
    if (callRemoteWebService && getValueFromRemoteWebService() > 20)
        println("Value > 20")
    else
        println("Nothing to report")

    // option 2: using eager evaluation
    val value = getValueFromRemoteWebService()
    if (callRemoteWebService && value > 20)
        println("Value > 20")
    else
        println("Nothing to report")

    // option 3: using lazy delegate
    val lazyValue by lazy { getValueFromRemoteWebService() }
    if (callRemoteWebService && lazyValue > 20)
        println("Value > 20")
    else
        println("Nothing to report")

    // ============================================================
    // Observable delegate
    // - useful to observe/monitor changes to the value or property

    // kotlin.properties.Delegates has observable() function
    // that will intercept a change to the property it's associated with

    var count: Int by observable(0) { property, oldValue, newValue ->
        println("Property: ${property.name} old: $oldValue: new: $newValue")
    }

    println("The value of count is: $count")
    count = 1
    println("The value of count is: $count")
    count = 2
    println("The value of count is: $count")

    // ============================================================
    // the Vetoable delegate
    // - can be used to reject changes to properties based on some rules/business logic
    // - returns a boolean result: true means accept the change, false means reject.

    var counter by vetoable(0) {
            _, oldValue, newValue -> newValue > oldValue
    }

    println("The value of counter is: $counter")
    counter = 2
    println("The value of counter is: $counter")
    counter = 1
    println("The value of counter is: $counter")

}
