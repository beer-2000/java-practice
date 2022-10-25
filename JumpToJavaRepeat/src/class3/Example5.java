package class3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Example5 {
    enum Coffee {
        AMERICANO,
        ICE_AMERICANO,
        CAFE_LATTE,

    }
    static void printCoffeePrice(Coffee type) {
        HashMap<Coffee, Integer> priceMap = new HashMap<>();
        priceMap.put(Coffee.AMERICANO, 3000);  // 1: 아메리카노
        priceMap.put(Coffee.ICE_AMERICANO, 4000);  // 2: 아이스 아메리카노
        priceMap.put(Coffee.CAFE_LATTE, 5000);  // 3: 카페라떼
        int price = priceMap.get(type);
        System.out.println(String.format("가격은 %d원 입니다.", price));
    }

    public static void main(String[] args) {
        printCoffeePrice(Coffee.AMERICANO);  // "가격은 3000원 입니다." 출력
//        printCoffeePrice(99);  // NullPointerException 발생
    }
}
