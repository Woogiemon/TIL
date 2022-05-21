package innerclass;

class Outer {
    int outNum = 100;
    static int sNum = 200;

    Runnable getRunnable(int i) {
        int num = 100;                              // 지역 변수

        class MyRunnable implements Runnable {      // 지역 내부 클래스
            int localNum = 10;                      // 지역 내부 클래스의 인스턴스 변수

            @Override
            public void run() {
                // num = 200;
                // i = 100;                         // 지역 내부 클래스에서 사용하는 메서드의 지역 변수는 모두 상수로 바뀌므로 값을 변경할 수 없다.
                System.out.println("i = " + i);
                System.out.println("num = " + num);
                System.out.println("localNum = " + localNum);
                System.out.println("outNum = " + outNum + " (외부 클래스 인스턴스 변수)");
                System.out.println("Outer.sNum = " + Outer.sNum + " (외부 클래스 정적 변수)");
            }
        }
        return new MyRunnable();    // 지역 내부 클래스 이름은 클래스를 생성하여 반환할 때만 사용 >> 익명 클래스!!
    }
}

public class LocalInnerTest {
    public static void main(String[] args) {

        Outer outer = new Outer();
        Runnable runner = outer.getRunnable(10);
        runner.run();
        // MyRunnable 을 사용하려면 이 클래스를 직접 생성하는 것이 아니라 getRunnable() 메서드 호출을 통해 생성된 객체를 반환받아야 한다.
    }

}
