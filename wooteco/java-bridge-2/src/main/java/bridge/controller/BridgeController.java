package bridge.controller;

import bridge.domain.BridgeGame;
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
}
