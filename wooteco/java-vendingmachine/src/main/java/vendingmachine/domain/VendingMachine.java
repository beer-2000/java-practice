package vendingmachine.domain;

import java.util.List;

public class VendingMachine {
    private Products products;
    private CoinMachine coinMachine;
    private int inputMoney;

    public VendingMachine(int moneyOfVendingMachine) {
        this.coinMachine = new CoinMachine(moneyOfVendingMachine);
    }

    public List<CoinInfo> getCoinCountInfo() {
        return coinMachine.getCoinCountInfo();
    }
}
