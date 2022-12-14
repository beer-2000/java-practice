package vendingmachine.domain;

import static vendingmachine.domain.Coin.COIN_10;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CoinStatus {
    private Coin coin;
    private int count;
    private final String ERROR_MESSAGE_NOT_MULTIPLE_OF_10 = "[ERROR] 10원으로 나누어떨어지지 않습니다.";

    public CoinStatus(Coin coin, int money) {
        this.coin = coin;
        generateCount(coin, money);
    }

    private void generateCount(Coin coin, int money) {
        if (coin.equals(COIN_10)) {
            generateCountOf10(coin, money);
            return;
        }
        generateCountExcept10(coin, money);
    }

    private void generateCountExcept10(Coin coin, int money) {
        int amount = coin.getAmount();
        int maxCount = money / amount;
        List<Integer> randomCounts = new ArrayList<>();
        IntStream.rangeClosed(0, maxCount)
                .forEach(number -> randomCounts.add(number));
        this.count = Randoms.pickNumberInList(randomCounts);
    }

    private void generateCountOf10(Coin coin, int money) {
        if (!(money % 10 == 0)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_MULTIPLE_OF_10);
        }
        int amount = coin.getAmount();
        this.count = money / amount;
    }

    public boolean isOf(Coin coin) {
        return this.coin.equals(coin);
    }

    public int getCount() {
        return count;
    }

    public CoinInfo getInfo() {
        return new CoinInfo(coin, count);
    }
}
