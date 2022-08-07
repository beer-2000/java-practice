package Class7;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example5 {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, -2, 3, -5, 8, -3));
        List<Integer> result = list.stream()
            .filter((a) -> a >= 0)
            .collect(Collectors.toList())
            ;
        System.out.println(result);
    }
}
