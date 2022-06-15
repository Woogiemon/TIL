# Spring Framework
___

## Framework
Frame이란 단어는 여러가지 의미가 있지만 가장 대표적인 의미로는 '뼈대, 틀, 구조' 등이 있다. 일상생활에서 Frame을 사용하는 경우를 보면 이해가 빠를 것이다.
우리가 벽에 거는 그림이나 사진 등의 액자를 Frame이라고 부른다. 그리고 자동차의 뼈대가 되는 강판으로 된 껍 데기 역시 자동차의 Frame이라고 부른다.

이처럼 프로그래밍의 세계에서 Frame은 `어떤 대상의 큰 틀이나 외형적인 구조`를 의미한다.

웹의 초창기 시절에는 HTML 문서를 구성하는 태그 중에서 Frame 태그가 존재했다.
```
<frameset cols="33%,*,33%">
    <frame name="left" src="/left_menu"/>
    <frame name="center" src="/context"/>
    <frame name="right" src="/right_menu"/>
</frameset>
```
이 코드를 보면 frameset과 frame 태그를 이용하여 HTML 문서의 **틀**만 구성하고 있음을 알 수 있다. 그리고 여기에는 나와있지 않지만 HTML 문서의 세부 내용들은 별도의 html 파일에 구성되어있다.

그렇다면 이번에는 frame과 유사한 의미를 가지는 Framework의 예를 들어보자. 이전에 Java 문법 중에서 우리는 **Collections Framework**를 배운 적이 있다.
이는 데이터를 저장하는 자료 구조와 데이터를 처리하는 알고리즘을 구조화하여 클래스로 구현해 놓은 것이다.

근데 왜 하필 Collection에 Framework라는 단어를 붙였을까?  
Java 클래스의 유형 중에서 기본적인 뼈대로만 구성되어 있는 것은 추상 메서드만 정의되어 있는 `인터페이스(Interface)`다. 그리고 Java에서의 Collection은 Map, List, Set과 같은 인터페이스와 그 인터페이스를 구현한 구현체들의 집합이다.

즉, Framework는 기본적으로 `프로그래밍을 하기 위한 어떠한 틀이나 구조를 제공한다`는 것을 알 수 있다.

그리고 Framework는 프로그래밍을 위한 기본 구조를 제공하는 것 이상으로 많은 기능을 제공한다. 개발하고자 하는 애플리케이션을 밑바닥부터 전부 개발하는 것이 아니라, 서로 다른 애플리케이션 간의 통신이나, 데이터를 데이터 저장소에 저장하는 등 다양한 기능 역시 Framework가 라이브러리 형태로 제공함으로써 `개발자가 애플리케이션의 핵심 로직을 개발하는 것에 집중할 수 있도록` 도와준다.

### Framework vs Library
애플리케이션의 구현을 위해 필요한 여러가지 기능등을 제공한다는 의미에서 Framework와 Library는 유사하다고 볼 수 있지만, 둘 사이에는 결정적인 차이점이 존재한다. 그것은 바로 `애플리케이션에 대한 제어권`이다.

```
@SpringBootApplication
@RestController
@RequestMapping(path = "/v1/message")
public class SampleApplication {
    @GetMapping
    public String getMessage() {  // (2)
        String message = "hello world";
        return StringUtils.upperCase(message); // (1)
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }
}
```
이 코드에서 Library를 사용하는 부분은 `(1) StringUtils.upperCase(message)` 이다.
StringUtils 클래스는 Apache Commons Lang3 라이브러리의 유틸리티 클래스 중 하나인데, 애플리케이션이 동작하는 중에 이 StringUtils 클래스의 upperCase() 메서드의 파라미터로 전달하는 문자열(message 변수)를 대문자로 변환한다.

근데 StringUtils 클래스가 라이브러리라는 것은 어떻게 판단할 수 있을까?

애플리케이션 코드는 애플리케이션을 개발하는 사람, 즉 개발자가 작성한다. 이처럼 `개발자가 짜놓은 코드 내에서 필요한 기능이 있으면 해당 라이브러리를 호출해서 사용하는 것`을 **Library**라 한다.
즉, `애플리케이션 흐름의 주도권을 개발자가 가지고 있다.`

이 코드에서 `Annotation`과 `main() 메서드 내의 SpringApplication.run` 메서드는 Spring Framework에서 제공하는 기능이다. 이러한 기능들은 라이브러리와 달리 코드 상에는 보이지 않는 많은 일들을 한다.
`(2) getMessage()` 메서드 내부의 코드처럼 개발자가 메서드 내에 코드를 작성해 두면, Spring Framework에서 개발자가 작성한 코드를 사용해서 애플리케이션의 흐름을 만들어낸다. 즉, `애플리케이션 흐름의 주도권을 Framework가 가지고 있다`. 

<br>

## Spring Framework를 배우는 이유

## POJO
### IOC(Inversion of Control) / DI(Dependency Injection)

### AOP(Aspect Oriented Programming)

### PSA(Portable Service Abstraction)