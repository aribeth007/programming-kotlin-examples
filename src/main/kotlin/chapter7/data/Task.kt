package chapter7.data

class Test

/**
 * Specialized classes that are intended to carry mostly data rather than behavior
 *
 * Kotlin generates a copy() method that creates a new object with all the properties of the receiver object
 * copied into the result object.
 */
data class Task(val id: Int, val name: String, val completed: Boolean, val assigned: Boolean, val test: Test)

fun main() {
    val task1 = Task(1, "Create Project", false, true, Test())
    println(task1)

    val task1Completed = task1.copy(completed = true, assigned = false)
    println(task1Completed)

    println("Task1: ${task1.test} Task1Completed: ${task1Completed.test} ")

    // To destructure, we have to extract the properties in the same order as they appear in the primary constructor.
    val (id, _, _, isAssigned) = task1
    println("Id: $id Assigned: $isAssigned")

}