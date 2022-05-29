# 콘솔 입출력(I/O)
___
## 출력(Output)

1. System.out.print() : 출력하기
2. System.out.println() : 출력하고 줄바꾸기, ln은 line을 의미한다.

### 3. System.out.printf()
: 형식 지정자(specifier)를 이용해 변수의 값을 여러 형식대로 출력하기, f는 `formatted`를 의미한다.


| Specifier | Output format  |
|:----------|:--------------:|
| %b        |    Boolean     |
| %d        |      10진수      |
| %o        |      8진수       |
| %x, %X    |      16진수      |
| %c        |       문자       |
| %s        |      문자열       |
| %n        |      줄바꿈       |

```
System.out.printf("%s%n", "JAVA Programming");
System.out.printf("%s%n", "Lee" + "JIN");
System.out.printf("%d%n", 15 + 12);
System.out.printf("지금은 %s입니다.%n", 2022 + " year");   // 자동 타입 변환
System.out.printf("저는 %c%s입니다", '김', "철수");         // 한번에 여러개의 인자를 넣을 수 있다
```

## 입력(Input)
```
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
String inputVal = scanner.nextLine();

System.out.println(inputVal);
```

Scanner scanner = new Scanner(System.in)  
: Scanner 클래스, 우리가 이용하려는 Scanner 클래스의 데이터 입력 기능은 클래스 자체가 아니라 클래스가 만들어낸 객체에 존재한다. 따라서 먼저 Scanner 클래스를 이용해 객체를 만들어야 한다.

String inputVal = scanner.nextLine()  
: scanner.nextLine() 메서드는 문자열을 입력받기 위한 코드이다.  
참고로 Scanner에는 문자열을 입력받는 nextLine(), 정수형을 입력받는 nextInt(), 실수형을 입력받는 nextFloat() 등의 메서드도 존재한다.