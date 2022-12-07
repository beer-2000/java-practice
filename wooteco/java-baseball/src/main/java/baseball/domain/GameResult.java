package baseball.domain;

public class GameResult {
    private int balls;
    private int strikes;
    private String BALL_CHARACTER = "볼 ";
    private String STRIKE_CHARACTER = "스트라이크 ";
    private String NOTHING = "낫싱";

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
        if (sentenceOfResult.length() == 0) {
            return NOTHING;
        }
        sentenceOfResult.deleteCharAt(sentenceOfResult.length() - 1);
        return sentenceOfResult.toString();
    }

    private String getSentenceOfBalls() {
        if (balls == 0) {
            return "";
        }
        return balls + BALL_CHARACTER;
    }

    private String getSentenceOfStrikes() {
        if (strikes == 0) {
            return "";
        }
        return strikes + STRIKE_CHARACTER;
    }
}
