package baseball.ui;

public class OutputView {
    private String ANNOUNCEMENT_START_GAME = "숫자 야구 게임을 시작합니다.";
    private String REQUEST_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private String ANNOUNCEMENT_OUT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void announceStartGame() {
        System.out.println(ANNOUNCEMENT_START_GAME);
    }

    public void requestInputNumber() {
        System.out.print(REQUEST_INPUT_NUMBER);
    }

    public void printResultOfTurn(String resultSentence) {
        System.out.println(resultSentence);
    }

    public void announceOut() {
        System.out.println(ANNOUNCEMENT_OUT);
    }
}
