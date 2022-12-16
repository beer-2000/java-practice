package bridge.domain;

import java.util.Arrays;

public enum Moving {
    UP("U"),
    DOWN("D");

    private String command;

    private static final String ERROR_MESSAGE_INCORRECT_COMMAND = "[ERROR] 잘못된 이동 방향입니다.";

    Moving(String command) {
        this.command = command;
    }

    public boolean checkCommand(String command) {
        return this.command.equals(command);
    }

    public static Moving getByCommand(String command) {
        return Arrays.stream(Moving.values())
            .filter(moving -> moving.checkCommand(command))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_INCORRECT_COMMAND));
    }
}
