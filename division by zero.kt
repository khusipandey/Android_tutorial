fun main() {
    try {
        var a=5
        var b=0
        var res=a/b
        println("result is $res")
    } catch (e: ArithmeticException) {
        println("error ${e.message}")
    }
}
