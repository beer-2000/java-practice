package subway.ui;

import java.util.Scanner;
import subway.constant.FunctionCommand;
import subway.constant.LineCommand;
import subway.constant.SectionCommand;
import subway.constant.StationCommand;

public class InputView {
    private Scanner scanner;
    private final String REQUEST_COMMAND = "## 원하는 기능을 선택하세요.";
    private final String REQUEST_REGISTER_STATION = "## 등록할 역 이름을 입력하세요.";
    private final String REQUEST_DELETE_STATION = "## 삭제할 역 이름을 입력하세요.";
    private final String REQUEST_REGISTER_LINE = "## 등록할 노선 이름을 입력하세요.";
    private final String REQUEST_START_STATION = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private final String REQUEST_END_STATION = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private final String REQUEST_DELETE_LINE = "## 삭제할 노선 이름을 입력하세요.";
    private final String REQUEST_LINE_OF_SECTION = "## 노선을 입력하세요.";
    private final String REQUEST_STATION_OF_SECTION = "## 역이름을 입력하세요.";
    private final String REQUEST_ORDER_OF_SECTION = "## 순서를 입력하세요.";
    private final String REQUEST_LINE_OF_SECTION_TO_DELETE = "## 삭제할 구간의 노선을 입력하세요.";
    private final String REQUEST_STATION_OF_SECTION_TO_DELETE = "## 삭제할 구간의 역을 입력하세요.";


    public FunctionCommand readFunctionCommand() {
        System.out.println();
        System.out.println(REQUEST_COMMAND);
        scanner = new Scanner(System.in);
        String command = scanner.next();
        System.out.println();
        return FunctionCommand.get(command);
    }

    public StationCommand readStationFunction() {
        System.out.println(REQUEST_COMMAND);
        scanner = new Scanner(System.in);
        String command = scanner.next();
        System.out.println();
        return StationCommand.get(command);
    }

    public String readStationNameToRegister() {
        System.out.println(REQUEST_REGISTER_STATION);
        scanner = new Scanner(System.in);
        String stationName = scanner.next();
        System.out.println();
        return stationName;
    }

    public String readStationNameToDelete() {
        System.out.println(REQUEST_DELETE_STATION);
        scanner = new Scanner(System.in);
        String stationName = scanner.next();
        System.out.println();
        return stationName;
    }

    public LineCommand readLineFunction() {
        System.out.println(REQUEST_COMMAND);
        scanner = new Scanner(System.in);
        String command = scanner.next();
        System.out.println();
        return LineCommand.get(command);
    }

    public String readLineNameToRegister() {
        System.out.println(REQUEST_REGISTER_LINE);
        scanner = new Scanner(System.in);
        String lineName = scanner.next();
        System.out.println();
        return lineName;
    }

    public String readStartStationName() {
        System.out.println(REQUEST_START_STATION);
        scanner = new Scanner(System.in);
        String startStationName = scanner.next();
        System.out.println();
        return startStationName;
    }

    public String readEndStationName() {
        System.out.println(REQUEST_END_STATION);
        scanner = new Scanner(System.in);
        String endStationName = scanner.next();
        System.out.println();
        return endStationName;
    }

    public String readLineNameToDelete() {
        System.out.println(REQUEST_DELETE_LINE);
        scanner = new Scanner(System.in);
        String lineName = scanner.next();
        System.out.println();
        return lineName;
    }

    public SectionCommand readSectionFunction() {
        System.out.println(REQUEST_COMMAND);
        scanner = new Scanner(System.in);
        String command = scanner.next();
        System.out.println();
        return SectionCommand.get(command);
    }

    public String readLineNameOfSection() {
        System.out.println(REQUEST_LINE_OF_SECTION);
        scanner = new Scanner(System.in);
        String lineName = scanner.next();
        System.out.println();
        return lineName;
    }

    public String readStationNameOfSection() {
        System.out.println(REQUEST_STATION_OF_SECTION);
        scanner = new Scanner(System.in);
        String stationName = scanner.next();
        System.out.println();
        return stationName;
    }

    public int readOrder() {
        System.out.println(REQUEST_ORDER_OF_SECTION);
        scanner = new Scanner(System.in);
        int order = scanner.nextInt();
        System.out.println();
        return order;
    }

    public String readLineNameOfSectionToDelete() {
        System.out.println(REQUEST_LINE_OF_SECTION_TO_DELETE);
        scanner = new Scanner(System.in);
        String lineName = scanner.next();
        System.out.println();
        return lineName;
    }

    public String readStationNameOfSectionToDelete() {
        System.out.println(REQUEST_STATION_OF_SECTION_TO_DELETE);
        scanner = new Scanner(System.in);
        String stationName = scanner.next();
        System.out.println();
        return stationName;
    }
}
