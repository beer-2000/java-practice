package controller;

import domain.Blackjack;
import domain.user.Dealer;
import domain.user.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
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
        this.players = new ArrayList<>();
    }

    public void start() {
        generatePlayers();
        startGame();
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

    private void startGame() {
        outputView.announceDistribution(getPlayerNames());
        IntStream.range(0, 2).forEach(number -> {
            dealer.addCard(blackjack.getNewCard());
            addCardToEachPlayers();
        });
        outputView.printCards(dealer.getCardsToPrint());
        printCardsOfEachPlayers();
    }

    private void addCardToEachPlayers() {
        players.stream().forEach(player -> {
            player.addCard(blackjack.getNewCard());
        });
    }

    private void printCardsOfEachPlayers() {
        players.stream().forEach(player -> {
            outputView.printCards(player.getCardsToPring());
        });
    }
}
