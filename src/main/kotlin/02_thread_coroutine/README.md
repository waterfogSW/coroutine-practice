# 스레드 vs 코루틴

## 정의

- 프로세스 : 실행중인 프로그램
- 스레드 : 프로세스 내에서 실행되는 흐름의 단위
- 루틴 : 프로그램이 실행되는 흐름
- 코루틴 : 루틴과 비슷하지만, 루틴과 달리 여러개의 흐름을 가질 수 있다.

## Context Switching

비용 : Process > Thread > Coroutine(동일 Thread 내)

- Process : 프로세스간의 Context Switching을 위해서는 heap, stack 영역을 모두 교체되어야 하기 때문에 비용이 크다.
- Thread : 프로세스 내의 스레드간의 Context Switching을 위해서는 stack 영역만 교체되면 되기 때문에 프로세스간의 Context Switching보다는 비용이 적다.
- Coroutine : 코루틴간의 Context Switching이 동일한 Thread에서 발생하는 경우 메모리 영역을 공유하기 때문에 Thread보다 Context Switching 비용이 적을 수 있다.

## 동시성 병렬성

- 동시성 : 여러개의 작업을 동시에 처리하는 것처럼 보이는 것(논리적)
- 병렬성 : 여러개의 작업을 동시에 처리하는 것(물리적)
