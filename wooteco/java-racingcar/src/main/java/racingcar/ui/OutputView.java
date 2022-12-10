package racingcar.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.CarStatus;

public class OutputView {
    private final String REQUEST_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String REQUEST_RACING_TIMES = "시도할 회수는 몇회인가요?";
    private final String ANNOUNCEMENT_PLAY_RESULT = "실행 결과";
    private final String COLON_AND_SPACES = " : ";
    private final String DASH = "-";
    private final String ANNOUNCEMENT_WINNERS = "최종 우승자 : ";

    public void requestCarNames() {
        System.out.println(REQUEST_CAR_NAMES);
    }

    public void requestRacingTimes() {
        System.out.println(REQUEST_RACING_TIMES);
    }

    public void announcePlayResult() {
        System.out.println();
        System.out.println(ANNOUNCEMENT_PLAY_RESULT);
    }

    public void printRacingStatus(List<CarStatus> carStatuses) {
        carStatuses.stream().forEach(carStatus -> {
            printCarStatus(carStatus);
        });
        System.out.println();
    }

    private void printCarStatus(CarStatus carStatus) {
        System.out.print(carStatus.getName());
        System.out.print(COLON_AND_SPACES);
        IntStream.range(0, carStatus.getPosition()).forEach(number -> {
            System.out.print(DASH);
        });
        System.out.println();
    }

    public void announceWinner(List<CarStatus> winnerCarStatuses) {
        List<String> winners = new ArrayList<>();
        winnerCarStatuses.stream().forEach(carStatus -> {
            winners.add(carStatus.getName());
        });
        System.out.println(ANNOUNCEMENT_WINNERS);
        System.out.println(String.join(", ", winners));
    }
}
