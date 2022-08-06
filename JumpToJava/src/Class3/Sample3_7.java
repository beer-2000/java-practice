package Class3;

import java.util.ArrayList;
import java.util.Comparator;

public class Sample3_7 {
    public static void main(String[] args) {
        ArrayList<String> pitches = new ArrayList<>();
        pitches.add("138");
        pitches.add("129");
        pitches.add("142");

        ArrayList mix = new ArrayList();
        mix.add("hello");
        mix.add(1);

        String result = "";
        for (int i = 0; i < pitches.size(); i++) {
            result += pitches.get(i);
            result += ", ";
        }
        result = result.substring(0, result.length() - 2);
        System.out.println(pitches);
        System.out.println(result);

        useJoin();
    }

    public static void useJoin() {
        System.out.println("Start useJoin >>>>>>");
        ArrayList<String> pitches = new ArrayList<>();
        pitches.add("138");
        pitches.add("129");
        pitches.add("142");

        pitches.sort(Comparator.naturalOrder());

        System.out.println(pitches);
        System.out.println(String.join(", ", pitches));

    }
}