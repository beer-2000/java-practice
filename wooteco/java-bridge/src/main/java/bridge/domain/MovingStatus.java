package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class MovingStatus {
    private List<String> history;
    private boolean isFail;
    private int bridgeSize;

    public MovingStatus(int bridgeSize) {
        this.history = new ArrayList<>();
        this.isFail = false;
        this.bridgeSize = bridgeSize;
    }

    public List<String> getHistory() {
        return history;
    }

    public boolean isFail() {
        return isFail;
    }

    public void setFail() {
        this.isFail = true;
    }
}
