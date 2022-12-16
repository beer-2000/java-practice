package bridge.domain;

import java.util.Arrays;

public enum Moving {
    UP("U", 1),
    DOWN("D", 0);

    private String command;
    private int inclusive;

    private static final String ERROR_MESSAGE_INCORRECT_COMMAND = "[ERROR] 잘못된 이동 방향입니다.";
    private static final String ERROR_MESSAGE_INCORRECT_INCLUSIVE = "[ERROR] 이동에 대한 잘못된 숫자입니다.";

    Moving(String command, int inclusive) {
        this.command = command;
        this.inclusive = inclusive;
    }

    public boolean checkCommand(String command) {
        return this.command.equals(command);
    }

    public boolean checkInclusive(int inclusive) {
        return this.inclusive == inclusive;
    }

    public static Moving getByCommand(String command) {
        return Arrays.stream(Moving.values())
            .filter(moving -> moving.checkCommand(command))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_INCORRECT_COMMAND));
    }

    public static String getCommandByNumber(int inclusive) {
        Moving movingTarget = Arrays.stream(Moving.values())
            .filter(moving -> moving.checkInclusive(inclusive))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_INCORRECT_INCLUSIVE));
        return movingTarget.command;
    }
}
