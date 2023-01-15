package chapter5;

public class example3 {
    public static void main(String[] args) {
        int[] numbers = {120, 180, 260, 330, 275};
        System.out.println(gcdArray(numbers));
    }

    static private int gcdArray(int[] numbers) {
        int gcd = gcd(numbers[0], numbers[1]);
        if (numbers.length == 2) {
            return gcd;
        }
        for (int i = 2; i < numbers.length; i++) {
            gcd = gcd(numbers[i], gcd);
        }
        return gcd;
    }

    static private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}
