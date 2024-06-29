fun main() {
    val account=BankAccount(12345, 1000)
    println("Initial balance: ${account.getbalance()}")
	  account.deposit(500)
    println("after adding 500 balance: ${account.getbalance()}")
    account.withdraw(300)
    println("after withdrawing 300 balance : ${account.getbalance()}")
}
class BankAccount(var accountNumber: Int,var balance: Int) {
	fun deposit(amount: Int) {
        balance= balance+amount
    }
	fun withdraw(amount: Int) {
        if (amount > balance) {
            println("Insufficient balance")
        } else {
            balance=balance-amount
        }
    }
	fun getbalance(): Int {
        return balance
    }
}
