package controller;

import domain.Blackjack;
import ui.InputView;
import ui.OutputView;

public class BlackjackController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Blackjack blackjack;

    public BlackjackController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.blackjack = new Blackjack();
    }

    public void start() {
        
    }
}
