package chapter6

abstract class Book(val name: String)
class Fiction(name: String) : Book(name) class NonFiction(name: String) : Book(name)

fun <T> findFirst(books: List<Book>, ofClass: Class<T>): T {
    val selected = books.filter { book -> ofClass.isInstance(book) }
    if(selected.isEmpty()) {
        throw RuntimeException("Not found")
    }
    return ofClass.cast(selected[0]) }

inline fun <reified T> findFirst(books: List<Book>): T { val selected = books.filter { book -> book is T }
    if(selected.size == 0) {
        throw RuntimeException("Not found")
    }
    return selected[0] as T }

fun main() {
    val books: List<Book> = listOf(Fiction("Moby Dick"), NonFiction("Learn to Code"), Fiction("LOTR"))

    // Since the parameteric type T will be erased when the code is compiled to bytecode, we can’t use T within the function to perform operations
    // That means we have to use a work around and pass a second parameter that is not relevant for the problem we are trying to solve. (ofClass: Class<T>)
    println(findFirst(books, NonFiction::class.java).name)

    //We marked the parametric type T as reified and removed the Class<T> parameter. Within the function we use T to perform type checking and for casting.
    // Since the function is marked as inline—we can use reified only for inline functions—the body of the function will be expanded at the site of a function call.
    // Thus, the type T will be replaced in the expanded code with the actual type that is known at compile time.
    println(findFirst<NonFiction>(books).name)
}
