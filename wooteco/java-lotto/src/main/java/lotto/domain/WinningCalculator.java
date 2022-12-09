package lotto.domain;

import static lotto.constant.LottoRule.COUNT_OF_NUMBERS;
import static lotto.constant.LottoRule.MAXIMUM_NUMBER;
import static lotto.constant.LottoRule.MINIMUM_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningCalculator {
    private List<Integer> targetNumbers;
    private int bonusNumber;

    public void setTargetNumbers(List<Integer> targetNumbers) {
        validateTargetNumbers(targetNumbers);
        this.targetNumbers = targetNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
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

    private int calculateCountMatch(Lotto lotto) {
        int countMatch = 0;
        for (int number : targetNumbers) {
            if (lotto.isContain(number)) {
                countMatch += 1;
            }
        }
        return countMatch;
    }

    private void validateTargetNumbers(List<Integer> targetNumbers) {
        checkSize(targetNumbers);
        checkRangeOfNumbers(targetNumbers);
        checkDuplication(targetNumbers);
    }

    private void validateBonusNumber(int bonusNumber) {
        checkRange(bonusNumber);
        checkAlreadyInTarget(bonusNumber);
    }

    private void checkSize(List<Integer> targetNumbers) {
        if (targetNumbers.size() != COUNT_OF_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야합니다. ex: 1,2,3,4,5,6");
        }
    }

    private void checkRangeOfNumbers(List<Integer> targetNumbers) {
        targetNumbers.stream()
                .forEach(number -> {
                    checkRange(number);
                });
    }

    private void checkRange(int number) {
        if (MINIMUM_NUMBER <= number && number <= MAXIMUM_NUMBER) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 1과 45 사이의 수를 입력해야 합니다.");
    }

    private void checkDuplication(List<Integer> targetNumbers) {
        Set numbersDeleteDuplication = new HashSet(targetNumbers);
        if (numbersDeleteDuplication.size() == targetNumbers.size()) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 중복 없는 6개의 숫자를 입력해주세요.");
    }

    private void checkAlreadyInTarget(int bonusNumber) {
        if (targetNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 숫자 리스트에 없는 숫자를 입력해주세요.");
        }
    }
}
