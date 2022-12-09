package lotto.domain;

import static lotto.constant.LottoRule.PRICE;

public class Cashier {
    public static int calculatePurchaseCountByMoney(String inputMoneyRaw) {
        int inputMoney = convertMoneyRaw(inputMoneyRaw);
        validate(inputMoney);
        return inputMoney / PRICE;
    }

    private static void validate(int inputMoney) {
        if (inputMoney % PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1000의 배수를 입력해주세요.");
        }
    }

    private static int convertMoneyRaw(String inputMoneyRaw) {
        try {
            int inputMoney = Integer.parseInt(inputMoneyRaw);
            return inputMoney;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }
}
