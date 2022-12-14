package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private List<Product> products;
    private final String ERROR_MESSAGE_NOT_FOUND_PRODUCT = "[ERROR] 존재하지 않는 상품명입니다.";

    public Products() {
        this.products = new ArrayList<>();
    }

    public void addProducts(List<ProductInfo> productInfos) {
        productInfos.forEach(productInfo -> {
            products.add(new Product(
                    productInfo.getName(),
                    productInfo.getPrice(),
                    productInfo.getCount())
            );
        });
    }

    public boolean canPurchaseBy(int money) {
        for (Product product : products) {
            if (product.canPurchase(money) && product.isNotEmpty()) {
                return true;
            }
        }
        return false;
    }

    public int getPriceOf(String productName) {
        return products.stream()
                .filter(product -> product.isNameOf(productName))
                .mapToInt(Product::getPrice)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_NOT_FOUND_PRODUCT));
    }

    public void purchase(String productName) {
        products.stream()
                .filter(product -> product.isNameOf(productName))
                .forEach(Product::minusCount);
    }
}
