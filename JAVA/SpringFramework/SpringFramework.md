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
애플리케이션의 구현을 위해 필요한 여러가지 기능등을 제공한다는 의미에서 Framework와 Library는 유사하다고 볼 수 있지만, 둘 사이에는 결정적인 차이점이 존재한다. 그것은 바로 `애플리케이션에 대한 주도권`이다.

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
`(2) getMessage()` 메서드 내부의 코드처럼 개발자가 메서드 내에 코드를 작성해 두면, Spring Framework에서 개발자가 작성한 코드를 사용해서 애플리케이션의 흐름을 만들어낸다. 즉, `애플리케이션 흐름의 주도권을 Framework가 가지고 있다.` 

<br>

## Spring Framework를 배우는 이유
Spring Framework는 Java 기반의 웹 애플리케이션을 개발하는데 필요한 Framework이며, 2004년 버전 1.0이 처음 릴리즈 된 이후로 Java 기반의 웹 애플리케이션을 개발하는 데에 있어 표준이 되었다. 물론 Java 기반의 웹 애플리케이션 개발을 위한 Framework에 Spring Framework만 있는 것은 아니다. Apache Struts2나 Apache Wicket, JSF(Java Server Faces), Grails 같은 Java 또는 JVM 기반의 Web Framework들이 존재하고, 현재도 꾸준히 업데이트 되고 있다.

그럼 사람들이 유독 Spring Framework에 열광하는 이유가 뭘까?

대부분의 기업들이 기업용 엔터프라이즈 시스템용 애플리케이션 개발에 있어 Framework를 선택할 때, 개발 생산성을 높이고 어떻게 하면 애플리케이션의 유지 보수를 좀더 용이하게 할 것인지에 초점을 맞추고 있다. 그런데 Spring Framework는 개발 생산성을 향상 시키고 애플리케이션의 유지 보수를 용이하게 하는 Framework의 기본 목적 그 이상을 달성할 수 있게 해준다.

즉, `Spring Framework를 학습함으로써` 객체 지향 설계 원칙에 맞는 재사용과 확장이 가능한 애플리케이션 개발 스킬을 향상시킬 수 있고,
보다 나은 성능과 안전성이 필요한 복잡한 기업용 엔터프라이즈 시스템을 제대로 구축하기 위한 능력을 기를 수 있다.

<br>

Spring을 본격적으로 도입하기 이전의 기술들을 단계적으로 살펴보자. 이를 통해 왜 Spring Framework를 배워야 하는 지 이해할 수 있다.

### JSP를 이용한 애플리케이션
JSP는 `Java Server Page`의 약자로, 초창기 Java 기반의 웹 애플리케이션 개발은 JSP를 통해 이루어졌다.
이는 웹 브라우저를 통해서 사용자에게 보여지는 클라이언트 측 html/javascript 코드와 사용자의 요청을 처리하는 서버 측 Java 코드가 뒤섞여있는 방식이다.

<details>
<summary>JSP 방식 예제 코드</summary>

```
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- (1) 시작 -->
<%
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");

    System.out.println("Hello Servlet doPost!");

    String todoName = request.getParameter("todoName");
    String todoDate = request.getParameter("todoDate");

    ToDo.todoList.add(new ToDo(todoName, todoDate));

    RequestDispatcher dispatcher = request.getRequestDispatcher("/todo_model1.jsp");
    request.setAttribute("todoList", ToDo.todoList);

    dispatcher.forward(request, response);
%>
<!-- (1) 끝 -->
<html>
<head>
    <meta http-equiv="Content-Language" content="ko"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <title>TODO 등록</title>
    <style>
        #todoList {
            border: 1px solid #8F8F8F;
            width: 500px;
            border-collapse: collapse;
        }

        th, td {
            padding: 5px;
            border: 1px solid #8F8F8F;
        }
    </style>
    <script>
        function registerTodo(){
            var todoName = document.getElementById("todoName").value;
            var todoDate = document.getElementById("todoDate").value;

            if(!todoName){
                alert("할일을 입력해주세요..");
                return false;
            }
            if(!todoDate){
                alert("날짜를 입력해주세요.");
                return false;
            }

            var form = document.getElementById("todoForm");
            form.submit();

        }
    </script>
</head>
<body>
    <h3>TO DO 등록</h3>
    <div>
        <form id="todoForm" method="POST" action="/todo_model1.jsp">
            <input type="text" name="todoName" id="todoName" value=""/>
            <input type="date" name="todoDate" id="todoDate" value=""/>
            <input type="button" id="btnReg" value="등록" onclick="registerTodo()"/>
        </form>
    </div>
    <div>
        <h4>TO DO List</h4>
        <table id="todoList">
            <thead>
                <tr>
                    <td align="center">todo name</td><td align="center">todo date</td>
                </tr>
            </thead>
						<!-- (2) 시작 --->
            <tbody>
                <c:choose>
                    <c:when test="${fn:length(todoList) == 0}">
                        <tr>
                            <td align="center" colspan="2">할 일이 없습니다.</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${todoList}" var="todo">
                            <tr>
                                <td>${todo.todoName}</td><td align="center">${todo.todoDate}</td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </tbody>
						<!-- (2) 끝 -->
        </table>
    </div>
</body>
</html>
```
</details>

