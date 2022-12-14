package vendingmachine.ui;

import java.util.List;
import vendingmachine.domain.CoinInfo;

public class OutputView {
    private final String ANNOUNCEMENT_COIN_INFO = "자판기가 보유한 동전";
    private final String COIN_PRINT_FORMAT = "%s - %s개";

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
        System.out.println();
    }

    public void printCoinCount(List<CoinInfo> coinInfos) {
        System.out.println(ANNOUNCEMENT_COIN_INFO);
        coinInfos.forEach(coinInfo -> {
            System.out.printf(COIN_PRINT_FORMAT, coinInfo.getCoinName(), coinInfo.getCount());
            System.out.println();
        });
        System.out.println();
    }
}
