package chappter9.inheritance


interface Worker {
    fun work()
    fun takeVacation()
    fun fileTimeSheet() = println("Why? Really?")
}

interface Assistant {
    fun doChores()
    fun fileTimeSheet() = println("No escape from that")
}


class DepartmentAssistant : Assistant {
    override fun doChores() = println("routine stuff")
}

class Manager(val staff: Worker, val assistant: Assistant) : Worker by staff, Assistant by assistant {
    override fun takeVacation() = println("of course")

    // if we comment this method, will get compile error, due to collision of the fileTimeSheet methods in the two interfaces
    override fun fileTimeSheet() {
        print("manually forwarding this...")
        assistant.fileTimeSheet()
    }
}

open class CSharpProgrammer : Worker {
    override fun work() = println("...write C#...")
    override fun takeVacation() = println("...branch at the ranch...")
}


fun main() {
    val doe = Manager(CSharpProgrammer(), DepartmentAssistant())
    doe.work() //...write C#...
    doe.takeVacation() //of course - called from Manager, not delegated
    doe.doChores() //routine stuff delegated to Assistant interface
    doe.fileTimeSheet() // manually forwarding this...No escape from that} executed fro Manager, who manually delegated to DepAssistant
}
