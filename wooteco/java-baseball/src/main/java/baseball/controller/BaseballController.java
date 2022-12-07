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
        } while (baseballGame.isEnd());
    }

    public void playGame() {
        baseballGame.init();
        do {
            GameResult gameResult = playTurn();
            outputView.printResultOfTurn(gameResult.getSentence());
        } while (GameResult.isOut());
        outputView.announceOut();
        outputView.requestInputOfRestartCommand();
        String restartCommand = inputView.inputRestartCommand();
        baseballGame.judgeRestart(restartCommand);
    }

    public GameResult playTurn() {
        outputView.requestInputNumber();
        String inputNumberRaw = inputView.inputNumber();
        GameResult gameResult = baseballGame.judge(inputNumberRaw);
        return gameResult;
    }
}
