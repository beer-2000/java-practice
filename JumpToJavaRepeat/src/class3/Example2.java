package class3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Example2 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>(Arrays.asList("Life", "is", "too", "short"));
        String str = String.join(" ", myList);
        System.out.println(str);
    }
}
