package chapter3;

import java.util.Arrays;

public class Example3 {
    public static void main(String[] args) {
        int[] numbers = {1, 9, 2, 9, 4, 6, 7, 9};
        int key = 9;
        int[] indexes = new int[numbers.length];
        int countOfKey = searchIndex(numbers, key, indexes);
        System.out.printf("%s에 %d는 %d개 존재합니다.", Arrays.toString(numbers), key, countOfKey);
    }

    private static int searchIndex(int[] numbers, int key, int[] indexes) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == key) {
                indexes[count] = i;
                count += 1;
            }
        }
        return count;
    }
}
