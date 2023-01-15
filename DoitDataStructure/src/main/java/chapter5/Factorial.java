package chapter5;// 팩토리얼 값을 재귀적으로 구함

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Factorial {
    private static List<Integer> stack = new ArrayList<>();

    //--- 음이 아닌 정수 n의 팩토리얼 값을 반환 ---//
    static int factorial(int n) {
        stack.add(n);
        stack.remove(n);
        System.out.println(stack);
        if (n > 0)
            return n * factorial(n - 1);
        else
            return 1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();

        System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
    }
}