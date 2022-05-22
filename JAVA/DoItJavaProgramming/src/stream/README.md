# 스트림(Stream)
___
### 스트림이란?
자료가 모여 있는 배열이나 컬렉션 또는 특정 범위 안에 있는 일련의 숫자를 처리하는 기능이 미리 구현되어 있다면 프로그램의 코드가 훨씬 간결해지고 일관성 있게 다룰 수 있다.  
ex) 배열 요소를 특정 기준에 따라 정렬(sorting)하거나, 요소 중 특정 값은 제외하고 출력하는(filter) 기능  
이렇게 여러 자료의 처리에 대한 기능을 구현해 놓은 클래스를 `스트림(Stream)`이라 한다.

배열을 예로 들어보자.
```
int[] arr = {1, 2, 3, 4, 5};
for(int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```
이 배열에 대한 스트림을 생성하여 출력하면 다음과 같다.
```
int[] arr = {1, 2, 3, 4, 5};
Arrays.stream(arr).forEach(n -> System.out.println(n));
```
`Arrays.stream(arr)` : 스트림 생성 부분  
`forEach(n -> System.out.println(n))` : 요소를 하나씩 꺼내어 출력하는 기능  
이처럼 스트림을 생성하고 미리 구현되어 있는 forEach() 메서드(최종 연산)를 사용하여 배열의 요소를 하나씩 꺼내어 출력할 수 있다.  

<br>

### 스트림 연산
스트림 연산의 종류에는 크게 중간 연산과 최종 연산 두 가지가 있다.  
중간 연산은 자료를 거르거나 변경하여 또 다른 자료를 내부적으로 생성한다.  
최종 연산은 생성된 내부 자료를 소모해 가면서 연산을 수행한다. 따라서 최종 연산은 마지막에 한 번만 호출된다.  

#### 중간연산(Intermediate operation) - filter(), map(), distinct()
filter() : 조건을 넣고 조건에 맞는 경우만 추출하는 경우에 사용
```
sList.stream().filter(s -> s.length() >= 5).forEach(s -> System.out.println(s));
```
map000() : 기존의 Stream 요소들을 대체하는 요소로 구성된 새로운 Stream을 형성  
ex) mapToInt(), mapToLong(), mapToDouble() 등
```
sList.stream().map(c -> c.getName()).forEach(s -> System.out.println(s));
```

#### 최종 연산(Terminal operation) - forEach(), count(), sum(), reduce()
forEach()는 앞에서 설명했듯이 요소를 하나씩 꺼내어 출력  
통계용으로 사용되는 sum(), count()는 배열 요소의 합계를 구한다거나 개수를 출력하는 연산을 수행

<br>

#### Collection에서 스트림 생성하고 사용하기
```
List<String> sList = new ArrayList<>();
sList.add("L");
sList.add("J");
sList.add("W");
```
이 ArrayList의 스트림을 생성하여 출력하고, 정렬해보자.  
Collection 인터페이스의 메서드에는 이러한 메서드가 있다.

|        메서드         |        설명        |
|:------------------:|:----------------:|
| Stream`<E>` stream() |   스트림 클래스를 반환    |

Collection 에서 stream() 메서드를 사용하면 이 클래스는 제너릭형을 사용해 다음과 같이 자료형을 명시할 수 있다.  
```
Stream<String> stream = sList.stream();
```
이렇게 생성된 스트림은 내부적으로 ArrayList의 모든 요소를 가지고 있다. 각 요소를 하나씩 출력해보자.
```
Stream<String> stream = sList.stream();
stream.forEach(s -> System.out.println(s));
```
이번에는 ArrayList에 저장된 이름을 정렬하여 출력해보자. 앞에서 최종 연산인 forEach() 메서드가 수행되면서 스트림이 소모되었기 때문에 스트림을 새로 생성해야 한다.
```
Stream<String> stream2 = sList.stream();
stream2.sorted().forEach(s -> System.out.println(s));
```
 sorted() 메서드를 사용하려면 정렬 방식에 대한 정의가 필요하다. 따라서 사용하는 자료 클래스가 Comparable 인터페이스를 구현해야 한다. 만약 구현되어 있지 않다면 sorted() 메서드의 매개변수로 Comparator 인터페이스를 구현한 클래스를 지정할 수 있다.  
 ArrayList 이외에 다른 Collection 의 자료도 같은 방식으로 정렬하고 출력할 수 있다.
 
### 스트림의 특징
1. **자료의 대상과 관계없이 동일한 연산 수행한다.**
2. **한 번 생성하고 사용한 스트림은 재사용할 수 없다.**
3. **스트림의 연산은 기존 자료를 변경하지 않는다.**  
스트림 연산을 위해 사용하는 메모리 공간이 별도로 존재하므로, 스트림의 여러 메서드를 호출하더라도 기존 자료에는 영향을 미치지 않는다.
4. **스트림의 연산은 중간 연산과 최종 연산이 있다.**  
최종 연산이 호출되어야 스트림의 중간 연산이 모두 적용된다. >> 지연 연산(lazy evaluation)

### reduce() 메서드
reduce() 연산은 내부적으로 스트림의 요소를 하나씩 소모하면서 프로그래머가 직접 지정한 기능을 수행한다.
```
T reduce(T identify, BinaryOperator<T> accumulator)
```
첫 번째 매개변수 `T identify` 는 초기값, 두 번째 매개변수 `BinaryOperator<T> accumulator` 는 수행해야 할 기능을 의미한다. `BinaryOperator 인터페이스`는 두 매개변수로 람다식을 구현하며, 이 람다식이 각 요소가 수행해야 할 기능이 된다.  
이 때 `BinaryOperator 인터페이스`를 구현한 람다식을 직접 쓰거나,  
람다식이 길면 인터페이스를 구현한 클래스를 생성하여 대입해도 된다.  
또한 BinaryOperator 는 함수형 인터페이스로 `apply() 메서드`를 반드시 구현해야 한다. apply() 메서드는 두 개의 매개변수와 한 개의 반환 값을 가지는데, 모두 같은 자료형이다. reduce() 메서드가 호출될 때 BinaryOperator의 apply()메서드가 호출된다.

배열에 여러 문자열이 있을 때 그 중 길이가 가장 긴 문자열을 찾는 [예제] (http://www.naver.com)

[예제] (https://github.com/Woogiemon/TIL/blob/master/JAVA/DoItJavaProgramming/src/stream/ReduceTest.java)를 확인해보자.
<br>

> 참고문헌: 
> Do it! 자바 프로그래밍 입문 - 박은종