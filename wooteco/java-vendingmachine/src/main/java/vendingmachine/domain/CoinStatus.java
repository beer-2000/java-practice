package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CoinStatus {
    private Coin coin;
    private int count;

    public CoinStatus(Coin coin, int money) {
        this.coin = coin;
        int amount = coin.getAmount();
        int maxCount = money / amount;
        List<Integer> randomCounts = new ArrayList<>();
        IntStream.rangeClosed(0, maxCount)
                .forEach(number -> randomCounts.add(number));
        this.count = Randoms.pickNumberInList(randomCounts);
    }

    public boolean isOf(Coin coin) {
        return this.coin.equals(coin);
    }

    public int getCount() {
        return count;
    }
}
