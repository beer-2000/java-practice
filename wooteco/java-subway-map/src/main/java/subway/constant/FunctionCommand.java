package subway.constant;

import java.util.Arrays;

public enum FunctionCommand {
    STATION_MANAGEMENT("1", "1. 역 관리"),
    LINE_MANAGEMENT("2", "2. 노선 관리"),
    SECTION_MANAGEMENT("3", "3. 구간 관리"),
    SUBWAY_MAP("4", "4. 지하철 노선도 출력"),
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
