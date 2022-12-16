package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgePicture {
    private List<Moving> bridge;
    private boolean isFail;

    public BridgePicture() {
        this.bridge = new ArrayList<>();
        this.isFail = false;
    }

    public int getLocation() {
        return bridge.size();
    }

    public void record(Moving moving, boolean canCross) {
        bridge.add(moving);
        if (!canCross) {
            isFail = true;
        }
    }

    public boolean isFail() {
        return isFail;
    }
}
