fun main() {
    val res = max(5, 10)
    println("$res")  
    
}
fun max(a: Int, b: Int): Int 
{
    if (a > b)
    {
        return a
    }
    else
    	return b
}
