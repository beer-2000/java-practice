package bridge.ui;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String ERROR_MESSAGE_ONLY_INPUT_NUMBER = "[ERROR] 숫자를 입력해주세요.";

    public int readBridgeSize() {
        try {
            String bridgeSizeRaw = Console.readLine();
            return Integer.parseInt(bridgeSizeRaw);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ONLY_INPUT_NUMBER);
        }
    }

    public String readMoving() {
        return Console.readLine();
    }

    public String readGameCommand() {
        return Console.readLine();
    }
}
