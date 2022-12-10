package bridge.domain;

import static bridge.constant.BridgeRule.COMMAND_QUIT;
import static bridge.constant.BridgeRule.COMMAND_RETRY;
import static bridge.constant.BridgeRule.LOWER_SIDE;
import static bridge.constant.BridgeRule.UPPER_SIDE;
import static bridge.constant.ProgressStatus.FAIL;
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
    private final String ERROR_MESSAGE_WRONG_MOVING = "[ERROR] 위로 이동하려면 %s, 아래로 이동하려면 %s를 입력해주세요.";
    private final String ERROR_MESSAGE_WRONG_GAME_COMMAND = "[ERROR] 재시작하시려면 %s, 종료하시려면 %s를 입력해주세요.";

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
        validateMoving(moving);
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
    public void retry(String gameCommand) {
        validateGameCommand(gameCommand);
        if (gameCommand.equals(COMMAND_QUIT)) {
            progressStatus = FAIL;
            return;
        }
        this.movingHistory = new ArrayList<>();
        tryCount += 1;
    }

    public boolean isOnWay() {
        return progressStatus.equals(ON_WAY);
    }

    public boolean isSuccess() {
        return progressStatus.equals(SUCCESS);
    }

    public int getTryCount() {
        return tryCount;
    }

    private void validateMoving(String moving) {
        if (moving.equals(UPPER_SIDE) || moving.equals(LOWER_SIDE)) {
            return;
        }
        throw new IllegalArgumentException(
                String.format(ERROR_MESSAGE_WRONG_MOVING, UPPER_SIDE, LOWER_SIDE));
    }

    private void validateGameCommand(String gameCommand) {
        if (gameCommand.equals(COMMAND_QUIT) || gameCommand.equals(COMMAND_RETRY)) {
            return;
        }
        throw new IllegalArgumentException(
                String.format(ERROR_MESSAGE_WRONG_GAME_COMMAND, COMMAND_QUIT, COMMAND_RETRY));
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
