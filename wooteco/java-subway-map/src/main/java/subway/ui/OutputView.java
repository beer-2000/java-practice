package subway.ui;

import java.util.Arrays;
import java.util.List;
import subway.constant.FunctionCommand;
import subway.constant.LineCommand;
import subway.constant.StationCommand;

public class OutputView {
    private final String ANNOUNCEMENT_MAIN_FUNCTION = "## 메인 화면";
    private final String ANNOUNCEMENT_STATION_FUNCTION = "## 역 관리 화면";
    private final String ANNOUNCEMENT_LINE_FUNCTION = "## 노선 관리 화면";
    private final String ANNOUNCEMENT_REGISTER_STATION = "[INFO] 지하철 역이 등록되었습니다.";
    private final String ANNOUNCEMENT_DELETE_STATION = "[INFO] 지하철 역이 삭제되었습니다.";
    private final String ANNOUNCEMENT_STATION_LIST = "## 역 목록";
    private final String INFO_MARK = "[INFO] ";
    private final String ANNOUNCEMENT_REGISTER_LINE = "[INFO] 지하철 노선이 등록되었습니다.";
    private final String ANNOUNCEMENT_DELETE_LINE = "[INFO] 지하철 노선이 삭제되었습니다.";

    public void announceMainFunction() {
        System.out.println(ANNOUNCEMENT_MAIN_FUNCTION);
        Arrays.stream(FunctionCommand.values())
                .forEach(value -> {
                    System.out.println(value.getMessage());
                });
    }

    public void announceStationFunction() {
        System.out.println(ANNOUNCEMENT_STATION_FUNCTION);
        Arrays.stream(StationCommand.values())
                .forEach(value -> {
                    System.out.println(value.getMessage());
                });
        System.out.println();
    }

    public void announceRegisterStation() {
        System.out.println(ANNOUNCEMENT_REGISTER_STATION);
        System.out.println();
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
        System.out.println();
    }

    public void announceDeleteStation() {
        System.out.println(ANNOUNCEMENT_DELETE_STATION);
        System.out.println();
    }

    public void printStations(List<String> stationNames) {
        System.out.println(ANNOUNCEMENT_STATION_LIST);
        stationNames.forEach(name -> {
            System.out.println(String.join("", INFO_MARK, name));
        });
        System.out.println();
    }

    public void announceLineFunction() {
        System.out.println(ANNOUNCEMENT_LINE_FUNCTION);
        Arrays.stream(LineCommand.values())
                .forEach(value -> {
                    System.out.println(value.getMessage());
                });
        System.out.println();
    }

    public void announceRegisterLine() {
        System.out.println(ANNOUNCEMENT_REGISTER_LINE);
        System.out.println();
    }

    public void announceDeleteLine() {
        System.out.println(ANNOUNCEMENT_DELETE_LINE);
        System.out.println();
    }
}
