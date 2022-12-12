package subway.constant;

public enum LineCommand {
    REGISTER("1", "1. 노선 등록"),
    DELETE("2", "2. 노선 삭제"),
    FIND("3", "3. 노선 조회"),
    BACK("B", "B. 돌아가기");

    private String command;
    private String message;

    LineCommand(String command, String message) {
        this.command = command;
        this.message = message;
    }
}
