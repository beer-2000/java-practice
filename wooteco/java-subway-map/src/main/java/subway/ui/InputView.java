package subway.ui;

import java.util.Scanner;
import subway.constant.FunctionCommand;
import subway.constant.StationCommand;

public class InputView {
    private Scanner scanner;
    private final String REQUEST_COMMAND = "## 원하는 기능을 선택하세요.";
    private final String REQUEST_REGISTER_STATION = "## 등록할 역 이름을 입력하세요.";
    private final String REQUEST_DELETE_STATION = "## 삭제할 역 이름을 입력하세요.";

    public FunctionCommand readFunctionCommand() {
        System.out.println();
        System.out.println(REQUEST_COMMAND);
        scanner = new Scanner(System.in);
        String command = scanner.next();
        System.out.println();
        return FunctionCommand.get(command);
    }

    public StationCommand readStationFunction() {
        System.out.println();
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
}
