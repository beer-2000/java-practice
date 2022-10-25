package class3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Sample9 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>(Arrays.asList("H", "e", "l", "l", "o"));
        System.out.println(set);
        final ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b"));
        System.out.println(list);
        list.add("c");
        System.out.println(list);
//        list = new ArrayList<>(Arrays.asList("b")); // 컴파일 에러 발생!
    }
}
