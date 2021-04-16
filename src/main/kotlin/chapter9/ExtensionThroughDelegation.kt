package chapter9

// Example design problem - simulate execution of software projects by corporate teams

interface Worker {
    fun work()
    fun takeVacation()
}

// specialised workers for each programming language
// the idea of being polyglot has not caught this company’s attention yet

//open
class JavaProgrammer : Worker {
    override fun work() = println("...write Java...")
    override fun takeVacation() = println("...code at the beach...")
}
class ReactProgrammer : Worker {
    override fun work() = println("...write ReactJs...")
    override fun takeVacation() = println("...branch at the ranch...")
}

// The company relies on the Manager to execute and deliver the project.
// The Manager, in turn, will need a programmer to get the actual work done.

//class Manager

// option 1: The Inheritance Misroute
// we need a work() to be supported by Manager!

//class Manager : JavaProgrammer()

//option 2: Delegation, the Hard Way
// let's try to use only the facilities supported by Java

//class Manager(val worker: Worker) {
//    fun work() = worker.work()
//    fun takeVacation() = worker.work()
//}

// option 3: Delegation Using Kotlin’s by
// simplest form of delegation
// implicitly delegated to JavaProgrammer implementation
// Manager instance can't access the delegate

//class Manager() : Worker by JavaProgrammer()

// option 4: Delegating to a Parameter
// delegate to any type of Worker
// able to access the delegate since it's a property of the object

//class Manager(val staff: Worker) : Worker by staff {
//    fun meeting() = println("organizing meeting with ${staff.javaClass.simpleName}")
//}

// Dealing with Method Collisions
// Kotlin resolves this conflict in favor of the delegating class

//class Manager(var staff: Worker) : Worker by staff {
//    override fun takeVacation() = println("of course")
//}

// A class may delegate to multiple interface implementors
// if there are method collisions between the interfaces,
// then the candidate class should override the conflicting methods!

// Example:
// add new method in Worker implemented within the interface
// the implementations can readily use it or override it
//interface Worker {
//    fun work()
//    fun takeVacation()
//    fun fileTimeSheet() = println("Why? Really?")
//}

//interface Assistant {
//    fun doChores()
//    fun fileTimeSheet() = println("No escape from that")
//}
//
//class DepartmentAssistant : Assistant {
//    override fun doChores() = println("routine stuff")
//}

//class Manager(val staff: Worker, val assistant: Assistant) : Worker by staff, Assistant by assistant {
//    override fun takeVacation() = println("of course")
//    override fun fileTimeSheet() {
//        print("manually forwarding this...")
//        assistant.fileTimeSheet()
//    }
//}

fun main() {

    // option 1
//    val joe = Manager()
//    joe.work() //...write Java...

    // Manager is a kind of JavaProgrammer ?! but that's wasn't the intention!
//    val coder: JavaProgrammer = joe

    // option 2
//    var joe = Manager(JavaProgrammer())
//    joe.work() //...write Java...

    // Advantages:
    // Manager is no longer tightly coupled to JavaProgrammer
    // and may delegate work to any class that implements Worker
//    joe = Manager(ReactProgrammer())
//    joe.work() //...write ReactJs...

    // Disadvantages:
    // - code is verbose
    // - violates DRY - all the routing code looks the same!
    // - violates OCP - if we were to add a new method to Worker which Manager wants to delegate to

    // option 3
    // the compiler internally creates methods within Manager and does the routing

//    val doe = Manager()
//    doe.work() //...write Java...

//    val coder: JavaProgrammer = doe //ERROR: type mismatch

    // option 4
    // can use Manager flexibly with any implementation of Worker
    // and can access the delegate

//    val joe = Manager(ReactProgrammer())
//    val bob = Manager(JavaProgrammer())
//    joe.work() //...write C#...
//    joe.meeting()//organizing meeting with CSharpProgrammer
//    bob.work() //...write Java...
//    bob.meeting()//organizing meeting with JavaProgrammer

//    val joe = Manager(JavaProgrammer())
//    // delegation to JavaProgrammer.work()
//    joe.work() //...write Java...
//    // no delegation
//    joe.takeVacation() //of course

    // delegation to multiple interfaces
//    val joe = Manager(JavaProgrammer(), DepartmentAssistant())
//    joe.work() //...write Java...
//    joe.takeVacation() //of course
//    joe.doChores() //routine stuff
//    joe.fileTimeSheet() //manually forwarding this...No escape from that

    // Note: things to be careful about when using delegation in Kotlin

    // a Manager has a JavaProgrammer, but is not a kind of JavaProgrammer
//    val coder: JavaProgrammer = joe //ERROR: type mismatch
    // the intention was for a Manager to use/delegate to a Worker,
    // but the side effect is that a Manager may be treated as a Worker
//    val employee: Worker = joe

    // Always use 'val' when delegating to a property!!!
    // Class declaration:
    // class Manager(var staff: Worker) : Worker by staff
//    val joe = Manager(JavaProgrammer())
//    println("Staff is ${joe.staff.javaClass.simpleName}")
//    joe.work()
//    println("changing staff")
//    joe.staff = ReactProgrammer()
//    println("Staff is ${joe.staff.javaClass.simpleName}")
//    // Which work method will we call?
//    joe.work()
}
