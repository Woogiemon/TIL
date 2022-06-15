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

<br>

## AOP(Aspect Oriented Programming)

<br>

## PSA(Portable Service Abstraction)