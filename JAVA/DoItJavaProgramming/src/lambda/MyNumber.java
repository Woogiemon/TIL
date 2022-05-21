package lambda;

@FunctionalInterface    // 함수형 인터페이스라는 의미, 메서드를 하나 이상 선언하면 오류 발생
public interface MyNumber {
    int getMax(int num1, int num2);     // 추상 메서드 선언
}
