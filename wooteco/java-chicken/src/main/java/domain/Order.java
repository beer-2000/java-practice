package domain;

import static constant.HofRule.CHICKEN_SALE_STANDARD;
import static constant.HofRule.MAXIMUM_ORDER;
import static constant.HofRule.SALE_PRICE_FOR_MANY_CHICKEN;
import static constant.HofRule.SALE_RATIO_FOR_CASH;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private Map<Menu, Integer> sheet;
    private final String ERROR_MESSAGE_TOO_MANY_ORDER = "[ERROR] 계산 전 한 메뉴 당 99개까지만 주문할 수 있습니다. 현재 %s의 주문 개수는 %d개입니다.";

    public Order(List<Menu> menus) {
        reset(menus);
    }

    public void add(Menu menu, int menuCount) {
        int countBeforeAdd = sheet.get(menu);
        if (countBeforeAdd + menuCount > MAXIMUM_ORDER) {
            throw new IllegalArgumentException(
                    String.format(ERROR_MESSAGE_TOO_MANY_ORDER, menu.getName(), countBeforeAdd));
        }
        sheet.put(menu, countBeforeAdd + menuCount);
    }

    public boolean haveOrder() {
        int sumOfCount = sheet.values().stream()
                .mapToInt(number -> number)
                .sum();
        return sumOfCount != 0;
    }

    public Map<Menu, Integer> getSheet() {
        return sheet;
    }

    public int calculateTotalPrice(int payType) {
        int totalPrice;
        int totalPriceBeforeSale = getTotalPriceBeforeSale();
        int countOfChicken = getCountOfChicken();
        totalPrice = totalPriceBeforeSale - (SALE_PRICE_FOR_MANY_CHICKEN * (countOfChicken / CHICKEN_SALE_STANDARD));
        if (payType == 2) {
            totalPrice *= SALE_RATIO_FOR_CASH;
        }
        return totalPrice;
    }

    private int getCountOfChicken() {
        return sheet.keySet().stream()
                .mapToInt(menu -> {
                    if (menu.isChicken()) {
                        return sheet.get(menu);
                    }
                    return 0;
                })
                .sum();
    }

    private int getTotalPriceBeforeSale() {
        return sheet.keySet().stream()
                .mapToInt(menu -> {
                    return menu.getPrice() * sheet.get(menu);
                })
                .sum();
    }

    public void reset(List<Menu> menus) {
        sheet = new LinkedHashMap<Menu, Integer>();
        menus.forEach(menu -> {
            sheet.put(menu, 0);
        });
    }
}
