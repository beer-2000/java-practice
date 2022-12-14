package vendingmachine.domain;

public class Product {
    private String name;
    private int price;
    private int count;
    private final String ERROR_MESSAGE_ZERO_PRODUCT = "[ERROR] 해당 상품의 재고가 없습니다.";

    public Product(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public boolean canPurchase(int money) {
        return money >= price;
    }

    public boolean isNameOf(String name) {
        return this.name.equals(name);
    }

    public void minusCount() {
        if (count > 0) {
            count -= 1;
            return;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE_ZERO_PRODUCT);
    }

    public boolean isNotEmpty() {
        return count > 0;
    }
}
