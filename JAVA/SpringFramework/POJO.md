# POJO(Plain Old Java Object)

![](png/SpringTriangle.png)

이 그림은 POJO라는 것을 `IoC/DI, AOP, PSA`를 통해서 달성할 수 있다는 것을 의미한다.
이 때 [POJO][POJO]는 오래된 방식의 간단한 자바 오브젝트라는 말로서, Java EE 등의 중량 프레임워크를 사용하게 되면서 해당 프레임워크에 종속된 "무거운" 객체를 만들게 된 것에 반발해서 사용하게 된 용어다. 

[POJO]: https://ko.wikipedia.org/wiki/Plain_Old_Java_Object

POJO 프로그래밍이란 POJO를 이용해서 프로그래밍 코드를 작성하는 것을 의미한다. 그런데 단순히 순수 자바 객체만을 사용해서 코드를 작성한다고 해서 POJO 프로그래밍이라고 볼 수는 없고, `두 가지 규칙`을 만족해야 한다.

### 1. Java나 Java의 스펙에 정의된 것 이외에는 다른 기술이나 규약에 얽매이지 않아야 한다.
```
public class MessageForm extends ActionForm{ // (1)
	
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}

public class MessageAction extends Action{ // (2)
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
        throws Exception {
		
		MessageForm messageForm = (MessageForm) form;
		messageForm .setMessage("Hello World");
		
		return mapping.findForward("success");
	}
	
}
```
ActionForm과 Action은 Struts라는 웹 프레임워크에서 지원하는 클래스다. (1), (2)에서 Struts를 사용하기 위해 ActionForm과 Action을 상속받고 있다.

이렇게 특정 기술을 상속해서 코드를 작성하게 되면, 나중에 애플리케이션의 요구사항이 변경되서 다른 기술로 변경하려면 Struts의 클래스를 명시적으로 사용했던 부분을 일일히 제거하거나 수정해야 한다.
그리고 Java는 다중 상속을 지원하지 않기 때문에 한 번 상속을 하게 되면 상위 클래스를 상속받아서 하위 클래스를 확장하는 객체지향 설계 기법을 적용하기 어려워지게 된다. 

### 2. 특정 환경에 종속되지 않아야 한다.  
Servlet 기반의 웹 애플리케이션을 실행시키는 서블릿 컨테이너(Servlet Container)인 아파치 톰캣(Apache Tomcat)을 예시로 들어보자.
순수 Java로 작성한 애플리케이션 코드 내에서 Tomcat이 지원하는 API를 직접 가져다 쓴다고 가정해보자. 그런데 요구사항이 변경되어서 Tomcat 말고 제티(Zetty)라는 다른 Servlet Container를 사용하게 된다면 어떻게 될까?
애플리케이션 코드에서 사용하고 있는 Tomcat API 코드를 모두 걷어내고 Zetty로 수정하던가 아니면 애플리케이션을 전부 고쳐야하는 상황에 직면하게 될수도 있다.

<br>

### 앞서 말했던 내용을 종합해보면, `POJO 프로그래밍이 필요한 이유`는 5가지가 있다.
1. 특정 환경이나 기술에 종속적이지 않으면 재사용 가능하고, 확장 가능한 유연한 코드를 작성할 수 있다.
2. 저수준 레벨의 기술과 환경에 종속적인 코드를 애플리케이션 코드에서 제거 함으로써 코드가 깔끔해진다.
3. 코드가 깔끔해지기 때문에 디버깅하기도 상대적으로 쉽다.
4. 특정 기술이나 환경에 종속적이지 않기 때문에 테스트 역시 단순해진다.
5. **객체 지향적인 설계를 제한없이 적용할 수 있다.**

Spring은 `POJO 프로그래밍을 지향하는 Framework`다. 그리고 다른 환경이나 기술에 종속되지 않게 하기 위한 POJO 프로그래밍 코드를 작성하기 위해서 Spring에서는 세 가지 기술을 지원하고 있다.
그 기술들에 대해 알아보자.

<br>

## IoC(Inversion of Control) / DI(Dependency Injection)
`애플리케이션 흐름의 주도권이 바뀐 것`을 IoC라 한다. IoC를 이해하기 위해서 기존에 우리가 알고 있던 애플리케이션의 흐름과 그 반대 흐름의 의미를 샘플 코드 및 그림을 통해 알아보자.

### Java 콘솔 애플리케이션의 일반적인 제어권
```
public class Example {
    public static void main(String[] args) {
        System.out.println("Hello IoC!");
    }
}
```
일반적으로 위와 같은 Java 콘솔 애플리케이션을 실행하려면 `main() 메서드`가 필요하다. 그래야지만 main() 메서드 안에서 다른 객체의 메서드를 호출한다던가 하는 프로세스가 진행되기 때문이다.
위 코드에서는 main() 메서드가 호출되고 난 다음에 System 클래스를 통해서 static 멤버 변수인 out의 println()을 호출한다. 이후 `main() 메서드가 종료되면서 애플리케이션의 실행도 종료`된다. 이런 식으로 개발자가 작성한 코드를 순차적으로 실행하는 것이 애플리케이션의 일반적인 흐름이다.

