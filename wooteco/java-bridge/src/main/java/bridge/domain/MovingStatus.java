package bridge.domain;

import java.util.List;

public class MovingStatus {
    private List<String> history;
    private boolean isFail;
    private int bridgeSize;

    public MovingStatus(List<String> history, boolean isFail, int bridgeSize) {
        this.history = history;
        this.isFail = isFail;
        this.bridgeSize = bridgeSize;
    }

    public List<String> getHistory() {
        return history;
    }

    public boolean isFail() {
        return isFail;
    }

    public String getLastMoving() {
        return history.get(history.size() - 1);
    }
}
