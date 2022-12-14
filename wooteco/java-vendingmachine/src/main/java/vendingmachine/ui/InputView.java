package vendingmachine.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String REQUEST_MONEY_OF_VENDING_MACHINE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private final String ERROR_MESSAGE_MONEY_SHOULD_BE_NUMBER = "[ERROR] 숫자를 입력해주세요.";
    private final String REQUEST_PRODUCT_INFO = "상품명과 가격, 수량을 입력해 주세요.";

    public int readMoneyOfVendingMachine() {
        try {
            System.out.println(REQUEST_MONEY_OF_VENDING_MACHINE);
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MONEY_SHOULD_BE_NUMBER);
        }
    }

    public String readProducts() {
        System.out.println(REQUEST_PRODUCT_INFO);
        return Console.readLine();

    }
}
