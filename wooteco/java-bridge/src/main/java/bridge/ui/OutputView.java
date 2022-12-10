package bridge.ui;

import static bridge.constant.BridgeRule.LOWER_SIDE;
import static bridge.constant.BridgeRule.UPPER_SIDE;

import bridge.domain.MovingStatus;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String ANNOUNCEMENT_START_GAME = "다리 건너기 게임을 시작합니다.";
    private final String REQUEST_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private final String REQUEST_MOVING = "이동할 칸을 선택해주세요. (위: %s, 아래: %s)";
    private final String REQUEST_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public void announceStartGame() {
        System.out.println(ANNOUNCEMENT_START_GAME);
        System.out.println();
    }

    public void requestBridgeSize() {
        System.out.println(REQUEST_BRIDGE_SIZE);
    }

    public void printLineSeparator() {
        System.out.println();
    }

    public void requestMoving() {
        System.out.printf(REQUEST_MOVING, UPPER_SIDE, LOWER_SIDE);
        System.out.println();
    }

    public void requestGameCommand() {
        System.out.println(REQUEST_GAME_COMMAND);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(MovingStatus movingStatus) {
        System.out.println(movingStatus.getHistory());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(MovingStatus movingStatus) {
        System.out.println(movingStatus.getHistory());
    }
}
