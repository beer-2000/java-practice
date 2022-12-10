package racingcar.ui;

public class OutputView {
    private final String REQUEST_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String REQUEST_RACING_TIMES = "시도할 회수는 몇회인가요?";

    public void requestCarNames() {
        System.out.println(REQUEST_CAR_NAMES);
    }

    public void requestRacingTimes() {
        System.out.println(REQUEST_RACING_TIMES);
    }
}
