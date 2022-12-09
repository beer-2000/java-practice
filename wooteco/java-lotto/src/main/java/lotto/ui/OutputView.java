package lotto.ui;

import java.util.List;

public class OutputView {
    private String REQUEST_INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    private String ANNOUNCEMENT_PURCHASE_COUNT = "%d개를 구매했습니다.";
    private String LINE_SEPARATOR = System.lineSeparator();

    public void announceInputMoney() {
        System.out.println(REQUEST_INPUT_AMOUNT);
    }

    public void announcePurchaseCount(int purchaseCount) {
        System.out.println();
        System.out.printf(ANNOUNCEMENT_PURCHASE_COUNT, purchaseCount);
        System.out.println();
    }

    public void printNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
