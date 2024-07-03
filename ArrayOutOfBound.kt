fun main() {
    var arr= arrayOf(1,6,9,0,2)
   	accessArr(arr, 10) 
}
fun accessArr(arr: Array<Int>, index: Int) {
    try {
        val ele= arr[index]
        println("Element at index $index: $ele")
    } catch (e: Exception) {
        println("Error: ${e.message}")
    } finally {
        println("Iam inside finally block")
        println("operation completed ")
    }
}
