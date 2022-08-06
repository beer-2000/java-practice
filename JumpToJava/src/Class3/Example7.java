package Class3;

import java.util.ArrayList;
import java.util.Arrays;

public class Example7 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>(Arrays.asList("Life", "is", "too", "short"));
        System.out.println(myList);

        System.out.println(String.join(" ", myList));
    }
}
