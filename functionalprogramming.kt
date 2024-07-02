fun main() {
    val numbers = listOf(1,2,3,4,5)
	val squaredNumbers = numbers.map { it * it }
    val oddSquare= squaredNumbers.filter { it % 2 != 0 }//remove even square
    val res= oddSquare.sum()
	println("The sum of the squares of the odd numbers are: $res")
}