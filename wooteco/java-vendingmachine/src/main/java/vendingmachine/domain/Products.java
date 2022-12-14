package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private List<Product> products;

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
}
