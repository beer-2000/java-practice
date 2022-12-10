package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.MovingStatus;
import bridge.ui.InputView;
import bridge.ui.OutputView;
import java.util.List;

public class BridgeController {
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        generateBridgeGame();
        MovingStatus movingStatus;
        do {
            movingStatus = bridgeGame.move();
            outputView.printMap(movingStatus);
            if (movingStatus.isFail()) {
                checkRetry();
            }
        } while (bridgeGame.isStop());
        outputView.printResult(movingStatus);
    }

    private void generateBridgeGame() {
        outputView.announceStartGame();
        outputView.requestBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        outputView.printLineSeparator();
        this.bridgeGame = new BridgeGame(bridge);
    }

    private void checkRetry() {
        outputView.requestGameCommand();
        bridgeGame.retry(inputView.readGameCommand());
    }
}
