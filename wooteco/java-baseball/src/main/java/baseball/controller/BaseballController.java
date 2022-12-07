package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.GameResult;
import baseball.ui.InputView;
import baseball.ui.OutputView;

public class BaseballController {
    private BaseballGame baseballGame;
    private InputView inputView;
    private OutputView outputView;

    public BaseballController() {
        this.baseballGame = new BaseballGame();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void play() {
        outputView.announceStartGame();
        do {
            playGame();
        } while (!baseballGame.isEnd());
    }

    public void playGame() {
        baseballGame.init();
        GameResult gameResult;
        do {
            gameResult = playTurn();
            outputView.printResultOfTurn(gameResult.getSentence());
        } while (!gameResult.isOut());
        String restartCommand = getRestartCommandFromUser();
        baseballGame.judgeRestart(restartCommand);
    }

    public GameResult playTurn() {
        outputView.requestInputNumber();
        String inputNumbersRaw = inputView.inputNumber();
        GameResult gameResult = baseballGame.judge(inputNumbersRaw);
        return gameResult;
    }

    private String getRestartCommandFromUser() {
        outputView.announceOut();
        outputView.requestInputOfRestartCommand();
        String restartCommand = inputView.inputRestartCommand();
        return restartCommand;
    }
}
