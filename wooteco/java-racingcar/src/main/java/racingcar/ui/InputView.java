package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private final String ERROR_MESSAGE_WRONG_RACING_TIMES = "[ERROR] 잘못된 시도 횟수를 입력했습니다.";

    public List<String> readCarNames() {
        String carNamesRaw = Console.readLine();
        return Arrays.stream(carNamesRaw.split(","))
                .collect(Collectors.toList());

    }

    public int readRacingTimes() {
        try {
            String racingTimesRaw = Console.readLine();
            return Integer.parseInt(racingTimesRaw);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_WRONG_RACING_TIMES);
        }
    }
}
