package domain.user;

import static constant.BlackjackRule.BLACKJACK_NUMBER;
import static constant.BlackjackRule.GET_CARD_COMMAND;
import static constant.BlackjackRule.MINIMUM_COUNT_OF_CARDS;

import domain.card.Card;
import domain.card.Cards;
import java.util.List;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player {
    private final String name;
    private double money;
    private final Cards cards;
    private final String ANNOUNCEMENT_CARD_VALUES = "%s: %s";

    public Player(String name, double bettingMoney) {
        this.name = name;
        this.money = bettingMoney;
        this.cards = new Cards();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public String getName() {
        return name;
    }

    public String getCardsToPrint() {
        List<String> cardValues = cards.getValues();
        String cardNamesJoined = String.join(", ", cardValues);
        return String.format(ANNOUNCEMENT_CARD_VALUES, name, cardNamesJoined);
    }

    public void calculateResultWhenDealerIsBlackjack() {
        if (isBlackJack()) {
            return;
        }
        money = money * (-1);
    }

    public boolean isBlackJack() {
        if (cards.getScoreSum() == BLACKJACK_NUMBER && cards.getSize() == MINIMUM_COUNT_OF_CARDS) {
            return true;
        }
        return false;
    }

    public boolean isUnderBlackjack() {
        int score = cards.getScoreSum();
        System.out.println(name);
        System.out.println(score);
        return score < BLACKJACK_NUMBER;
    }

    public boolean judgeRedistribution(String getCardCommand) {
        if (getCardCommand.equals(GET_CARD_COMMAND)) {
            return true;
        }
        return false;
    }
}
