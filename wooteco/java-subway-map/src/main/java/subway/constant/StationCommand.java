package subway.constant;

import java.util.Arrays;

public enum StationCommand {
    REGISTER("1", "1. 역 등록"),
    DELETE("2", "2. 역 삭제"),
    FIND("3", "3. 역 조회"),
    BACK("B", "B. 돌아가기");

    private String command;
    private String message;
    private static final String ERROR_MESSAGE_WRONG_FUNCTION_COMMAND = "[ERROR] 선택할 수 없는 기능입니다.";

    StationCommand(String command, String message) {
        this.command = command;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static StationCommand get(String command) {
        return Arrays.stream(StationCommand.values())
                .filter(value -> value.isCommandOf(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_WRONG_FUNCTION_COMMAND));
    }

    private boolean isCommandOf(String command) {
        return this.command.equals(command);
    }
}
