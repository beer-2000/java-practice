package subway.constant;

import java.util.Arrays;

public enum LineCommand {
    REGISTER("1", "1. 노선 등록"),
    DELETE("2", "2. 노선 삭제"),
    FIND("3", "3. 노선 조회"),
    BACK("B", "B. 돌아가기");

    private String command;
    private String message;
    private static final String ERROR_MESSAGE_WRONG_LINE_COMMAND = "[ERROR] 선택할 수 없는 기능입니다.";

    LineCommand(String command, String message) {
        this.command = command;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static LineCommand get(String command) {
        return Arrays.stream(LineCommand.values())
                .filter(value -> value.isCommandOf(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_WRONG_LINE_COMMAND));
    }

    private boolean isCommandOf(String command) {
        return this.command.equals(command);
    }
}
