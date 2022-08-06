package Class3;

import java.util.Arrays;
import java.util.HashSet;

public class Sample3_9 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>(Arrays.asList("H", "e", "l", "l", "o"));
        System.out.println(set);

        HashSet<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        HashSet<Integer> s2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));

        HashSet<Integer> resultIntersection = new HashSet<>(s1);
        resultIntersection.retainAll(s2);
        HashSet<Integer> resultUnion = new HashSet<>(s1);
        resultUnion.addAll(s2);
        HashSet<Integer> resultSubstract = new HashSet<>(s1);
        resultSubstract.removeAll(s2);
        System.out.println(resultIntersection);
        System.out.println(resultUnion);
        System.out.println(resultSubstract);
    }
}