# Coroutine

## 루틴과 코루틴

### 코루틴 의존성

코루틴을 사용하기 위해서는 아래의 의존성을 추가해주어야 한다
```kotlin
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${version}")
```


### 루틴 vs 코루틴

#### 루틴

루틴은 일반적으로 프로그램이 실행되는 흐름을 의미한다.
루틴은 하나의 흐름을 가지고 있으며, 루틴이 실행되는 동안에는 다른 루틴이 실행될 수 없다.

#### 코루틴

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

### 출력 결과

```shell
[main @coroutine#1] : start
[main @coroutine#1] : end
[main @coroutine#2] : 3
```


## 스레드 vs 코루틴

### 정의

- 프로세스 : 실행중인 프로그램
- 스레드 : 프로세스 내에서 실행되는 흐름의 단위
- 루틴 : 프로그램이 실행되는 흐름
- 코루틴 : 루틴과 비슷하지만, 루틴과 달리 여러개의 흐름을 가질 수 있다.

### Context Switching

비용 : Process > Thread > Coroutine(동일 Thread 내)

- Process : 프로세스간의 Context Switching을 위해서는 heap, stack 영역을 모두 교체되어야 하기 때문에 비용이 크다.
- Thread : 프로세스 내의 스레드간의 Context Switching을 위해서는 stack 영역만 교체되면 되기 때문에 프로세스간의 Context Switching보다는 비용이 적다.
- Coroutine : 코루틴간의 Context Switching이 동일한 Thread에서 발생하는 경우 메모리 영역을 공유하기 때문에 Thread보다 Context Switching 비용이 적을 수 있다.

### 동시성 병렬성

- 동시성 : 여러개의 작업을 동시에 처리하는 것처럼 보이는 것(논리적)
- 병렬성 : 여러개의 작업을 동시에 처리하는 것(물리적)
