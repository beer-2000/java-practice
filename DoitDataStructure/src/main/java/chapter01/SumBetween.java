package chapter01;

import java.util.Scanner;

public class SumBetween {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("첫번째 숫자를 입력하세요: ");
        int a = scanner.nextInt();
        System.out.print("두번째 숫자를 입력하세요: ");
        int b = scanner.nextInt();

        System.out.printf("%d부터 %d 까지의 합은 %d입니다", a, b, sumBetween(a, b));
    }

    static int sumBetween(int a, int b) {
        int sum = 0;
        for (int i = a; i <= b; i++) {
            System.out.println(i);
            sum += i;
        }
        return sum;
    }
}
