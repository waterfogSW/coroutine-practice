import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    println("-------------------------------")
    launchExample()
    println("-------------------------------")
    lazyLaunchExample()
    println("-------------------------------")
    joinJobExample()
    println("-------------------------------")
    cancelJobExample()
    println("-------------------------------")
    asyncExample()
    println("-------------------------------")

}

fun launchExample() {
    printWithThread("launchExample")
    val time = measureTimeMillis {

        runBlocking {
            val job1 = launch {
                delay(1000)
                printWithThread("job1")
            }

            val job2 = launch {
                delay(1000)
                printWithThread("job2")
            }
        }
    }
    printWithThread("time: $time")
}

fun lazyLaunchExample() {
    printWithThread("lazyLaunchExample")
    val time = measureTimeMillis {

        runBlocking {
            val job1 = launch(start = CoroutineStart.LAZY) {
                delay(1000)
                printWithThread("job1")
            }

            val job2 = launch(start = CoroutineStart.LAZY) {
                delay(1000)
                printWithThread("job2")
            }

            delay(1000)

            job1.start()
            job2.start()
        }
    }
    printWithThread("time: $time")
}

fun joinJobExample() {
    printWithThread("joinJobExample")
    val time = measureTimeMillis {

        runBlocking {
            val job1 = launch {
                delay(1000)
                printWithThread("job1")
            }

            job1.join()

            val job2 = launch {
                delay(1000)
                printWithThread("job2")
            }

        }
    }
    printWithThread("time: $time")
}

fun cancelJobExample() {
    printWithThread("cancelJobExample")
    val time = measureTimeMillis {

        runBlocking {
            val job = launch {
                (0..5).forEach {
                    delay(1000)
                    printWithThread("job1: $it")
                }
            }

            delay(2500)
            job.cancel()
        }
    }
    printWithThread("time: $time")
}

fun asyncExample() {
    printWithThread("asyncExample")
    val time = measureTimeMillis {

        runBlocking {
            val job1 = async { getNumber1() }
            val job2 = async { getNumber2() }

            val result = job1.await() + job2.await()

            printWithThread("result: $result")
        }
    }
    printWithThread("time: $time")
}


suspend fun getNumber1(): Int {
    delay(1000)
    printWithThread("getNumber1")
    return 1
}

suspend fun getNumber2(): Int {
    delay(1000)
    printWithThread("getNumber2")
    return 2
}
