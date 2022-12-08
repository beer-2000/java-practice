package baseball.domain;

import java.util.Objects;

public class GameResult {
    private final int balls;
    private final int strikes;
    private String BALL_CHARACTER = "볼 ";
    private String STRIKE_CHARACTER = "스트라이크 ";
    private String NOTHING = "낫싱";

    public GameResult(int balls, int strikes) {
        this.balls = balls;
        this.strikes = strikes;
    }

    public int getBalls() {
        return balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public boolean isOut() {
        return this.strikes == 3;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final GameResult point = (GameResult) o;
        return balls == point.balls &&
                strikes == point.strikes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls, strikes);
    }
}
