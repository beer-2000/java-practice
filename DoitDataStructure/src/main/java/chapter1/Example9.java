package chapter1;

import java.util.Scanner;

public class Example9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("a값: ");
        int a = scanner.nextInt();
        System.out.print("b값: ");
        int b;
        b = scanner.nextInt();
        while (b <= a) {
            System.out.println("a보다 큰 값을 입력하세요!!");
            System.out.print("b값: ");
            b = scanner.nextInt();
        }
        System.out.printf("%d - %d는 %d입니다.", b, a, b - a);
    }
}
