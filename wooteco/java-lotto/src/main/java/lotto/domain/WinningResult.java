package lotto.domain;

import java.util.Arrays;

public enum WinningResult {
    NONE(0),
    FIFTH(3),
    FOURTH(4),
    THIRD(5),
    SECOND(5),
    FIRST(6);

    private int countMatch;

    WinningResult(int countMatch) {
        this.countMatch = countMatch;
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
