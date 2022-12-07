package baseball.domain;

public class GameResult {
    private int balls;
    private int strikes;

    public GameResult(int balls, int strikes) {
        this.balls = balls;
        this.strikes = strikes;
    }

    public boolean isOut() {
        return this.strikes == 3;
    }
}
