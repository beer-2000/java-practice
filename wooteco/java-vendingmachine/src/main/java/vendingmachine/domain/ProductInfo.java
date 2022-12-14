package vendingmachine.domain;

import java.util.Objects;

public class ProductInfo {
    private String name;
    private int price;
    private int count;
    private final String ERROR_MESSAGE_PRICE_NOT_MULTIPLE_OF_10 = "[ERROR] 상품 가격은 10원의 배수여야 합니다.";

    public ProductInfo(String name, int price, int count) {
        validatePrice(price);
        this.name = name;
        this.price = price;
        this.count = count;
    }

    private void validatePrice(int price) {
        if (!(price % 10 == 0)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PRICE_NOT_MULTIPLE_OF_10);
        }
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

