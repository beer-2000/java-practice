package lotto.domain;

public enum WinningResult {
    NONE(0),
    FIFTH(3),
    FOURTH(4),
    THIRD(5),
    SECOND(5),
    FIRST(6);

    private int matchCount;

    WinningResult(int matchCount) {
        this.matchCount = matchCount;
    }
}
