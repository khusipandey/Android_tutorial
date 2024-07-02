fun main() {
    val list= listOf(1, 2, null, 4, null, 6)
    val notnullList= filterNonNulllist(list)
    println("Original list: $list")
    println("Filtered list: $notnullList")
}
fun filterNonNulllist(list: List<Int?>): List<Int> {
    return list.filterNotNull()
}
