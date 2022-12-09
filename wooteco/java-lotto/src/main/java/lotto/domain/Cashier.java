package lotto.domain;

import static lotto.constant.LottoRule.PRICE;

public class Cashier {
    public static int calculatePurchaseCountByMoney(String inputMoneyRaw) {
        int inputMoney = Integer.parseInt(inputMoneyRaw);
        return inputMoney / PRICE;
    }
}
