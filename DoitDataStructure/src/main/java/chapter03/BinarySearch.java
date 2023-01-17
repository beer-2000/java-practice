package chapter03;

public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 6, 9, 13, 17, 22, 37, 105};
        System.out.println(binarySearch(numbers, 22));
    }

    private static int binarySearch(int[] numbers, int key) {
        int pl = 0;
        int pr = numbers.length - 1;
        int pc;

        do {
            pc = (pl + pr) / 2;
            if (numbers[pc] == key) {
                return pc;
            }
            else if (numbers[pc] < key) {
                pl = pc + 1;
            }
            else {
                pr = pc -1;
            }
        } while (pl <= pr);
        return -1;
    }
}
