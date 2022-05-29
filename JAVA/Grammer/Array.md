# 배열(Array)
___

## Arrays.asList


## 배열 내용 출력하기(Arrays.toString)
Java에서 배열의 변수를 그대로 출력하면 배열의 주소값이 출력된다. 일반적인 경우에 주소를 출력하기 보다는 내용을 출력하는데, 이 때 `Arrays.toString()` 을 사용해야 한다.

```
int[] arr = {10, 20, 30};

System.out.println(arr);                    // [I@6bdf28bb
System.out.println(Arrays.toString(arr));   // [10, 20, 30]
```
## 배열 복사하기(Arrays.copyOf, Arrays.copyOfRange)
### Arrays.copyOf(복사할 배열, 복사할 배열의 크기)
```
int[] arr = {1, 2, 3, 4, 5};
int[] arr2 = Arrays.copyOf(arr, 3);

for(int i = 0; i < arr2.length; i++) {
    System.out.print(arr2[i]);              // 1, 2, 3
}
```
### Arrays.copyOfRange(복사할 배열, 시작인덱스, 끝인덱스)
```
int[] arr = {1, 2, 3, 4, 5};
int[] arr3 = Arrays.copyOfRange(arr, 0, 2);

for(int i = 0; i < arr3.length; i++) {
    System.out.print(arr3[i]);              // 1, 2
}
```
주의할 점은 복사되는 배열은 시작 인덱스부터 끝 인덱스 바로 전까지 복사가 된다는 것이다.  
또한 복사받는 배열(arr3)이 복사하는 배열(arr1)보다 범위를 크게 지정해주면 초과하는 범위에는 배열타입의 default 값이 들어가게 된다.
```
int[] arr = {1, 2, 3, 4, 5};
int[] arr4 = Arrays.copyOfRange(arr, 0, 6);

for(int i = 0; i < arr4.length; i++) {
    System.out.print(arr4[i]);              // 1, 2, 3, 4, 5, 0
}
```