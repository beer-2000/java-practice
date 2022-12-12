package subway.constant;

public enum FunctionCommand {
    STATION_MANAGEMENT("1", "1. 역 관리"),
    LINE_MANAGEMENT("2", "2. 노선 관리"),
    SECTION_MANAGEMENT("3", "3. 구간 관리"),
    SUBWAY_MAP("4", "4. 지하철 노선도 출력"),
    QUIT("Q", "Q. 종료");

    private String command;
    private String message;

    FunctionCommand(String command, String message) {
        this.command = command;
        this.message = message;
    }
}
