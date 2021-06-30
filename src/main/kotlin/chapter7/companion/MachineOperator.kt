package chapter7.companion

import java.io.Serializable

abstract class MySuperClass
interface MyInterface

/**
 * If a property or a method is needed at the class level and not on a specific instance of the class,
 *
 * Companion objects are singletons defined within a class—they’re singleton companions of classes
 * companion objects may implement interfaces and may extend from base classes,
 * and thus are useful with code reuse as well.
 */
class MachineOperator(val name: String){
    fun checkin() = checkedIn++
    fun checkout() = checkedIn--
    companion object: MySuperClass(), Serializable  {
        var checkedIn = 0
        fun minimumBreak() = "15 minutes every 2 hours"
    }
}

fun main() {
    val operator = MachineOperator("Mater")
    operator.checkin()
    operator.checkin()
    operator.checkin()
    operator.checkout()

    println(MachineOperator.minimumBreak())
    println(MachineOperator.checkedIn)
}