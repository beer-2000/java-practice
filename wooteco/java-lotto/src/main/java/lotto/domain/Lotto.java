package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자의 개수가 잘못된 로또가 생성되었습니다.");
        }
        checkDuplication(numbers);
    }

    private void checkDuplication(List<Integer> numbers) {
        Set numbersDeleteDuplication = new HashSet(numbers);
        if (numbersDeleteDuplication.size() == numbers.size()) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 중복된 번호를 가진 로또가 생성되었습니다.");
    }
}
