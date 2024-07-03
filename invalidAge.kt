class InvalidAgeException(message: String) : Exception(message)
fun main() {
    try {
        checkAge(17)
    } catch (e: InvalidAgeException) {
        println(e.message)
    }
}
fun checkAge(age: Int) {
    if(age < 18) {
        throw InvalidAgeException("You must be at least 18 years old.")
    }
    else {
        println("You are above 18")
    }
}
