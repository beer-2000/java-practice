package vendingmachine.domain;

public class VendingMachine {
    private Products products;
    private CoinMachine coinMachine;
    private int inputMoney;

    public VendingMachine(int moneyOfVendingMachine) {
        this.coinMachine = new CoinMachine(moneyOfVendingMachine);
    }
}
