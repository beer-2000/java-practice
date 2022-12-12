package subway.ui;

import java.util.Scanner;
import subway.constant.FunctionCommand;

public class InputView {
    private Scanner scanner;

    public FunctionCommand readFunctionCommand() {
        scanner = new Scanner(System.in);
        String command = scanner.next();
        return FunctionCommand.get(command);
    }
}
