package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgePicture {
    private List<Moving> bridge;
    private boolean isFail;

    public BridgePicture() {
        this.bridge = new ArrayList<>();
        this.isFail = true;
    }

    public int getLocation() {
        return bridge.size();
    }
}
