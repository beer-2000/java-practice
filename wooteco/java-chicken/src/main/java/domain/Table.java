package domain;

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
}