위 코드는 사용자가 자신의 할일을 등록하는 화면과 등록한 할일을 목록으로 보여주는 화면을 포함한 아주 간단한 로직이다.

먼저 코드 상단의 (1) 영역은 클라이언트의 요청을 처리하는 서버쪽 코드다. 그리고 (2) 영역은 서버로부터 전달 받은 응답을 화면에 표시하기 위한 JSP에서 제공하는 jstl 태그 영역이다.
그 이외의 영역은 사용자에게 보여지는 화면을 구성하는 html 태그 및 css 스타일 코드와 할일 등록 시 유효성 검사를 실시하는 Javascript 코드 즉, 클라이언트 측에서 사용하는 기술들에 해당하는 코드다.

코드 자체가 너무 길고 복잡하여 가독성이 떨어진다는 느낌을 받을 수 있다. 실제로 이 방식은 애플리케이션의 유지 보수 측면에서 최악의 방식이다. 또한 웹 디자이너와 html 퍼블리셔, Javascript 개발자 및 Java 개발자 간에 협업하는 것이 거의 불가능한 수준이다.
이 당시에는 Front-end와 Back-end 영역을 구분하지 않고 양쪽을 모두 개발하는 경우가 많았다.

이번에는 JSP 방식 보다는 조금 더 나은 개발 방식인 `서블릿(Servlet)`을 이용한 개발 방식을 보자.

### 서블릿(Servlet)을 이용한 애플리케이션
앞서 설명한 JSP 방식 역시 내부적으로는 Servlet 방식을 사용한다. `클라이언트 웹 요청 처리에 특화된 Java 클래스의 일종이지만, Spring을 사용한 웹 요청을 처리할 때에도 내부적으로는 Servlet을 이용한다.`

여기서 Servlet을 이용한다는 것은 Servlet을 위한 Java 코드가 클라이언트 측 코드에서 별도의 Java 클래스로 관리된다는 것을 의미한다.

<details>
<summary>Servlet 방식 예제 코드</summary>

```
@WebServlet(name = "TodoServlet")
public class TodoServlet extends HttpServlet {
    // (1) Database를 대신한다.
    private List<ToDo> todoList;

    @Override
    public void init() throws ServletException {
        super.init();
        this.todoList = new ArrayList<>();
    }

		// (2)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String todoName = request.getParameter("todoName");
        String todoDate = request.getParameter("todoDate");

        todoList.add(new ToDo(todoName, todoDate));

        RequestDispatcher dispatcher = 
                request.getRequestDispatcher("/todo.jsp");
        request.setAttribute("todoList", todoList);

        dispatcher.forward(request, response);
    }

		// (3)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Hello Servlet doGet!");

        RequestDispatcher dispatcher = 
                request.getRequestDispatcher("/todo.jsp");
        dispatcher.forward(request, response);
    }
}
```
</details>

이 코드는 JSP 코드에서 Java 코드만 별도의 Servlet 클래스로 분리한 코드이다. 클라이언트 측의 JSP 코드에서 Servlet 클래스로 분리했기 때문에 클라이언트와 서버 간에 어느 정도 역할이 분리되었다고 볼 수 있다.

코드 (2)를 보면, 클라이언트 측에서 등록할 할일 데이터를 전송하면 이 요청을 받아서 데이터 저장소에 등록해주는 역할을 하는데, 여기에서는 데이터베이스 같은 별도의 저장소를 이용하지 않고 (1)과 같이 Java의 List에 추가했다.

