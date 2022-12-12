package subway.ui;

import java.util.Scanner;
import subway.constant.FunctionCommand;

public class InputView {
    private Scanner scanner;
    private final String REQUEST_COMMAND = "## 원하는 기능을 선택하세요.";

    public FunctionCommand readFunctionCommand() {
        System.out.println();
        System.out.println(REQUEST_COMMAND);
        scanner = new Scanner(System.in);
        String command = scanner.next();
        return FunctionCommand.get(command);
    }
}
