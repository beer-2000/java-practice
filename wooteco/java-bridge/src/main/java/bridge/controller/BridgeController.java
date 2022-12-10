package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.ui.InputView;
import bridge.ui.OutputView;

public class BridgeController {
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }
}
