package chapter01;

import java.util.Scanner;

public class Example15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("숫자를 입력하세요 : ");
        n = scanner.nextInt();
        while (n <= 0) {
            System.out.println("0보다 큰 수를 입력하세요");
            System.out.print("숫자를 입력하세요 : ");
            n = scanner.nextInt();
        }

        spira(n);
    }

    private static void spira(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(' ');
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print('*');
            }
            for (int j = 1; j <= n - i; j++) {
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
