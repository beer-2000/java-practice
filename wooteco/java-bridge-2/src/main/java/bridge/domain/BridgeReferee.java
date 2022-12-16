package bridge.domain;

import java.util.List;

public class BridgeReferee {
    private final List<Moving> bridge;

    public BridgeReferee(List<Moving> bridge) {
        this.bridge = bridge;
    }

    public boolean judge(Moving moving, int location) {
        Moving movingNow = bridge.get(location);
        return movingNow.equals(moving);
    }

    public boolean isEndLocation(int location) {
        return bridge.size() == location;
    }
}
