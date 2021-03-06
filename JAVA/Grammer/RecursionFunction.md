# 재귀함수(Recursion Function)
___
## 재귀함수란?
어떤 문제를 같은 구조의 더 작은 문제로 나눈 후, 이 작은 문제를 해결함으로써 전체 문제를 해결하는 방법을 `재귀(Recursion)`라고 한다.
즉 `재귀함수(Recursion Function)`는 함수 내에서 자기 자신을 다시 호출하여 문제를 해결해 나가는 함수이다. 
  
재귀는 다음과 같은 상황에서 주로 쓰인다.
1. 문제를 비슷한 구조의 더 작은 문제로 나눌 수 있는 경우
2. 반복문의 중첩 횟수를 예측하기 어려운 경우
3. 변수 사용을 줄여 변경 가능한 상태(mutable state)를 제거하여 프로그램 오류가 발생할 가능성을 줄이는 경우

우리가 흔히 알고 있는 반복문은 `for문, while문`이 있는데, 이러한 반복문으로 구현가능한 로직은 재귀함수로도 가능하고, 그 반대 역시 가능하다.
그러나 재귀를 적용할 수 있는 경우 재귀를 적용한 코드가 훨씬 간결하고 이해하기 쉽다.

이러한 재귀함수의 가장 대표적인 사용 예제는 `Factorial`이다.
```
public int factorial(int n) {

    if (n == 1) {       
        return 1;           // Base Case
    }
    
    return n * factorial(n-1);  // Recursion Case
}
```
예를 들어 n = 5 라면, `5 * 4 * 3 * 2 * 1` 이 실행되는 것이다.

## 재귀함수를 사용할 때 자주 마주하게 되는 에러
1. **StackOverflowError**  
위에서 작성한 코드에서 `Base Case` 이 생략된다면?  
n이 1일 경우에 1을 return 하면서 재귀함수를 탈출해야 하는데, 그렇지 못하고 0, -1, -2...  까지 무한대로 실행된다. 즉 호출한 함수가 종료되지 않은 채 새로운 함수를 무한대로 호출하면서 스택에 메모리가 계속 저장된다. 그러다가 스택 메모리에 더이상 가용 메모리가 없을 경우 `StackOverFlow`가 발생하게 된다.
 

2. **IndexOutOfBoundsException**  
리스트형 객체에서 선언되지 않은 요소를 get() 하는 경우에 발생한다.

## 재귀함수의 장단점
### 장점
1. 변수를 여러 개 만들 필요가 없다.
2. 반복문을 사용하지 않아도 되기에 코드가 간결해진다.
### 단점
1. 지속적으로 함수를 호출하게 되면서 지역변수, 매개변수, 반환값을 모두 process stack에 저장해야합니다. 그리고 이런 과정은 선언한 변수의 값만 사용하는 반복문에 비해서 메모리를 더 많이 사용하게 되고, 이는 속도 저하로 이어진다.
2. 함수 호출 -> 복귀를 위한 `Context Switching`에 비용이 발생하게 된다.

## 재귀함수 문제를 푸는 데 자주 사용하는 메서드
### Arrays.copy(), Arrays.copyOfRange()
값에 의한 복사이므로 복사된 배열에서 값을 바꿔도 원본 배열의 값이 바뀌지 않는다.

- Arrays.copyOf(원본배열, 복사할 길이);  
- Arrays.copyOfRange(원본 배열, 복사할 시작인덱스, 복사할 끝인덱스)

```
int[] arr1 = {11, 22, 33, 44, 55};
for(int i : arr1) {
    System.out.println(i);                  // {11, 22, 33, 44, 55}
}

int[] arr2 = Arrays.copyOf(arr1, 4);
for(int i : arr2) {
    System.out.println(i);                  // {11, 22, 33, 44}
}

int[] arr3= Arrays.copyOfRange(arr1, 3, 4);
for(int i : arr3) {
    System.out.println(i);                   // {44}
}
```

### System.arraycopy()

- System.arraycopy(src, srcPos, dest, destPos, length) 

Object src : 복사하고자 하는 소스(원본)  
int srcPos : 원본 소스의 어느 인덱스부터 읽어올지를 나타냄  
Object dest : 복사할 소스  
int destPos : 위의 복사본에서 자료를 받을 때, 어느 인덱스부터 쓸 것인지를 나타내는 시작 위치  
int length : 원본에서 복사본으로 데이터를 얼마나 읽어 올지 나타내는 데이터 길이
