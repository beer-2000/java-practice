package baseball.domain;

import java.util.List;

public class BaseballGame {
    private List<Integer> target;

    public void init() {
        TargetMaker targetMaker = new TargetMaker();
        this.target = targetMaker.generateTargetNumbers();
    }
}
