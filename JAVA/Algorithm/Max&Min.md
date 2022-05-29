# 최대/최소 요소 구하기
___
## Java에서 최대나 최소 요소를 찾을 때 사용되는 3가지 방법

### 1. Loop
```
List<Integer> nums = List.of(2, 1, 3, 0, 8, 6);  // 불변 리스트 생성
int max = -1;
for (int i = 0; i < nums.size(); i++) {
    int num = nums.get(i);
    if (max < num) {
        max = num;
    }
}
System.out.println("Max : " + max);              // Max : 8
```
반복문을 이용하여 변수 max에 지속적으로 새로운 값을 할당하는 방식이다.
이는 전형적인 명령형 프로그래밍(Imperative Programming) 스타일을 따르고 있다.
가장 고전적인 방법이지만, 가독성을 해칠 가능성이 높은 방식이라 피하는게 좋다.  
`List.of` 메서드는 불변 리스트 생성을 위해서 Java9에 추가되었다.

[//]: # ([참고][link2])
[//]: # ([link2]: 나중에 컬렉션프레임워크할때 ㄱㄱ >> https://www.daleseo.com/java9-immutable-collections/)
  
<br>

### 2. Collections.max() & Collections.min()
`Collection` 클래스의 `max()` 정적 메서드를 이용하면 간단하게 최댓값, 최솟값을 찾을 수 있다.
```
List<Integer> nums = List.of(2, 1, 3, 0, 8, 6);
int max = nums.isEmpty() ? -1 : Collections.max(nums);
System.out.println("Max : " + max);                     // Max : 8
```
이 때, 리스트가 비어있을 경우 `NoSuchElementException` 이 발생하므로, 반드시 리스트가 비어있을 경우에 대한 기본값 처리가 필요하다.  

최솟값은 `Collection` 클래스의 `min()` 정적 메서드를 이용한다.
```
List<Integer> nums = List.of(2, 1, 3, 0, 8, 6);
int max = nums.isEmpty() ? -1 : Collections.min(nums);
System.out.println("Min : " + min);                      // Min : 0
```
참고로 max() 와 min() 정적 메서드는 `리스트 타입`의 인자만 받기 때문에, 대상이 배열이라면 리스트로 변환을 한 후 호출해야 한다.

<br> 

### 3. Stream#max() & Stream#min()
Java8의 Stream API의 `max()` 메서드를 이용하여 함수형 프로그래밍(Functional Programming) 스타일로 최댓값을 구할 수 있다.
```
List<Integer> nums = List.of(2, 1, 3, 0, 8, 6);
int max = nums.stream().max(Integer::compare).orElse(-1);
System.out.println("Max : " + max);                     // Max : 8
```
Stream API의 `max()` 메서드는 최대 원소를 담고 있는 Optional 객체를 반환하기 때문에 orElse() 메서드를 이용해서 자연스럽게 기본값 처리를 할 수 있다.
또한 인자로 배열이나 리스트가 주어졌을 때, Stream으로 처리가 가능하다.

max() 는 또한 인자로 `메서드 레퍼런스(Method Reference)`나 `람다 함수`를 인자로 받는다. `1. Loop`에서 최댓값을 구하기 위해 for문 내부의 대소 비교 코드를 람다 함수로 구현하여 인자로 넘긴다고 생각하면 이해하기 쉬울 것이다.

위 코드에서 메서드 레퍼런스 부분을 람다 함수로 바꾸면 다음과 같이 작성할 수 있다.
```
int max = nums.stream().max((x, y) -> x - y).orElse(Integer.MIN_VAULE);
```
`Comparator` 인터페이스의 `compare()` 메서드에 부합하도록 비교할 두 개의 요소를 인자로 받아 비교 결과를 음수나 양수, 0으로 반환하는 람다 함수를 작성하면 된다.

또한 최솟값은 Stream API의 min() 메서드를 사용하면 된다.
```
List<Integer> nums = List.of(2, 1, 3, 0, 8, 6);
int min = nums.stream().min(Integer::compare).orElse(-1);
System.out.println("Min : " + min);                     // Min : 0
```

<br>

___
### `Reference`
[How to find the maximum and minimum element in Java][link]

[link]: https://www.daleseo.com/java-min-max/