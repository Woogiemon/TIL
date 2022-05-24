package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TravelTest {
    public static void main(String[] args) {

        TravelCustomer customerL = new TravelCustomer("L", 40, 100);
        TravelCustomer customerJ = new TravelCustomer("J", 20, 300);
        TravelCustomer customerW = new TravelCustomer("W", 13, 500);    // 고객 생성
        List<TravelCustomer> customerList = new ArrayList<>();

        customerList.add(customerL);
        customerList.add(customerJ);
        customerList.add(customerW);        // ArrayList에 고객 추가

        System.out.println("== 고객 명단 추가된 순서대로 출력 ==");
        customerList.stream().map(c -> c.getName()).forEach(s -> System.out.println(s));

        int total = customerList.stream().mapToInt(c -> c.getPrice()).sum();
        System.out.println("총 여행 비용은 :" + total + "입니다");

        System.out.println();

        System.out.println("== 20세 이상 고객 명단 정렬하여 출력 ==");
        customerList.stream().filter(c -> c.getAge() >= 20)
                .map(c -> c.getName()).sorted().forEach(s -> System.out.println(s));
    }
}
