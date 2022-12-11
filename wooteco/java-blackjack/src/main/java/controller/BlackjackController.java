package controller;

import domain.Blackjack;
import domain.user.Dealer;
import domain.user.Player;
import java.util.List;
import ui.InputView;
import ui.OutputView;

public class BlackjackController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Blackjack blackjack;
    private Dealer dealer;
    private List<Player> players;

    public BlackjackController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.blackjack = new Blackjack();
        this.dealer = new Dealer();
    }

    public void start() {
        generatePlayers();
    }

    private void generatePlayers() {
        outputView.requestPlayerNames();
        List<String> playerNames = inputView.readPlayerNames();
        playerNames.stream().forEach(name -> {
            outputView.requestBettingMoney(name);
            double bettingMoney = inputView.readBettingMoney();
            players.add(new Player(name, bettingMoney));
        });
    }
}
