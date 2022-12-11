package domain;

import java.util.Map;
import repository.MenuRepository;

public class Table {
    private final int number;
    private Order order;

    public Table(final int number) {
        this.number = number;
        this.order = new Order(MenuRepository.menus());
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void addOrder(Menu menu, int menuCount) {
        order.add(menu, menuCount);
    }

    public boolean haveOrder() {
        return order.haveOrder();
    }

    public boolean isNumberOf(int tableNumber) {
        return number == tableNumber;
    }

    public Map<Menu, Integer> getOrderSheet() {
        return order.getSheet();
    }

    public int calculateTotalPrice(int payType) {
        return order.calculateTotalPrice(payType);
    }

    public void resetOrder() {
        order.reset(MenuRepository.menus());
    }
}
