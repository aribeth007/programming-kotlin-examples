interface Worker { fun work()
    fun takeVacation()
}
open class JavaProgrammer : Worker {
    override fun work() = println("...write Java...")
    override fun takeVacation() = println("...code at the beach...")
}
open class CSharpProgrammer : Worker{
    override fun work() = println("...write C#...")
    override fun takeVacation() = println("...branch at the ranch...")
}

//by: It implements the Worker interface by way of or via the JavaProgrammer
//class Manager() : Worker by JavaProgrammer()

// in order to access methods from delegate
class Manager(val staff: Worker) : Worker by staff {
    fun meeting() =
    println("organizing meeting with ${staff.javaClass.simpleName}")
   // if we have method collisions it will take into account delegating class method(manager_
    override fun takeVacation() = println("of course")
}

fun main() {
    val doe = Manager(CSharpProgrammer())
    val roe = Manager(JavaProgrammer())
    doe.work() //...write C#...
    doe.meeting()//organizing meeting with CSharpProgrammer
    roe.work() //...write Java... roe.meeting()//organizing meeting with JavaProgrammer
//    val coder: JavaProgrammer = doe // ERROR type mismatch, but in inheritance it was possible
    // method collision, takeVacation from Manager class will be called
    doe.takeVacation()
}

