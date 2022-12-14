package subway.ui;

import java.util.Scanner;
import subway.constant.MainCommand;

public class InputView {
    private Scanner scanner;
    private final String REQUEST_MAIN_COMMAND = "## 원하는 기능을 선택하세요.";

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public MainCommand readMainCommand() {
        System.out.println(REQUEST_MAIN_COMMAND);
        return MainCommand.get(scanner.nextLine());
    }
}
