package chappter9
interface Worker { fun work()
    fun takeVacation()
}
open class JavaProgrammer : Worker {
    override fun work() = println("...write Java...")
    override fun takeVacation() = println("...code at the beach...")
}
open class CSharpProgrammer : Worker {
    override fun work() = println("...write C#...")
    override fun takeVacation() = println("...branch at the ranch...")
}
fun main() {
//     try to use inheritance
    class Manager : JavaProgrammer()
    var doe = Manager()
    doe.work()
    val coder:JavaProgrammer = doe // it works

    // delegate using Java approach => Manager is not tightly coupled to JavaProgrammer class
    // Manager could delegate to any class that implements Worker.
//    javaprogrammer no longer ahs to be marked open as we are not inheriting from it
//     var doe = Manager(JavaProgrammer())
//    doe.work()

}



// Delegate with Java approach
class Manager(val worker: Worker) {
    fun work() = worker.work()
    fun takeVacation() = worker.work()
 }
