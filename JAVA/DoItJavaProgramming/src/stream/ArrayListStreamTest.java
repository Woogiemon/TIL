package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListStreamTest {
    public static void main(String[] args) {

        List<String> sList = new ArrayList<>();
        sList.add("LEE");
        sList.add("JIN");
        sList.add("WOOK");

        Stream<String> stream = sList.stream();                // 스트림 생성
        stream.forEach(s -> System.out.println(s + " "));      // 배열의 요소를 하나씩 출력
        System.out.println();

        sList.stream().sorted().forEach(s -> System.out.println(s));
        // 스트림 새로 생성     정렬      요소를 하나씩 꺼내어 출력
    }
}
