package lotto.domain;

import java.util.Arrays;

public enum WinningResult {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private int countMatch;
    private long prize;

    WinningResult(int countMatch, long prize) {
        this.countMatch = countMatch;
        this.prize = prize;
    }

    public long getPrize() {
        return prize;
    }

    public static WinningResult match(int countMatch, boolean isContainBonusNumber) {
        System.out.println("input of match: " + countMatch + " " + isContainBonusNumber);
        WinningResult winningResult = Arrays.stream(WinningResult.values())
                .filter(result -> result.countMatch == countMatch)
                .findFirst()
                .orElse(NONE);
        if (winningResult.equals(THIRD) && isContainBonusNumber) {
            return SECOND;
        }
        return winningResult;
    }
}
