fun main() {
    val list: List<Any?> = listOf("rainy","winter",98,"world",245,null)
	val stringList = filterStr(list)
    println("Original list: $list")
    println("Filtered list: $stringList")
}
fun filterStr(list: List<Any?>): List<String> {
    val newstr= mutableListOf<String>()
    for (element in list) {
        val str = element as? String
        if (str != null) {
            newstr.add(str)
        }
    }
    return newstr
}
