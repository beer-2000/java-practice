package lotto.domain;

import static lotto.constant.LottoRule.COUNT_OF_NUMBERS;
import static lotto.constant.LottoRule.MAXIMUM_NUMBER;
import static lotto.constant.LottoRule.MINIMUM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class NumbersGenerator {
    public static List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MINIMUM_NUMBER, MAXIMUM_NUMBER, COUNT_OF_NUMBERS
        );
        return numbers;
    }
}
