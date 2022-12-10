package bridge.domain;

import java.util.List;

public class BridgeCalculator {
    private List<String> bridge;

    public BridgeCalculator(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getSizeOfBridge() {
        return bridge.size();
    }
}
