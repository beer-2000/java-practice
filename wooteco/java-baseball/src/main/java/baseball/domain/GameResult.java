package baseball.domain;

public class GameResult {
    private int balls;
    private int strikes;

    public GameResult(int balls, int strikes) {
        this.balls = balls;
        this.strikes = strikes;
        String BALL_CHARACTER = "볼 ";
        String STRIKE_CHARACTER = "스트라이크 ";
    }

    public boolean isOut() {
        return this.strikes == 3;
    }

    public String getSentence() {
        StringBuilder sentenceOfResult = new StringBuilder("");
        sentenceOfResult.append(getSentenceOfBalls());
    }

    private String getSentenceOfBalls() {
        if (balls == 0) {
            return "";
        }
        return balls + "볼 ";
    }
}
