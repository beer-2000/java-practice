package vendingmachine.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import vendingmachine.domain.ProductInfo;
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
        registerProducts();
    }

    private void generateVendingMachine() {
        while (true) {
            try {
                int moneyOfVendingMachine = inputView.readMoneyOfVendingMachine();
                this.vendingMachine = new VendingMachine(moneyOfVendingMachine);
                outputView.printCoinCount(vendingMachine.getCoinCountInfo());
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void registerProducts() {
        List<ProductInfo> productInfos = convertToProductInfosByRaw(inputView.readProducts());
        vendingMachine.registerProducts(productInfos);
    }

    private List<ProductInfo> convertToProductInfosByRaw(String productInfosRaw) {
        List<ProductInfo> productInfos = new ArrayList<>();
        Arrays.stream(productInfosRaw.split(";"))
                .forEach(productInfoRaw -> productInfos.add(createProductInfoByRaw(productInfoRaw)));
        return productInfos;
    }

    private ProductInfo createProductInfoByRaw(String productInfoRaw) {
        String[] productInfoBeforeParsing = productInfoRaw
                .replace("[", "")
                .replace("]", "")
                .split(",");
        String name = productInfoBeforeParsing[0];
        int price = Integer.parseInt(productInfoBeforeParsing[1]);
        int count = Integer.parseInt(productInfoBeforeParsing[2]);
        return new ProductInfo(name, price, count);
    }
}
