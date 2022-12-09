package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningCalculator {
    private List<Integer> targetNumbers;
    private int bonusNumber;

    public WinningCalculator(String targetNumbersRaw, String bonusNumberRaw) {
        this.targetNumbers = convertNumbersRaw(targetNumbersRaw);
        this.bonusNumber = Integer.parseInt(bonusNumberRaw);
    }

    private List<Integer> convertNumbersRaw(String targetNumbersRaw) {
        return Arrays.stream(targetNumbersRaw.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
