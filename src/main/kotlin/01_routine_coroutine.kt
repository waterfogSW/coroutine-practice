import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

class `01_routine_coroutine`

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
