package baseball.ui;

import baseball.domain.GameResult;

public class OutputView {
    private String ANNOUNCEMENT_START_GAME = "숫자 야구 게임을 시작합니다.";
    private String REQUEST_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private String ANNOUNCEMENT_OUT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private String REQUEST_INPUT_RESTART_COMMAND = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private String BALL_CHARACTER = "볼 ";
    private String STRIKE_CHARACTER = "스트라이크 ";
    private String NOTHING = "낫싱";

    public void announceStartGame() {
        System.out.println(ANNOUNCEMENT_START_GAME);
    }

    public void requestInputNumber() {
        System.out.print(REQUEST_INPUT_NUMBER);
    }

    public void announceOut() {
        System.out.println(ANNOUNCEMENT_OUT);
    }

    public void requestInputOfRestartCommand() {
        System.out.println(REQUEST_INPUT_RESTART_COMMAND);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printResultSentence(GameResult gameResult) {
        StringBuilder sentenceOfResult = new StringBuilder("");
        int balls = gameResult.getBalls();
        int strikes = gameResult.getStrikes();
        sentenceOfResult.append(getSentenceOfBalls(balls));
        sentenceOfResult.append(getSentenceOfStrikes(strikes));
        if (sentenceOfResult.length() == 0) {
            System.out.println(NOTHING);
            return;
        }
        sentenceOfResult.deleteCharAt(sentenceOfResult.length() - 1);
        System.out.println(sentenceOfResult);
    }

    private String getSentenceOfBalls(int balls) {
        if (balls == 0) {
            return "";
        }
        return balls + BALL_CHARACTER;
    }

    private String getSentenceOfStrikes(int strikes) {
        if (strikes == 0) {
            return "";
        }
        return strikes + STRIKE_CHARACTER;
    }
}
