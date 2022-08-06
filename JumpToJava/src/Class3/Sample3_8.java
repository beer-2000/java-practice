package Class3;

import java.util.HashMap;

public class Sample3_8 {
    public static void main(String[] args){
        HashMap<String, String> map = new HashMap<>();
        map.put("people", "사람");
        map.put("baseball", "야구");

        System.out.println(map.get("people"));
        System.out.println(map.get("java"));
        System.out.println(map.getOrDefault("java", "자바"));
        System.out.println(map.keySet());
    }
}