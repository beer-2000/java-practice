package Class9;

import java.util.ArrayList;

public class Example4 {
    public static void main(String[] args)  {
        int limit = 20;
        ArrayList<Integer> fibonacci = new ArrayList<>();

        int prev = 0;
        int next = 1;
        int temp;
        while(prev < limit) {
            fibonacci.add(prev);
            temp = prev;
            prev = next;
            next += temp;
        }
        System.out.println(fibonacci);
    }
}