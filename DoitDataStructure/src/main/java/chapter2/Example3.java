package chapter2;

import java.util.Arrays;
import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("배열 길이: ");
        int num = scanner.nextInt();

        int[] numbers = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.printf("%d번째 수: ", i);
            numbers[i] = scanner.nextInt();
        }

        System.out.println("sum = " + sumOf(numbers));
    }

    private static int sumOf(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
