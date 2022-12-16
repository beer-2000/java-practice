package bridge.domain;

public enum GameStatus {
    ON_WAY,
    END_SUCCESS,
    END_FAIL;

    public boolean isOnWay() {
        return this.equals(ON_WAY);
    }
}
