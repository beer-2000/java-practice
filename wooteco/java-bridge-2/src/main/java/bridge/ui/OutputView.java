package bridge.ui;

import bridge.domain.BridgePicture;
import bridge.domain.Moving;

import java.util.List;

import static bridge.domain.Moving.DOWN;
import static bridge.domain.Moving.UP;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String ANNOUNCEMENT_START_GAME = "다리 건너기 게임을 시작합니다.";
    private final String SUCCESS_MARK = " O ";
    private final String FAIL_MARK = " X ";
    private final String SPACE = "   ";
    private final String SEPARATE_LINE = "|";
    private final String START_BRACKET = "[";
    private final String END_BRACKET = "]";
    private final String ANNOUNCEMENT_FINAL_RESULT = "최종 게임 결과";
    private final String ANNOUNCEMENT_SUCCESS_OR_FAIL = "게임 성공 여부: %s";
    private final String ANNOUNCEMENT_TRY_COUONT = "총 시도한 횟수: %d";
    private final String SUCCESS = "성공";
    private final String FAIL = "실패";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgePicture bridgePicture) {
        StringBuilder upperLine = new StringBuilder();
        StringBuilder lowerLine = new StringBuilder();
        addStartBrackets(upperLine, lowerLine);
        drawBridgeStatus(bridgePicture, upperLine, lowerLine);
        checkFail(bridgePicture, upperLine, lowerLine);
        System.out.println(upperLine);
        System.out.println(lowerLine);
        System.out.println();
    }

    private void addStartBrackets(StringBuilder upperLine, StringBuilder lowerLine) {
        upperLine.append(START_BRACKET);
        lowerLine.append(START_BRACKET);
    }

    private void drawBridgeStatus(BridgePicture bridgePicture, StringBuilder upperLine, StringBuilder lowerLine) {
        List<Moving> bridge = bridgePicture.getBridge();
        bridge.forEach(moving -> {
            upperLine.append(getUpperMarkBy(moving));
            lowerLine.append(getLowerMarkBy(moving));
        });
        addBrackets(upperLine, lowerLine);
    }

    private void checkFail(BridgePicture bridgePicture, StringBuilder upperLine, StringBuilder lowerLine) {
        if (bridgePicture.isFail()) {
            List<Moving> bridge = bridgePicture.getBridge();
            Moving lastMoving = bridge.get(bridgePicture.getLocation() - 1);
            editFailUpperLine(upperLine, lastMoving);
            editFailLowerLine(lowerLine, lastMoving);
        }
    }

    private void editFailUpperLine(StringBuilder upperLine, Moving lastMoving) {
        if (lastMoving.equals(UP)) {
            upperLine.delete(upperLine.length() - 4, upperLine.length());
            upperLine.append(FAIL_MARK);
            upperLine.append(END_BRACKET);
        }
    }

    private void editFailLowerLine(StringBuilder lowerLine, Moving lastMoving) {
        if (lastMoving.equals(DOWN)) {
            lowerLine.delete(lowerLine.length() - 4, lowerLine.length());
            lowerLine.append(FAIL_MARK);
            lowerLine.append(END_BRACKET);
        }
    }

    private String getUpperMarkBy(Moving moving) {
        if (moving.equals(UP)) {
            return SUCCESS_MARK + SEPARATE_LINE;
        }
        return SPACE + SEPARATE_LINE;
    }

    private String getLowerMarkBy(Moving moving) {
        if (moving.equals(DOWN)) {
            return SUCCESS_MARK + SEPARATE_LINE;
        }
        return SPACE + SEPARATE_LINE;
    }

    private void addBrackets(StringBuilder upperLine, StringBuilder lowerLine) {
        upperLine.deleteCharAt(upperLine.length() - 1);
        lowerLine.deleteCharAt(lowerLine.length() - 1);
        upperLine.append(END_BRACKET);
        lowerLine.append(END_BRACKET);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgePicture bridgePicture, boolean isSuccess, int tryCount) {
        System.out.println(ANNOUNCEMENT_FINAL_RESULT);
        printMap(bridgePicture);
        printSuccessOrFail(isSuccess);
        System.out.printf(ANNOUNCEMENT_TRY_COUONT, tryCount);
    }

    private void printSuccessOrFail(boolean isSuccess) {
        if (isSuccess) {
            System.out.printf(ANNOUNCEMENT_SUCCESS_OR_FAIL, SUCCESS);
            System.out.println();
            return;
        }
        System.out.printf(ANNOUNCEMENT_SUCCESS_OR_FAIL, FAIL);
        System.out.println();
    }

    public void announceStartGame() {
        System.out.println(ANNOUNCEMENT_START_GAME);
        System.out.println();
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
        System.out.println();
    }
}
