package bridge.domain;

import static bridge.constant.BridgeRule.MAXIMUM_BRIDGE_SIZE;
import static bridge.constant.BridgeRule.MINIMUM_BRIDGE_SIZE;

import java.util.List;

public class BridgeCalculator {
    private List<String> bridge;
    private final String ERROR_MESSAGE_WRONG_BRIDGE_SIZE = "[ERROR] 다리 길이는 %d 이상 %d 이하여야 합니다.";

    public BridgeCalculator(List<String> bridge) {
        validate(bridge);
        this.bridge = bridge;
    }

    public boolean isCorrectMoving(String moving, int location) {
        return moving.equals(bridge.get(location));
    }

    public int getSizeOfBridge() {
        return bridge.size();
    }

    private void validate(List<String> bridge) {
        if (MINIMUM_BRIDGE_SIZE <= bridge.size() && bridge.size() <= MAXIMUM_BRIDGE_SIZE) {
            return;
        }
        throw new IllegalArgumentException(
                String.format(ERROR_MESSAGE_WRONG_BRIDGE_SIZE, MINIMUM_BRIDGE_SIZE, MAXIMUM_BRIDGE_SIZE));
    }
}
