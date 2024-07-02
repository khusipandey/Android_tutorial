fun main() {
    val strings = listOf("Hello", "World", "Kotlin")
    val uppercase= transformStr(strings){it.toUpperCase()}
    println(uppercase)
    val lowercase= transformStr(strings){it.toLowerCase()}
    println(lowercase) 
}
fun transformStr(list: List<String>, transform: (String) -> String): List<String> {
    val transformedList = mutableListOf<String>()
    for (str in list) {
        transformedList.add(transform(str))
    }
    return transformedList
}
