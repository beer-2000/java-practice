package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public List<String> readCarNames() {
        String carNamesRaw = Console.readLine();
        return Arrays.stream(carNamesRaw.split(","))
                .collect(Collectors.toList());

    }
}
