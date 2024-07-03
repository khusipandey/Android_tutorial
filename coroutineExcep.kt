import kotlinx.coroutines.*
fun main() = runBlocking {
    try {
        val result = withContext(Dispatchers.IO) {
            delay(1000)
            throw RuntimeException("interrupt occur")
        }
        println("Result: $result")
    } catch (e: Exception) {
        println("Error: ${e.message}")
    } finally {
        println("Coroutine finished")
    }
}
