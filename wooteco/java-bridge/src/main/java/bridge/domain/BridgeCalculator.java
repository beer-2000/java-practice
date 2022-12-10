package bridge.domain;

import java.util.List;

public class BridgeCalculator {
    private List<String> bridge;

    public BridgeCalculator(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isCorrectMoving(String moving, int location) {
        return moving.equals(bridge.get(location));
    }

    public int getSizeOfBridge() {
        return bridge.size();
    }
}
