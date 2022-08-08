package Class9;

import java.util.ArrayList;
import java.util.Arrays;

public class Example3 {
    public static void main(String[] args)  {
        int[] A = {20, 55, 67, 82, 45, 33, 90, 87, 100, 25};
        int result = Arrays.stream(A)
            .filter((a) -> a >= 50)
            .sum()
            ;
        System.out.println(result);
    }
}