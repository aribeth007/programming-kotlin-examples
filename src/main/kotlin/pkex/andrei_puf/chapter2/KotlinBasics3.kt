package pkex.andrei_puf.chapter2

fun main() {
    //Nullable types
    var str: String? = null
    //var str2:String = null

}
// Any is the Object from java

fun isString(any:Any):Boolean {
    return any is String // is is similat with instanceOf
}