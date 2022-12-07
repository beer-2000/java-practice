package baseball.domain;

public class GameResult {
    private int balls;
    private int strikes;
    private String BALL_CHARACTER = "볼 ";
    private String STRIKE_CHARACTER = "스트라이크 ";

    public GameResult(int balls, int strikes) {
        this.balls = balls;
        this.strikes = strikes;
    }

    public boolean isOut() {
        return this.strikes == 3;
    }

    public String getSentence() {
        StringBuilder sentenceOfResult = new StringBuilder("");
        sentenceOfResult.append(getSentenceOfBalls());
        sentenceOfResult.append(getSentenceOfStrikes());
    }

    private String getSentenceOfBalls() {
        if (balls == 0) {
            return "";
        }
        return balls + BALL_CHARACTER;
    }

    private String getSentenceOfStrikes() {
        if (balls == 0) {
            return "";
        }
        return balls + STRIKE_CHARACTER;
    }
}
