fun main() {
    val n=8
    val res=factorial(n)
    println("Factorial of $n is $res")
}
fun factorial(n: Int): Int {
    var fac=1
    if(n==0 || n==1)
    {
     return 1   
    }
    else {
        fac=n*factorial(n - 1)
    }
    return fac 
}
