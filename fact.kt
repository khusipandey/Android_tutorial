fun main() {
    val num= 7
    val fact= calculateFact(num)
    println("The factorial of $num is $fact")
}
fun calculateFact(n: Int): Int {
    val factorialLambda: (Int) -> Int = { num ->
        var f= 1
        for (i in 1..num) {
            f=f*i
        }
        f
    }
    return factorialLambda(n)
}
