package class3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Sample7 {
    public static void main(String[] args) {
        String[] pitchesArray = new String[]{"138", "129", "142"};
        ArrayList<String> pitchesList = new ArrayList<>(Arrays.asList(pitchesArray));
        pitchesList.sort(Comparator.naturalOrder());
        String resultOfArray = String.join(", ", pitchesArray);
        String resultOfList = String.join(", ", pitchesList);
        System.out.println(resultOfArray);
        System.out.println(resultOfList);
        System.out.println(pitchesList);

    }
}
