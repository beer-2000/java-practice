package subway.ui;

import java.util.Arrays;
import java.util.List;
import subway.constant.FunctionCommand;
import subway.constant.LineCommand;
import subway.constant.SectionCommand;
import subway.constant.StationCommand;
import subway.domain.LineMap;

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
    private final String ANNOUNCEMENT_LINE_LIST = "## 노선 목록";
    private final String ANNOUNCEMENT_SECTION_FUNCTION = "## 구간 관리 화면";
    private final String ANNOUNCEMENT_REGISTER_SECTION = "[INFO] 구간이 등록되었습니다.";
    private final String ANNOUNCEMENT_DELETE_SECTION = "[INFO] 구간이 삭제되었습니다.";
    private final String ANNOUNCEMENT_SUBWAY_MAP = "## 지하철 노선도";

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

    public void printLines(List<String> lineNames) {
        System.out.println(ANNOUNCEMENT_LINE_LIST);
        lineNames.forEach(name -> {
            System.out.println(String.join("", INFO_MARK, name));
        });
        System.out.println();
    }

    public void announceSectionFunction() {
        System.out.println(ANNOUNCEMENT_SECTION_FUNCTION);
        Arrays.stream(SectionCommand.values())
                .forEach(value -> {
                    System.out.println(value.getMessage());
                });
        System.out.println();
    }

    public void announceRegisterSection() {
        System.out.println(ANNOUNCEMENT_REGISTER_SECTION);
        System.out.println();
    }

    public void announceDeleteSection() {
        System.out.println(ANNOUNCEMENT_DELETE_SECTION);
        System.out.println();
    }

    public void printSubwayMap(List<LineMap> lineMaps) {
        System.out.println(ANNOUNCEMENT_SUBWAY_MAP);
        lineMaps.forEach(lineMap -> printLineMap(lineMap));
    }

    private void printLineMap(LineMap lineMap) {
        System.out.println(String.join("", INFO_MARK, lineMap.getName()));
        System.out.println(String.join("", INFO_MARK, "---"));
        lineMap.getStations()
                .forEach(station -> {
                    System.out.println(String.join("", INFO_MARK, station.getName()));
                });
        System.out.println();
    }
}
