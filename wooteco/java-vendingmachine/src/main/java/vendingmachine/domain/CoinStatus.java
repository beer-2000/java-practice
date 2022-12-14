package vendingmachine.domain;

public class CoinStatus {
    private Coin coin;
    private int count;

    public CoinStatus(Coin coin, int money) {
        this.coin = coin;
    }

    public boolean isOf(Coin coin) {
        return this.coin.equals(coin);
    }

    public int getCount() {
        return count;
    }
}
