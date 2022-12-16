package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgePicture;
import bridge.ui.InputView;
import bridge.ui.OutputView;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        outputView.announceStartGame();
        createBridgeGame();
        playGame();
    }

    private void createBridgeGame() {
        while (true) {
            try {
                int bridgeSize = inputView.readBridgeSize();
                this.bridgeGame = new BridgeGame(bridgeSize);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void playGame() {
        do {
            playTurn();
        } while (bridgeGame.isOnWay());
        announceFinalResult();
    }

    private void playTurn() {
        move();
        BridgePicture bridgePicture = bridgeGame.getPicture();
        outputView.printMap(bridgePicture);
        if (bridgePicture.isFail()) {
            checkRetry();
        }
    }

    private void move() {
        while (true) {
            try {
                bridgeGame.move(inputView.readMoving());
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void checkRetry() {
        while (true) {
            try {
//                bridgeGame.retry(inputView.readGameCommand());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void announceFinalResult() {
        BridgePicture bridgePicture = bridgeGame.getPicture();
        boolean isSuccess = bridgePicture.isSuccess();
        int tryCount = bridgeGame.getTryCount();
//        outputView.printResult(bridgePicture, isSuccess, tryCount);
    }
}
