fun main() {
    val str= listOf("age","ago","ball","big")
    println(processStr(str,'a'))
}
fun processStr(list: List<String>,ele:Char): List<String> {
    val filteredList = list.filter{ it.first()==ele}
    val upperCaseList = filteredList.map{ it.toUpperCase() }
    val sortedList = upperCaseList.sorted()
    return sortedList
}
