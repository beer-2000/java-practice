package vendingmachine.domain;

import java.util.Objects;

public class ProductInfo {
    private String name;
    private int price;
    private int count;

    public ProductInfo(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ProductInfo productInfo = (ProductInfo) o;
        return name == productInfo.name &&
                price == productInfo.price &&
                count == productInfo.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, count);
    }
}

