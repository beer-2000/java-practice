package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class CoinMachine {
    private List<CoinStatus> coinStatuses;
    private final String ERROR_MESSAGE_AT_COIN_MACHINE = "[ERROR] 내부 에러입니다. - CoinMachine";

    public CoinMachine(int money) {
        int changes = money;
        coinStatuses = new ArrayList<>();
        for (Coin coin : Coin.values()) {
            coinStatuses.add(new CoinStatus(coin, changes));
            changes -= getCountOf(coin) * coin.getAmount();
        }
    }

    private int getCountOf(Coin coin) {
        return coinStatuses.stream()
                .filter(coinStatus -> coinStatus.isOf(coin))
                .mapToInt((coinStatus -> coinStatus.getCount()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_AT_COIN_MACHINE));
    }
}
