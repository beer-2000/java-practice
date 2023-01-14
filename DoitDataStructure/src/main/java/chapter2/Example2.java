package chapter2;

import java.util.Arrays;
import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("배열 길이: ");
        int num = scanner.nextInt();

        int[] numbers = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.printf("%d번째 수: ", i);
            numbers[i] = scanner.nextInt();
        }

        reverse(numbers);

        System.out.println("요소 역순 정렬 완료");
        System.out.println("numbers = " + Arrays.toString(numbers));
    }

    private static void reverse(int[] numbers) {
        for (int i = 0; i < numbers.length / 2; i++) {
            swap(numbers, i, numbers.length - i - 1);
        }
    }

    private static void swap(int[] numbers, int index1, int index2) {
        System.out.printf("numbers[%d]와 numbers[%d]를 교환합니다.", index1, index2);
        System.out.println();
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
        System.out.printf("numbers = %s", Arrays.toString(numbers));
        System.out.println();
    }
}
