package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public String getMoneyByUser() {
        return Console.readLine();
    }

    public List<Integer> getTargetNumbersFromUser() {
        String targetNumbersRaw = Console.readLine();
        return convertNumbersRaw(targetNumbersRaw);
    }

    public int getBonusNumberFromUser() {
        String bonusNumberRaw = Console.readLine();
        return convertBonusNumber(bonusNumberRaw);
    }

    private List<Integer> convertNumbersRaw(String targetNumbersRaw) {
        try {
            return Arrays.stream(targetNumbersRaw.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 \",\"로 연결해서 입력해주세요. ex) 1,2,3,4,5,6");
        }
    }

    private int convertBonusNumber(String bonusNumberRaw) {
        try {
            return Integer.parseInt(bonusNumberRaw);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }
}
