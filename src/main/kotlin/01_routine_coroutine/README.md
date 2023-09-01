# 루틴과 코루틴

## 코루틴 의존성

코루틴을 사용하기 위해서는 아래의 의존성을 추가해주어야 한다
```kotlin
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${version}")
```


## 루틴 vs 코루틴

### 루틴

루틴은 일반적으로 프로그램이 실행되는 흐름을 의미한다.
루틴은 하나의 흐름을 가지고 있으며, 루틴이 실행되는 동안에는 다른 루틴이 실행될 수 없다.

### 코루틴

코루틴은 루틴과 비슷하지만, 루틴과 달리 여러개의 흐름을 가질 수 있다.


```kotlin
fun main(): Unit = runBlocking {
    println("START")
    launch {
        newRoutine()
    }
    yield()
    println("END")
}

suspend fun newRoutine() {
    val num1 = 1
    val num2 = 2
    yield()
    println("${num1 + num2}")
}
```

- `runBlocking` : 루틴과 코루틴을 연결하는 함수로 해당 함수 내의 코루틴이 실행되는 동안 runBlocking을 호출한 루틴은 Blocking된다. 

- `launch` : 코루틴을 실행하는 함수로, 반환값이 없는 코루틴을 만드는데 사용한다.

- `yield` : 코루틴이 실행되는 동안 다른 코루틴이 실행될 수 있도록 양보하는 함수이다.

- `suspend fun ` : 일시 중단 가능한 함수로, 다른 thread를 block하지 않는다. 코루틴, 또는 `suspend fun` 내에서 호출 가능하다. 

## 출력 결과

```shell
[main @coroutine#1] : start
[main @coroutine#1] : end
[main @coroutine#2] : 3
```
