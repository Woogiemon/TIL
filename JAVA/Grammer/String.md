# 문자열(String)
___

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