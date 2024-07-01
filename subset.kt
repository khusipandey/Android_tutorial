fun main() {
    val list1 = listOf(1, 2, 3)
    val list2 = listOf(1, 2, 3, 4, 5)
    val list3 = listOf(1, 2, 6)
    println(isSubset(list1, list2))  
    println(isSubset(list3, list2))
}
fun isSubset(list1: List<Int>, list2: List<Int>): Boolean {
    if(list1.find{it !in list2}==null)
    {
        return true
    }
    else
    {
        return false
    }               
}
