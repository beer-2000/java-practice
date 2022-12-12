package subway.constant;

public enum SectionCommand {
    REGISTER("1", "1. 구간 등록"),
    DELETE("2", "2. 구간 삭제"),
    BACK("B", "B. 돌아가기");

    private String command;
    private String message;

    SectionCommand(String command, String message) {
        this.command = command;
        this.message = message;
    }
}
