package lambda;

public class TestStringConcat {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "JAVA";

        StringConcatImpl concat1 = new StringConcatImpl();
        concat1.makeString(s1, s2);

        // 람다식으로 인터페이스를 구현할 때 클래스를 따로 생성할 필요 없이 바로 메서드를 구현한다.
        StringConcat concat2 = (s, v) -> System.out.println(s + "," + v);
        concat2.makeString(s1, s2);
    }
}
