fun main() {
    val testStrings = arrayOf("SUMMER",null)
	for (str in testStrings) {
        printUpperCase(str)
    }
}
fun printUpperCase(str: String?) {
    str?.let {
        println(it.uppercase())
    } ?: println("String is null")
}
