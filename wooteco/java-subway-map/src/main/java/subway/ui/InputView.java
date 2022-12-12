package subway.ui;

import java.util.Scanner;
import subway.constant.FunctionCommand;
import subway.constant.LineCommand;
import subway.constant.StationCommand;

public class InputView {
    private Scanner scanner;
    private final String REQUEST_COMMAND = "## 원하는 기능을 선택하세요.";
    private final String REQUEST_REGISTER_STATION = "## 등록할 역 이름을 입력하세요.";
    private final String REQUEST_DELETE_STATION = "## 삭제할 역 이름을 입력하세요.";
    private final String REQUEST_REGISTER_LINE = "## 등록할 노선 이름을 입력하세요.";
    private final String REQUEST_START_STATION = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private final String REQUEST_END_STATION = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";

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
}
