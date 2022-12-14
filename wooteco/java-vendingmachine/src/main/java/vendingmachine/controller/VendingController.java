package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.ui.InputView;
import vendingmachine.ui.OutputView;

public class VendingController {
    private InputView inputView;
    private OutputView outputView;
    private VendingMachine vendingMachine;

    public VendingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        generateVendingMachine();
    }

    private void generateVendingMachine() {
        int moneyOfVendingMachine = inputView.readMoneyOfVendingMachine();
        this.vendingMachine = new VendingMachine(moneyOfVendingMachine);
    }
}
