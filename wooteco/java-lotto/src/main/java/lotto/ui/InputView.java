package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getMoneyByUser() {
        return Console.readLine();
    }

    public String getTargetNumbersFromUser() {
        return Console.readLine();
    }

    public String getBonusNumberFromUser() {
        return Console.readLine();
    }
}
