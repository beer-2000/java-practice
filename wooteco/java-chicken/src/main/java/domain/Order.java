package domain;

import java.util.List;
import java.util.Map;

public class Order {
    private Map<Menu, Integer> sheet;

    public Order(List<Menu> menus) {
        menus.forEach(menu -> {
            sheet.put(menu, 0);
        });
    }

    public void add(Menu menu, int menuCount) {
        int countBeforeAdd = sheet.get(menu);
        sheet.put(menu, countBeforeAdd + menuCount);
    }

    public boolean haveOrder() {
        int sumOfCount = sheet.values().stream()
                .mapToInt(number -> number)
                .sum();
        return sumOfCount != 0;
    }
}
