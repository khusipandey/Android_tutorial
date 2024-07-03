import kotlinx.coroutines.*
fun main() = runBlocking {
    val task = launch {
        delay(1500)
        println("Long-running task completed")
    }
    withTimeout(2000) {
        task.join()
    }
	if (task.isCancelled) {
        println("timeout")
    } else {
        println("Coroutine completed")
    }
}
