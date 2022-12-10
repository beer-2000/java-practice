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
            outputView.requestMoving();
            movingStatus = bridgeGame.move(inputView.readMoving());
            outputView.printMap(movingStatus);
            if (movingStatus.isFail()) {
                checkRetry();
            }
        } while (bridgeGame.isOnWay());
        outputView.printResult(movingStatus, bridgeGame.isSuccess(), bridgeGame.getTryCount());
    }

    private void generateBridgeGame() {
        outputView.announceStartGame();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge;
        do {
            try {
                outputView.requestBridgeSize();
                bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
                this.bridgeGame = new BridgeGame(bridge);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                outputView.printLineSeparator();
            }
        } while (true);
        outputView.printLineSeparator();
    }

    private void checkRetry() {
        outputView.requestGameCommand();
        bridgeGame.retry(inputView.readGameCommand());
    }
}
