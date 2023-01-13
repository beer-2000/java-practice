package chapter1;

import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("a값: ");
        int a = scanner.nextInt();
        while (a <= 0) {
            System.out.println("0보다 큰 값을 입력하세요!!");
            System.out.print("a값: ");
            a = scanner.nextInt();
        }

        int digit = 0;
        int num = a;
        while (num > 0) {
            digit += 1;
            num /= 10;
        }

        System.out.printf("%d의 자릿수는 %d입니다.", a, digit);
    }
}
