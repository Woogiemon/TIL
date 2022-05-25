# 문자열(String)
___

## 문자열이란?
문자열은 String 클래스를 통해 다루어지고, 그 안에 있는 메서드들을 통해 여러 문자열 관련 메서드들을 사용할 수 있다.
```
String 변수;
변수 = "문자열";	// 문자열 리터럴을 대입

String 변수 = "문자열";

String 변수 = new String("문자열");	// 객체를 새로 생성하고 문자열을 대입
```

다른 변수가 값을 저장하는 방식으로 작동하는 것이 아니라 문자열이 담겨 있는 주소를 참조한다는 느낌이다.
문자열은 String의 객체로 생성되고, 변수는 이 객체의 주소를 참조한다. 그렇기 때문에 String 타입도 `참조 자료형`이다. 이에 따라, 변수에 문자열을 저장할 경우 문자열 리터럴을 사용할 수도 있지만, new 연산자를 사용해서 직접 String 객체를 생성시킬 수도 있다.
```
String name1 = "문자열";
String name2 = "문자열";
String name3 = new String("문자열");

System.out.println(name1 == name2);	// true
System.out.println(name1 == name3);	// false
```
name1과 name2는 동일한 문자열 리터럴로 생성된 객체를 참조한다. (true)  
name3은 new 연산자를 이용해 String 객체를 새로 생성했기 때문에 주소값이 다르다. (false)

### 대표적인 String 메서드
1. **charAt()**  
`해당 문자열의 특정 인덱스에 해당하는 문자를 반환`한다. 만약 해당 문자열의 길이보다 큰 인덱스나 음수를 전달하면, 오류가 발생한다.

2. **compareTo()**  
`해당 문자열을 인수로 전달된 문자열과 사전 편찬 순으로 비교`한다. 이 메서드는 문자열을 비교할 때 대소문자를 구분하여 비교한다. 만약 두 문자열이 같다면 0을 반환하며, 해당 문자열이 인수로 전달된 문자열보다 작으면 음수를, 크면 양수를 반환한다. 만약 문자열을 비교할 때 대소문자를 구분하지 않기를 원한다면, `compareToIgnoreCase()`를 사용하자.

3. **indexOf()**  
`해당 문자열에서 특정 문자나 문자열이 처음으로 등장하는 위치의 인덱스를 반환`한다. 만약 해당 문자열에 전달된 문자나 문자열이 포함되어 있지 않으면 -1을 반환한다.

4. **trim()**  
해당 문자열의 맨 앞과 맨 뒤에 포함된 모든 공백 문자를 제거해준다.

5. **toLowerCase()와 toUpperCase()**  
toLowerCase() : 해당 문자열의 모든 문자를 `소문자`로 변환시켜 준다.  
toUpperCase() : 해당 문자열의 모든 문자를 `대문자`로 변환시켜 준다.
## 문자열 자르기(Split)
### String[] split(String regex)

split 메서드는 입력받은 특정 문자 또는 정규 표현식을 기준으로 문자열을 나누어 배열에 저장하여 반환한다.
```
String str = "가-나-다-라";
String[] strSplit = str.split("-");
String spl1 = strSplit[0];
String spl2 = strSplit[1];
String spl3 = strSplit[2];
String spl4 = strSplit[3];

System.out.println(spl1);       // 가
System.out.println(spl2);       // 나
System.out.println(spl3);       // 다
System.out.println(spl4);       // 라
```

### String[] split(String regex, int limit)

두번째 인자 값은 배열의 크기를 결정한다.
```
String str = "가-나-다-라";
String[] strSplit = str.split("-", 2);
System.out.println(arr[0]);                 // 가
System.out.println(arr[1]);                 // 나-다-라
```
___

## replace() vs replaceAll()
[//]: # (https://jamesdreaming.tistory.com/85)

___
## 문자열에 특정 문자를 포함하는지 검색하는 방법

[//]: # (https://coding-factory.tistory.com/534)