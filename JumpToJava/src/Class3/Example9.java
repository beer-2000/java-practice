package Class3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Example9 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5));
        System.out.println(numbers);
        HashSet<Integer> set = new HashSet<>(numbers);
        ArrayList newNumbers = new ArrayList<>(set);

        System.out.println(newNumbers);
    }
}
