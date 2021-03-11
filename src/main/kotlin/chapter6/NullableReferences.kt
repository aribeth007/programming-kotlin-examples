package chapter6

fun nickName(name: String): String? {
    if (name == "William") {
        return "Bill"
    }
    return null //ERROR
}
//
//fun nickName2(name: String?): String? {
//    if (name == "William") {
//        return "Bill"
//    }
//    return name.reversed() //ERROR
//}
//
//fun nickName3(name: String?): String? {
//    if (name == "William") {
//        return "Bill"
//    }
//    return name?.reversed() //ERROR
//}
//
//fun nickName4(name: String?): String {
//    if (name == "William") {
//        return "Bill"
//    }
//    return name?.reversed()?:"Test" //ERROR
//}
//
//fun nickName5(name: String?): String {
//    if (name == "William") {
//        return "Bill"
//    }
//    return name!!.reversed()?:"Test" //ERROR NullPointerException
//}

fun main() {
    println("Nickname for William is ${nickName("William")}")
    println("Nickname for Venkat is ${nickName("Venkat")}")
    //println("Nickname for null is ${nickName(null)}") //ERROR
}