package Class7;

import java.util.ArrayList;
import java.util.Arrays;

public class Example4 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int[] result = Arrays.stream(numbers)
                .filter((a) -> a % 2 == 1)
                .map((a) -> a * 2)
                .toArray()
                ;
//        ArrayList<Integer> output = Arrays.asList(result);
        System.out.println(result[0]);
    }
}
