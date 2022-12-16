package bridge.ui;

import bridge.domain.GameCommand;
import bridge.domain.Moving;
import camp.nextstep.edu.missionutils.Console;

import static bridge.domain.GameCommand.QUIT;
import static bridge.domain.GameCommand.RETRY;
import static bridge.domain.Moving.DOWN;
import static bridge.domain.Moving.UP;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String REQUEST_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private final String ERROR_MESSAGE_WRONG_BRIDGE_SIZE = "[ERROR] 다리의 길이는 숫자만 입력해주세요.";
    private final String REQUEST_MOVING = "이동할 칸을 선택해주세요. (위: %s, 아래: %s)";
    private final String REQUEST_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(REQUEST_BRIDGE_SIZE);
        try {
            int bridgeSize = Integer.parseInt(Console.readLine());
            System.out.println();
            return bridgeSize;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_WRONG_BRIDGE_SIZE);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Moving readMoving() {
        System.out.printf(REQUEST_MOVING, UP.getCommand(), DOWN.getCommand());
        System.out.println();
        return Moving.getByCommand(Console.readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        System.out.printf(REQUEST_GAME_COMMAND, RETRY.getCommand(), QUIT.getCommand());
        System.out.println();
        return GameCommand.getByCommand(Console.readLine());
    }
}
