package baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGame {
    private List<Integer> target;
    private boolean isEnd;

    public void init() {
        TargetMaker targetMaker = new TargetMaker();
        this.target = targetMaker.generateTargetNumbers();
        this.isEnd = false;
    }

    public GameResult judge(String inputNumbersRaw) {
        List<Integer> inputNumbers = convertInputNumber(inputNumbersRaw);
        int balls = 0;
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (inputNumbers.get(i) == target.get(i)) {
                strikes += 1;
                continue;
            }
            if (target.contains(inputNumbers.get(i))) {
                balls += 1;
            }
        }
        return new GameResult(balls, strikes);
    }

    public void judgeRestart(String restartCommand) {
        if (restartCommand.equals("2")) {
            this.isEnd = true;
        }
    }

    public boolean isEnd() {
        return isEnd;
    }

    private List<Integer> convertInputNumber(String inputNumbersRaw) {
        validateNumbersRaw(inputNumbersRaw);
        List<Integer> inputNumbers = Arrays.stream(inputNumbersRaw.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        validateNumbers(inputNumbers);
        return inputNumbers;
    }

    private void validateNumbersRaw(String inputNumbersRaw) {
        try {
            Integer.parseInt(inputNumbersRaw);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 세자리 수를 입력하세요.");
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.contains(0)) {
            throw new IllegalArgumentException("[ERROR] 1부터 9까지의 세자리 수를 입력하세요.");
        }
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("[ERROR] 세자리 수를 입력하세요.");
        }
    }
}
