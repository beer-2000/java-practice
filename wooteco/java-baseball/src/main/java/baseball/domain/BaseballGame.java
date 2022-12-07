package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGame {
    private List<Integer> target;

    public void init() {
        TargetMaker targetMaker = new TargetMaker();
        this.target = targetMaker.generateTargetNumbers();
    }

    public GameResult judge(String inputNumbersRaw) {
        List<Integer> inputNumbers = convertInputNumber(inputNumbersRaw);
        int balls = 0;
        int strikes = 0;
    }

    private List<Integer> convertInputNumber(String inputNumbersRaw) {
        List<Integer> inputNumbers = Arrays.stream(inputNumbersRaw.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        return inputNumbers;
    }
}
