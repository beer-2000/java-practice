package chapter5;// 재귀에 대한 이해를 돕는 순수 재귀 메서드

import java.util.Scanner;

class example4 {
    //--- 순수 재귀 메서드 ---//
    static void recur2(int n) {
        if (n > 0) {
            recur2(n - 2);
            System.out.println(n);
            recur2(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();

        recur2(x);
    }
}
