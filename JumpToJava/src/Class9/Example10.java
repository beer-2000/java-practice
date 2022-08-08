package Class9;
import java.util.Random;

class OddException extends Exception {
}

public class Example10 {
    static void execute(int n) {
        System.out.printf("입력 숫자: %d\n", n);
        try {
            if (n % 2 == 1) {  // 홀수이면 OddException이 발생한다.
                throw new OddException();
            }
        } catch (OddException e) {
            e.printStackTrace();
        }
        System.out.println("짝수입니다.");
    }

    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            execute(r.nextInt(10));
        }
    }
}