package bridge.domain;

import static bridge.constant.ProgressStatus.ON_WAY;
import static bridge.constant.ProgressStatus.SUCCESS;

import bridge.constant.ProgressStatus;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> movingHistory;
    private int tryCount;
    private ProgressStatus progressStatus;
    private BridgeCalculator bridgeCalculator;

    public BridgeGame(List<String> bridge) {
        this.movingHistory = new ArrayList<>();
        this.tryCount = 1;
        this.progressStatus = ON_WAY;
        this.bridgeCalculator = new BridgeCalculator(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MovingStatus move(String moving) {
        movingHistory.add(moving);
        MovingStatus movingStatus = generateMovingStatus();
        if (isCorrectMoving(moving)) {
            checkSuccess();
            return movingStatus;
        }
        movingStatus.setFail();
        return movingStatus;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public boolean isOnWay() {
        return progressStatus.equals(ON_WAY);
    }

    private boolean isCorrectMoving(String moving) {
        int location = movingHistory.size() - 1;
        return bridgeCalculator.isCorrectMoving(moving, location);
    }

    private MovingStatus generateMovingStatus() {
        return new MovingStatus(movingHistory, bridgeCalculator.getSizeOfBridge());
    }

    private void checkSuccess() {
        if (movingHistory.size() == bridgeCalculator.getSizeOfBridge()) {
            progressStatus = SUCCESS;
        }
    }
}
