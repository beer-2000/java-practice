package Class3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Example6 {
    public static void main(String[] args) {
        ArrayList<Integer> myList = List.of(1,2,3,4,5);
        System.out.println(myList);

        myList.sort(Comparator.reverseOrder());
        System.out.println(myList);
    }
}
