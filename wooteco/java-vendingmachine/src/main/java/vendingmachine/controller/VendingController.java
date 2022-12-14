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
    private final String ERROR_MESSAGE_WRONG_PRODUCT_INFO_RAW =
            "[ERROR] 상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분해주세요";
    private final String ERROR_MESSAGE_WRONG_PRODUCT_COUNT_OR_PRICE = "[ERROR] 가격, 수량은 숫자만 입력해주세요.";

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
        while (true) {
            try {
                List<ProductInfo> productInfos = convertToProductInfosByRaw(inputView.readProducts());
                vendingMachine.registerProducts(productInfos);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<ProductInfo> convertToProductInfosByRaw(String productInfosRaw) {
        List<ProductInfo> productInfos = new ArrayList<>();
        Arrays.stream(productInfosRaw.split(";"))
                .forEach(productInfoRaw -> productInfos.add(createProductInfoByRaw(productInfoRaw)));
        return productInfos;
    }

    private ProductInfo createProductInfoByRaw(String productInfoRaw) {
        validateProductInfoRaw(productInfoRaw);
        String[] productInfoBeforeParsing = productInfoRaw
                .replace("[", "")
                .replace("]", "")
                .split(",");
        String name = productInfoBeforeParsing[0];
        try {
            int price = Integer.parseInt(productInfoBeforeParsing[1]);
            int count = Integer.parseInt(productInfoBeforeParsing[2]);
            return new ProductInfo(name, price, count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_WRONG_PRODUCT_COUNT_OR_PRICE);
        }
    }

    private void validateProductInfoRaw(String productInfoRaw) {
        if (productInfoRaw.contains("[") && productInfoRaw.contains("]")) {
            return;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE_WRONG_PRODUCT_INFO_RAW);
    }
}