하지만 데이터를 가공하는 비즈니스 로직이 있는 것도 아니고, 가공된 데이터를 데이터베이스에 저장하는 등의 데이터 액세스 로직 또한 존재하지 않는데도 불구하고 코드의 길이가 너무 길어보인다.

그렇다면, Spring에서는 이러한 Servlet 클래스의 코드를 어떻게 개선하는지 알아보자.

### Spring MVC를 이용한 애플리케이션

```
@Controller
public class ToDoController {
    @RequestMapping(value = "/todo", method = RequestMethod.POST)
    @ResponseBody
    public List<ToDo> todo(@RequestParam("todoName")String todoName,
                               @RequestParam("todoDate")String todoDate) {
        ToDo.todoList.add(new ToDo(todoName, todoDate));
        return ToDo.todoList;
    }

    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    @ResponseBody
    public List<ToDo> todoList() {
        return ToDo.todoList;
    }
}
```

Servlet 방식의 코드에서는 클라이언트의 요청에 담긴 데이터를 꺼내오는 작업을 개발자가 직접 코드로 작성해야 되고, charset도 지정해줘야 하는데, Spring MVC 방식의 코드에서는 그런 작업들을 Spring에서 알아서 처리해준다.
이러한 편리함에도 불구하고, `Spring 기반의 애플리케이션 기본 구조를 잡는 설정 작업이 여전히 불편하다는 단점`이 있다.

<details>
<summary>Spring MVC 설정파일 예제 코드 (web.xml)</summary>

```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/spring-config/applicationContext.xml</param-value>
    </context-param>
    <listener>
        <listener-class>
            org.springframework.web.context.ContextLoaderListener
        </listener-class>
    </listener>
    <servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>
            org.springframework.web.servlet.DispatcherServlet
        </servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/spring-config/dispatcher-servlet.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    <filter>
        <filter-name>CORSFilter</filter-name>
        <filter-class>com.codestates.filter.CORSFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>CORSFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

</web-app>
```
</details>

이 코드는 앞서 구현한 Spring 애플리케이션을 정상적으로 구동하기 위한 설정 파일들의 일부다. 이 파일 뿐만 아니라 다른 설정 파일들도 필요하다.
이러한 Spring MVC의 복잡한 설정 방식 때문에 학습을 처음 시작한 개발자들이 애플리케이션을 작동시켜보기도 이전에 지치는 경우가 많았다.
이러한 문제점들을 개선한 것이 `Spring Boot`다. 

### Spring Boot를 이용한 애플리케이션
```
@RestController
public class TodoController {
    private TodoRepository todoRepository;

    @Autowired
    TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping(value = "/todo/register")
    @ResponseBody
    public Todo register(Todo todo){ // (1)
        todoRepository.save(todo); // (2)
        return todo;
    }

    @GetMapping(value = "/todo/list")
    @ResponseBody
    public List<Todo> getTodoList(){
        return todoRepository.findAll(); // (3)
    }
}
```
이번에는 클라이언트 측에서 전달한 요청 데이터를 (1)과 같이 Todo 클래스에 담아서 한꺼번에 전달할 수 있도록 했다. 요청 데이터가 Todo 객체로 변경되는 것은 Spring이 알아서 해준다.

그리고 이전 방식에서는 클라이언트가 전달한 요청 데이터를 테스트 목적으로 단순히 List에 담았는데, 이번에는 (2), (3)과 같이 데이터베이스에 저장하여 데이터 액세스 처리까지 하도록 했다.

이렇게 데이터를 실제로 저장하는 기능을 추가했음에도 코드의 길이는 크게 바뀌지 않았고, 오히려 더 깔끔해졌다.

Spring MVC 방식에서의 복잡한 설정 방식은 어떻게 되었을까?
```
spring.h2.console.enabled=true
spring.h2.console.path=/console
spring.jpa.generate-ddl=true
spring.jpa.show-sql=true
```
Spring MVC 방식에서 겪었던 설정의 복잡함은 Spring Boot에서 깔끔하게 해결되었다. 심지어 데이터베이스를 연동하지 않았다면 이 4줄의 코드 또한 필요하지 않다.
Spring의 복잡한 설정 마저도 Spring이 대신 처리해주기 때문에 개발자는 애플리케이션의 핵심 비즈니스 로직에만 집중할 수 있게 되었다.

이제는 Spring Framework를 왜 배워야 하는지 어느 정도 이해했을 거라 믿는다.