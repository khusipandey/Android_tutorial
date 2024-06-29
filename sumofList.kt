fun main() {
    val res=sumofList(1,2,3,4,5,6,7)
    println("The sum of the list is $res")  
    
}
fun sumofList(vararg numbers: Int): Int {
    var sum = 0
    for (num in numbers) {
        sum=sum+num
    }
    return sum
}
