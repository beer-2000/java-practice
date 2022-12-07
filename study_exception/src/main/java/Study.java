import java.util.InputMismatchException;
import java.util.Scanner;

public class Study {
    private int count = 0;
    public void multiple() {
        try {
            int number = readNumber();
            System.out.printf("%d에 2를 곱하면 %d 입니다.", number, number * 2);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            multiple();
        }
        count ++;
        System.out.println(count);
    }

    private int readNumber() {
        try {
            System.out.print("숫자를 입력해주세요 : ");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            return number;
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }

    }
}
