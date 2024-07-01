fun mapStrLength(list: List<String>): Map<String, Int> {
    val map = mutableMapOf<String, Int>()
    for (str in list) {
        map[str] = str.length
    }
    return map
}
fun main() {
    val str = listOf("Ram", "Sneha", "fun", "Laughing", "no")
    val strLength = mapStrLength(str)
    println(strLength)
}
