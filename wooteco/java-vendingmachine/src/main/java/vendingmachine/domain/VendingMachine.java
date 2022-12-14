package vendingmachine.domain;

import java.util.List;

public class VendingMachine {
    private Products products;
    private CoinMachine coinMachine;
    private int inputMoney;

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
}
