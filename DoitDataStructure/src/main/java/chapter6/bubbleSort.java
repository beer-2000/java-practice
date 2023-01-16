package chapter6;

public class bubbleSort {
    public static void main(String[] args) {
        int[] numbers = {9, 8, 7, 5, 4, 3, 1, 2};
        bubbleSort(numbers, 0, numbers.length);
        for (int number: numbers) {
            System.out.print(number + " ");
        }
    }

    private static void bubbleSort(int[] numbers, int start, int n) {
        int temp;
        for (int i = start; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (numbers[n - 1 - j] < numbers[n - 1 - j - 1]) {
                    temp = numbers[n - 1 - j];
                    numbers[n - 1 - j] = numbers[n - 1 - j - 1];
                    numbers[n - 1 - j - 1] = temp;
                }
                for (int number: numbers) {
                    System.out.print(number + " ");
                }
                System.out.println();
            }
            System.out.println("------");
        }
    }
}
