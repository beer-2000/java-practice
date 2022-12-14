package vendingmachine.domain;

import java.util.Objects;

public class CoinInfo {
    private Coin coin;
    private int count;

    public CoinInfo(Coin coin, int count) {
        this.coin = coin;
        this.count = count;
    }

    public String getCoinName() {
        return coin.getName();
    }

    public int getCount() {
        return count;
    }

    public int getAmount() {
        return coin.getAmount() * count;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CoinInfo coinInfo = (CoinInfo) o;
        return coin == coinInfo.coin &&
                count == coinInfo.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coin, count);
    }
}
