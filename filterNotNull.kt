fun main() {
    val list= listOf(2,5,6,null,4,null,36,null,89)
    val notnullList= filterNonNulllist(list)
    println("Original list: $list")
    println("Filtered list: $notnullList")
}
fun filterNonNulllist(list: List<Int?>): List<Int> {
    return list.filterNotNull()
}
