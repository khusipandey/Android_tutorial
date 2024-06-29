fun main() {
    var str="aba" 
    val res=isPalindrome(str)
    if(res){
        println("String $str is pallindrome ")
    }
    else
    {
        println("string is not pallindrome")
    }
    
}
fun isPalindrome(str: String): Boolean {
    var len=str.length
    for ( i in 0 until len/2)
    {
        if(str[i]!=str[len-i-1])
        {
            return false
        }
    }
    return true
}

