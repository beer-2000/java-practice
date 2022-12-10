package bridge.ui;

import static bridge.constant.BridgeRule.LOWER_SIDE;
import static bridge.constant.BridgeRule.UPPER_SIDE;

import bridge.domain.MovingStatus;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String ANNOUNCEMENT_START_GAME = "다리 건너기 게임을 시작합니다.";
    private final String REQUEST_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private final String REQUEST_MOVING = "이동할 칸을 선택해주세요. (위: %s, 아래: %s)";
    private final String REQUEST_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final String ANNOUNCEMENT_END_GAME = "최종 게임 결과";
    private final String ANNOUNCEMENT_WHETHER_SUCCESS = "게임 성공 여부: %s";
    private final String ANNOUNCEMENT_TRY_COUNT = "총 시도한 횟수: %d";

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

    public void printMap(MovingStatus movingStatus) {
        List<String> history = movingStatus.getHistory();
        StringBuilder upperSidePicture = new StringBuilder("[");
        StringBuilder lowerSidePicture = new StringBuilder("[");
        history.stream()
                .forEach(moving -> drawSuccess(upperSidePicture, lowerSidePicture, moving));
        if (movingStatus.isFail()) {
            drawFail(movingStatus, upperSidePicture, lowerSidePicture);
        }
        closeBracket(upperSidePicture, lowerSidePicture);
        System.out.println(upperSidePicture);
        System.out.println(lowerSidePicture);
        System.out.println();
    }

    public void printResult(MovingStatus movingStatus, boolean isSuccess, int tryCount) {
        System.out.println(ANNOUNCEMENT_END_GAME);
        printMap(movingStatus);
        System.out.printf(ANNOUNCEMENT_WHETHER_SUCCESS, getTextOf(isSuccess));
        System.out.println();
        System.out.printf(ANNOUNCEMENT_TRY_COUNT, tryCount);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    private void drawSuccess(StringBuilder upperSidePicture, StringBuilder lowerSidePicture, String moving) {
        upperSidePicture.append(getDrawingOfUpper(moving));
        lowerSidePicture.append(getDrawingOfLower(moving));
    }

    private static void closeBracket(StringBuilder upperSidePicture, StringBuilder lowerSidePicture) {
        upperSidePicture.delete(upperSidePicture.length() - 1, upperSidePicture.length());
        lowerSidePicture.delete(lowerSidePicture.length() - 1, lowerSidePicture.length());
        upperSidePicture.append("]");
        lowerSidePicture.append("]");
    }

    private void drawFail(MovingStatus movingStatus, StringBuilder upperSidePicture, StringBuilder lowerSidePicture) {
        upperSidePicture.delete(upperSidePicture.length() - 4, upperSidePicture.length());
        lowerSidePicture.delete(lowerSidePicture.length() - 4, lowerSidePicture.length());
        String lastMoving = movingStatus.getLastMoving();
        upperSidePicture.append(getFailDrawingOfUpper(lastMoving));
        lowerSidePicture.append(getFailDrawingOfLower(lastMoving));
    }

    private String getDrawingOfUpper(String moving) {
        if (moving.equals(UPPER_SIDE)) {
            return " O |";
        }
        return "   |";
    }

    private String getDrawingOfLower(String moving) {
        if (moving.equals(LOWER_SIDE)) {
            return " O |";
        }
        return "   |";
    }

    private String getFailDrawingOfUpper(String moving) {
        if (moving.equals(UPPER_SIDE)) {
            return " X |";
        }
        return "   |";
    }

    private String getFailDrawingOfLower(String moving) {
        if (moving.equals(LOWER_SIDE)) {
            return " X |";
        }
        return "   |";
    }

    private String getTextOf(boolean isSuccess) {
        if (isSuccess) {
            return "성공";
        }
        return "실패";
    }
}
