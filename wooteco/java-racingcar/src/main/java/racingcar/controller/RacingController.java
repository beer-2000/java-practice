package racingcar.controller;

import java.util.List;
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
    }

    private void generateGame() {
        outputView.requestCarNames();
        List<String> carNames = inputView.readCarNames();
        this.racingGame = new RacingGame(carNames);
    }
}
