package subway.constant;

public enum StationCommand {
    REGISTER("1", "1. 역 등록"),
    DELETE("2", "2. 역 삭제"),
    FIND("3", "3. 역 조회"),
    BACK("B", "B. 돌아가기");

    private String command;
    private String message;

    StationCommand(String command, String message) {
        this.command = command;
        this.message = message;
    }
}
