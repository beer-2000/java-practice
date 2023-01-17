package chapter02;

import java.util.Arrays;
import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("배열 길이: ");
        int num = scanner.nextInt();

        int[] numbers = new int[num];
        int[] numbersCopy = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.printf("%d번째 수: ", i);
            numbers[i] = scanner.nextInt();
        }

        copy(numbersCopy, numbers);

        System.out.printf("numbers = %s", Arrays.toString(numbers));
        System.out.println();
        System.out.printf("numbersCopy = %s", Arrays.toString(numbersCopy));
        System.out.println();
    }

    private static void copy(int[] numbersCopy, int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbersCopy[i] = numbers[i];
        }
    }
}
