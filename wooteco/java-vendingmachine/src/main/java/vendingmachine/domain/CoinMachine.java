package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinMachine {
    private List<CoinStatus> coinStatuses;
    private final String ERROR_MESSAGE_AT_COIN_MACHINE = "[ERROR] 내부 에러입니다. - CoinMachine";
    private final String ERROR_MESSAGE_NOT_MULTIPLE_OF_10 = "[ERROR] 10원으로 나누어떨어지지 않습니다.";
    private final String ERROR_MESSAGE_MONEY_UNDER_0 = "[ERROR] 10원의 배수를 입력해주세요.";

    public CoinMachine(int money) {
        this.coinStatuses = new ArrayList<>();
        validateMoney(money);
        for (Coin coin : Coin.values()) {
            coinStatuses.add(new CoinStatus(coin, 0));
        }
        int changes = money;
        List<Integer> amounts = Arrays.asList(500, 100, 50, 10);
        while (changes >= 10) {
            changes = getChangesAfterCreateCoin(changes, amounts);
        }
    }

    private int getChangesAfterCreateCoin(int changes, List<Integer> amounts) {
        int amount = Randoms.pickNumberInList(amounts);
        if (changes < amount) {
            return changes;
        }
        coinStatuses.stream()
                .filter(coinStatus -> coinStatus.isAmountOf(amount))
                .forEach(coinStatus -> coinStatus.addCount());
        changes -= amount;
        return changes;
    }

    private void validateMoney(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MONEY_UNDER_0);
        }
        if (!(money % 10 == 0)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_MULTIPLE_OF_10);
        }
    }

    private int getCountOf(Coin coin) {
        return coinStatuses.stream()
                .filter(coinStatus -> coinStatus.isOf(coin))
                .mapToInt((coinStatus -> coinStatus.getCount()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_AT_COIN_MACHINE));
    }

    public List<CoinInfo> getCoinCountInfo() {
        List<CoinInfo> coinInfos = new ArrayList<>();
        coinStatuses.forEach(coinStatus -> {
            coinInfos.add(coinStatus.getInfo());
        });
        return coinInfos;
    }

    public List<CoinInfo> getCoinCountInfoOfChanges(int inputMoney) {
        int changes = inputMoney;
        List<CoinInfo> coinInfos = new ArrayList<>();
        for (CoinStatus coinStatus : coinStatuses) {
            CoinInfo coinInfo = coinStatus.getInfoOfChanges(changes);
            if (coinInfo.getCount() == 0) {
                continue;
            }
            coinInfos.add(coinStatus.getInfoOfChanges(changes));
            changes -= coinInfo.getAmount();
        }
        return coinInfos;
    }
}
