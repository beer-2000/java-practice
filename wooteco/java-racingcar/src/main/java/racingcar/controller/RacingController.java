package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.CarStatus;
import racingcar.domain.RacingGame;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class RacingController {
    private InputView inputView;
    private OutputView outputView;
    private RacingGame racingGame;
    private final String ERROR_MESSAGE_TOO_LITTLE_RACING_TIMES = "[ERROR] 1회 이상 시도해야 합니다.";

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        generateGame();
        playRacing();
        announceWinner();
    }

    private void generateGame() {
        while (true) {
            try {
                outputView.requestCarNames();
                List<String> carNames = inputView.readCarNames();
                this.racingGame = new RacingGame(carNames);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void playRacing() {
        while (true) {
            try {
                outputView.requestRacingTimes();
                int racingTimes = inputView.readRacingTimes();
                validateRacingTimes(racingTimes);
                outputView.announcePlayResult();
                IntStream.range(0, racingTimes).forEach(number -> {
                    playTurn();
                });
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void playTurn() {
        List<CarStatus> carStatuses = racingGame.playTurn();
        outputView.printRacingStatus(carStatuses);
    }

    private void announceWinner() {
        List<CarStatus> winnerCarStatuses = racingGame.getWinners();
        outputView.announceWinner(winnerCarStatuses);
    }

    private void validateRacingTimes(int racingTimes) {
        if (racingTimes <= 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_TOO_LITTLE_RACING_TIMES);
        }
    }
}
