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

    public ResultTable calculateResultOfLottos(List<Lotto> lottos) {
        ResultTable resultTable = new ResultTable();
        for (Lotto lotto : lottos) {
            int countMatch = calculateCountMatch(lotto);
            boolean isContainBonusNumber = lotto.isContain(bonusNumber);
            WinningResult winningResult = WinningResult.match(countMatch, isContainBonusNumber);
            resultTable.add(winningResult);
        }
        return resultTable;
    }

    private List<Integer> convertNumbersRaw(String targetNumbersRaw) {
        return Arrays.stream(targetNumbersRaw.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int calculateCountMatch(Lotto lotto) {
        int countMatch = 0;
        for (int number : targetNumbers) {
            if (lotto.isContain(number)) {
                countMatch += 1;
            }
        }
        return countMatch;
    }
}
