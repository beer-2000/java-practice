package subway.constant;

import java.util.Arrays;

public enum MainCommand {
    PATH_FIND("1", "1. 경로 조회"),
    QUIT("Q", "Q. 종료");

    private String command;
    private String message;
    private static final String ERROR_MESSAGE_WRONG_FUNCTION_COMMAND = "[ERROR] 선택할 수 없는 기능입니다.";

    MainCommand(String command, String message) {
        this.command = command;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static MainCommand get(String command) {
        return Arrays.stream(MainCommand.values())
                .filter(value -> value.isCommandOf(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_WRONG_FUNCTION_COMMAND));
    }

    private boolean isCommandOf(String command) {
        return this.command.equals(command);
    }
}
