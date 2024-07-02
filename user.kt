data class User(val name: String?, val email: String?)
fun main() {
    val users = listOf(User("Raj", "Raj034@gmail.com"),User(null,"Raghav999@gmail.com"),User("Suman", null))
	for (user in users) {
        printUserDetails(user)
    }
}
fun printUserDetails(user: User) {
    if (user.name== null || user.email== null) 
    {
        println("Incomplete User")
    } else {
        println("Name = ${user.name},email= ${user.email}")
    }
}
