package lambda;

import java.util.Arrays;

public class TestMyNumber {
    public static void main(String[] args) {
//        MyNumber max = (x, y) -> (x >= y) ? x : y;      // 람다식을 인터페이스형 max 변수에 대입
//        System.out.println(max.getMax(10, 20));         // 인터페이스형 변수로 메서드 호출
//        int[] arr1 = {11, 22, 33, 44, 55};
//        for(int i : arr1) {
//            System.out.println(i);             // {11, 22, 33, 44, 55}
//        }
//
//        int[] arr2 = Arrays.copyOf(arr1, 4);
//        for(int i : arr2) {
//            System.out.println(i);
//        }
//
//        int[] arr3= Arrays.copyOfRange(arr1, 3, 4);
//        for(int i : arr3) {
//            System.out.println(i);
//        }

        System.out.printf("%s%n", "JAVA Programming");
        System.out.printf("%s%n", "Lee" + "JIN");
        System.out.printf("%d%n", 15 + 12);
        System.out.printf("지금은 %s입니다.%n", 2022 + "year");   // 자동 타입 변환
        System.out.printf("저는 %c%s입니다", '김', "철수");        // 한번에 여러개의 인자를 넣을 수 있다
    }
}
