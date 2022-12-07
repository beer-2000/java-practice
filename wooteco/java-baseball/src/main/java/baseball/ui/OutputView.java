package baseball.ui;

public class OutputView {
    private String ANNOUNCEMENT_START_GAME = "숫자 야구 게임을 시작합니다.";

    public void announceStartGame() {
        System.out.println(ANNOUNCEMENT_START_GAME);
    }

    public void printResultOfTurn(String resultSentence) {
        System.out.println(resultSentence);
    }
}
