package domain.user;

import static constant.BlackjackRule.BLACKJACK_NUMBER;
import static constant.BlackjackRule.MINIMUM_COUNT_OF_CARDS;

import domain.card.Card;
import domain.card.Cards;
import java.util.List;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer {
    private final Cards cards;
    private final String ANNOUNCEMENT_CARD_VALUES = "딜러: %s";

    public Dealer() {
        this.cards = new Cards();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public String getCardsToPrint() {
        List<String> cardValues = cards.getValues();
        String cardNamesJoined = String.join(", ", cardValues);
        return String.format(ANNOUNCEMENT_CARD_VALUES, cardNamesJoined);
    }

    public boolean isBlackJack() {
        if (cards.getScoreSum() == BLACKJACK_NUMBER && cards.getSize() == MINIMUM_COUNT_OF_CARDS) {
            return true;
        }
        return false;
    }

    public int getScore() {
        return cards.getScoreSum();
    }
}
