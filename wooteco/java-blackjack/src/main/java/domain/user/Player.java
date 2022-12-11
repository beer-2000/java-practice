package domain.user;

import domain.card.Card;
import domain.card.Cards;
import java.util.List;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player {
    private final String name;
    private final double bettingMoney;
    private final Cards cards;
    private final String ANNOUNCEMENT_CARD_VALUES = "%s: %s";

    public Player(String name, double bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
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
}
