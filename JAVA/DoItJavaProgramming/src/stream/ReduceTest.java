package stream;

import java.util.Arrays;
import java.util.function.BinaryOperator;

class CompareString implements BinaryOperator<String> {             // BinaryOperator 를 구현한 클래스 정의
    @Override
    public String apply(String s1, String s2) {
        if(s1.getBytes().length >= s2.getBytes().length) return s1;
        else return s2;
    }
}

public class ReduceTest {
    public static void main(String[] args) {

        String[] greetings = {"안녕~~~~~~~~~", "hi", "Good afternoon", "반가워~~"};
        System.out.println(Arrays.stream(greetings).reduce("", (s1, s2) -> {
            if(s1.getBytes().length >= s2.getBytes().length)
                return s1;
            else return s2;     // 람다식 직접 구현
        }));

        String str = Arrays.stream(greetings).reduce(new CompareString()).get();
        System.out.println(str);    // BinaryOperator 를 구현한 클래스 사용
    }
}
