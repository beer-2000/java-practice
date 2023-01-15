package chapter5;

import java.util.Scanner;

public class example2 {
    //--- 정수 x, y의 최대공약수를 구하여 반환 ---//
    static int gcd(int x, int y) {
        int a = x;
        int b = y;
        int temp;
        while (true) {
            if (a % b == 0) {
                return b;
            }
            temp = a % b;
            a = b;
            b = temp;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("두 정수의 최대공약수를 구합니다.");

        System.out.print("정수를 입력하세요 : ");  int x = stdIn.nextInt();
        System.out.print("정수를 입력하세요 : ");  int y = stdIn.nextInt();

        System.out.println("최대공약수는 " + gcd(x, y) + "입니다.");
    }
}