### Java 웹 애플리케이션에서 IoC가 적용되는 예
이번에는 웹 상에서 돌아가는 Java 웹 애플리케이션을 보자.

![img.png](png/IoC.png)

위 그림은 Servlet 기반의 애플리케이션을 웹에서 실행하기 위한 서블릿 컨테이너(Servlet Container)의 모습이다.

웹에서 동작하는 애플리케이션의 경우 클라이언트가 외부에서 접속해서 사용하는 서비스이기 때문에 main() 메서드가 종료되지 않아야 한다. 그런데 서블릿 컨테이너에서는 서블릿 사양(Specification)에 맞게 작성된 서블릿 클래스만 존재하지 별도의 main() 메서드는 존재하지 않는다. main() 메서드가 없는데 어떻게 애플리케이션이 실행되는 걸까?
서블릿 컨테이너의 경우, `클라이언트의 요청이 들어올 때마다 서블릿 컨테이너 내의 컨테이너 로직(service() 메서드)이 서블릿을 직접 실행시켜주기 때문에 main() 메서드가 필요없다.`

> main() 메서드 처럼 애플리케이션이 실행되는 지점을 엔트리 포인트(Entry point)라고 부른다.

이 경우 서블릿 컨테이너가 Servlet을 제어하고 있기 때문에 애플리케이션의 주도권은 서블릿 컨테이너에 있다. 즉, 서블릿과 애플리케이션 간에 IoC(제어의 역전)의 개념이 적용되어 있는 것이다.

그렇다면 Spring에는 IoC의 개념이 어떻게 적용되어 있을까?

답은 바로 `DI(Dependency Injection)`다.

<br>

### What is DI?
IoC는 서버 컨테이너 기술, 객체 지향 설계, 디자인 패턴에 적용되는 일반적인 개념이고, DI는 IoC 개념을 구체화한 것이라고 볼 수 있다. DI는 말 그대로 `의존성 주입`이라는 의미를 가진다.
객체지향 프로그래밍에서 의존성은 대개 객체 간 의존성을 의미한다. 

A, B라는 클래스를 만들고 A 클래스에서 B 클래스의 기능을 사용하기 위해 B 클래스에 구현되어 있는 메서드를 호출해보자.

![](png/DI1.png)

A 클래스가 B 클래스의 기능을 사용할 때, `A 클래스는 B 클래스에 의존한다`고 표현한다.

이번에는 코드를 통해 의존성 주입에 대해 더 알아보자.
- 클래스 간의 의존관계 성립

![](png/DI2.png)

카페에서 커피를 주문하는 Java 콘솔 애플리케이션을 개발한다고 상상해 보자.
위 그림에서 `MenuController 클래스`는 클라이언트의 요청을 받는 엔드 포인트(End point) 역할을 하고, `MenuService 클래스`는 MenuController 클래스가 전달 받은 클라이언트의 요청을 처리하는 역할을 한다.

> 클라이언트 측면에서 서버의 엔드 포인트(End point)는 클라이언트가 서버의 자원(Resource)을 이용하기 위한 끝지점을 의미한다.

MenuController 클래스는 메뉴 목록을 조회하기 위해 MenuService 클래스의 기능을 이용한다. 즉, `new 키워드`를 사용하여 MenuService 클래스의 객체를 생성한 후, 이 객체로 getMenuList() 메서드를 호출한다.

이처럼 사용하고자 하는 클래스의 객체를 생성하여 참조하게 되면 클래스간 의존 관계가 성립한다.

- 의존성 주입

클래스간 의존 관계는 성립 되었지만, 의존성 주입은 아직 이루어지지 않았다. 이번에는 의존성을 주입해보자.

![img.png](png/DI3.png)

이번에는 MenuController 생성자로 MenuService의 객체를 전달받고 있다. 이처럼 `생성자를 통해서 어떤 클래스의 객체를 전달받는 것`을 `의존성 주입`이라 한다.
즉, 생성자의 파라미터로 객체를 전달하는 것을 `외부에서 객체를 주입한다`고 표현한다. 여기서 `CafeClient 클래스`가 MenuController의 생성자 파라미터로 menuService를 전달하고 있기 때문에 객체를 주입해주는 외부가 된다.

<br> 

### Why do we need DI?


<br>

## AOP(Aspect Oriented Programming)

<br>

## PSA(Portable Service Abstraction)