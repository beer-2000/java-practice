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
        List<Integer> inputNumbers = Arrays.stream(inputNumbersRaw.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        return inputNumbers;
    }
}
