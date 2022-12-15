package pairmatching.constant;

import java.util.Arrays;

public enum FunctionCommand {
    PAIR_MATCHING("1", "1. 페어 매칭"),
    PAIR_FIND("2", "2. 페어 조회"),
    PAIR_INIT("3", "3. 페어 초기화"),
    QUIT("Q", "Q. 종료");

    private String command;
    private String message;
    private static final String ERROR_MESSAGE_WRONG_FUNCTION_COMMAND = "[ERROR] 선택할 수 없는 기능입니다.";

    FunctionCommand(String command, String message) {
        this.command = command;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static FunctionCommand get(String command) {
        return Arrays.stream(FunctionCommand.values())
                .filter(value -> value.isCommandOf(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_WRONG_FUNCTION_COMMAND));
    }

    private boolean isCommandOf(String command) {
        return this.command.equals(command);
    }
}
