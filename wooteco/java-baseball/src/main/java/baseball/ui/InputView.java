package baseball.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputNumber() {
        String inputNumberRaw = Console.readLine();
        return inputNumberRaw;
    }

    public String inputRestartCommand() {
        String inputRestartCommandRaw = Console.readLine();
        return inputRestartCommandRaw;
    }
}
