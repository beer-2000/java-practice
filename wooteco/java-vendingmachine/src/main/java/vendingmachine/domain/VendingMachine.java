package vendingmachine.domain;

import java.util.List;

public class VendingMachine {
    private Products products;
    private CoinMachine coinMachine;
    private int inputMoney;
    private final String ERROR_MESSAGE_NOT_ENOUGH_MONEY = "[ERROR] 금액이 부족합니다. (%s: %d원)";

    public VendingMachine(int moneyOfVendingMachine) {
        this.products = new Products();
        this.coinMachine = new CoinMachine(moneyOfVendingMachine);
    }

    public List<CoinInfo> getCoinCountInfo() {
        return coinMachine.getCoinCountInfo();
    }

    public void registerProducts(List<ProductInfo> productInfos) {
        products.addProducts(productInfos);
    }

    public void setInputMoney(int inputMoney) {
        this.inputMoney = inputMoney;
    }

    public boolean canPurchase() {
        return products.canPurchaseBy(inputMoney);
    }

    public int getInputMoney() {
        return inputMoney;
    }

    public void purchase(String productName) {
        int price = products.getPriceOf(productName);
        if (inputMoney >= price) {
            products.purchase(productName);
            inputMoney -= price;
            return;
        }
        throw new IllegalArgumentException(
                String.format(ERROR_MESSAGE_NOT_ENOUGH_MONEY, productName, price)
        );
    }

    public List<CoinInfo> getCoinCountInfoOfChanges() {
        return coinMachine.getCoinCountInfoOfChanges(inputMoney);
    }
}
