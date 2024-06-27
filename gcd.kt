fun main() {
    var num1 = 36
    var num2 = 22
    while (num1!= 0) {
        val temp = num1
        num1 = num2 % num1
        num2 = temp
    }
    println("$num2")
}
