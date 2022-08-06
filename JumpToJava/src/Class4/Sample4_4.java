package Class4;

public class Sample4_4 {
    public static void main(String[] args) {
        String[] numbers = {"one", "two", "three"};
        for (int i=0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        for (String number: numbers) {
            System.out.println(number);
        }
    }
}
