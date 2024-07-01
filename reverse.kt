fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val reverseNumbers = reverseList(numbers)
    println(reverseNumbers)  
}
fun reverseList(list: List<Int>): List<Int> 
{
    var resultList = mutableListOf<Int>()
    var n = list.size
    for (i in n - 1 downTo 0) {
        resultList.add(list[i])
    }
    return resultList
}
