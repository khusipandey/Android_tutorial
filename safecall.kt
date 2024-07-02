 fun main() {
    println(string("Hello World"))
    println(string(null))
}
fun string(str: String?): Int {
    if(str?.length==null)
    {
        return -1
    }
    else
    {
        return str.length
    }
}
