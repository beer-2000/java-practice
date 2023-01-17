package chapter01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("중앙값을 구합니다.");
        System.out.print("a의 값: ");
        int a = scanner.nextInt();
        System.out.print("b의 값: ");
        int b = scanner.nextInt();
        System.out.print("c의 값: ");
        int c = scanner.nextInt();

        System.out.println("중앙값은 " + getMedianOf(a, b, c) + "입니다");

    }

    private static int getMedianOf(int a, int b, int c) {
        if (a >= b) {
            if (b >= c) {
                return b;
            } else if (c >= a) {
                return a;
            } else {
                return c;
            }
        } else {
            if (b <= c) {
                return b;
            } else if (c <= a) {
                return a;
            } else {
                return c;
            }
        }
    }
}
