package subway.constant;

import java.util.Arrays;

public enum PathCommand {
    MINIMUM_DISTANCE("1", "1. 최단 거"),
    MINIMUM_TIME("2", "2. 최소 시간"),
    QUIT("Q", "Q. 종료");

    private String command;
    private String message;
    private static final String ERROR_MESSAGE_WRONG_FUNCTION_COMMAND = "[ERROR] 선택할 수 없는 기능입니다.";

    PathCommand(String command, String message) {
        this.command = command;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static PathCommand get(String command) {
        return Arrays.stream(PathCommand.values())
                .filter(value -> value.isCommandOf(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_WRONG_FUNCTION_COMMAND));
    }

    private boolean isCommandOf(String command) {
        return this.command.equals(command);
    }
}
