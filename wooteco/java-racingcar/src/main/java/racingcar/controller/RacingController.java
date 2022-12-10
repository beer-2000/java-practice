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

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        generateGame();
        playRacing();
    }

    private void generateGame() {
        outputView.requestCarNames();
        List<String> carNames = inputView.readCarNames();
        this.racingGame = new RacingGame(carNames);
    }

    private void playRacing() {
        outputView.requestRacingTimes();
        outputView.announcePlayResult();
        int racingTimes = inputView.readRacingTimes();
        IntStream.range(0, racingTimes).forEach(number -> {
            playTurn();
        });
    }

    private void playTurn() {
        List<CarStatus> carStatuses = racingGame.move();
        outputView.printRacingStatus(carStatuses);
    }
}
