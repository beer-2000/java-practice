package chapter01;

import java.util.Scanner;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");
        int n = scanner.nextInt();

        System.out.printf("1부터 %d 까지의 합은 %d입니다", n, getSumUntil(n));
    }

    static int getSumUntil(int n) {
        return (1 + n) * n / 2;
    }
}
