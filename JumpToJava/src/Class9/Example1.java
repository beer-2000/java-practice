package Class9;

import java.lang.reflect.Array;

public class Example1 {
    public static void main(String[] args) {
        String input = "a:b:c:d";
        String result = String.join("#", input.split(":"));
        System.out.println(result);
    }
}
