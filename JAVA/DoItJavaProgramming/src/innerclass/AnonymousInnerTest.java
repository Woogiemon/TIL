package innerclass;

class Outer2 {
    Runnable getRunnable(int i) {
        int num = 100;

        return new Runnable() {                 // 1. 익명 내부 클래스. 메서드 내부에서 Runnable 인터페이스 생성
            @Override
            public void run() {
                System.out.println(i);
                System.out.println(num);
                System.out.println();
            }
        };                                      // 클래스 끝에 ;를 씀
    }

    Runnable runner = new Runnable() {          // 2. 익명 내부 클래스를 변수에 직접 대입
        @Override
        public void run() {
            System.out.println("Runnable이 구현된 익명 클래스 변수");
        }
    };
}

public class AnonymousInnerTest {
    public static void main(String[] args) {

        Outer2 out = new Outer2();
        Runnable runnable = out.getRunnable(10);
        runnable.run();
        out.runner.run();
    }
}
