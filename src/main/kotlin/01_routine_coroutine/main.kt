package `01_routine_coroutine`

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield


fun main() = runBlocking {
    printWithThread("start")
    launch {
        coroutine(1, 2)
    }
    yield()
    printWithThread("end")
}

suspend fun coroutine(
    num1: Int,
    num2: Int
) {
    val result = num1 + num2
    yield()
    printWithThread(result.toString())
}

fun printWithThread(value: String) {
    println("[${Thread.currentThread().name}] : $value")
}
