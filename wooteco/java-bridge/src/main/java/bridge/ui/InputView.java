package bridge.ui;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        String bridgeSizeRaw = Console.readLine();
        return Integer.parseInt(bridgeSizeRaw);
    }

    public String readMoving() {
        return Console.readLine();
    }

    public String readGameCommand() {
        return Console.readLine();
    }
}
