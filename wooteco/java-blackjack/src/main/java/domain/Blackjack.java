package domain;

import domain.card.Card;
import domain.card.CardFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Blackjack {
    private List<Card> cardDummy;
    private List<Card> usedCards;

    public Blackjack() {
        this.cardDummy = CardFactory.create();
        usedCards = new ArrayList<>();
    }

    public Card getNewCard() {
        Random random = new Random();
        Card card;
        do {
            card = cardDummy.get(random.nextInt(52));
        } while (usedCards.contains(card));
        usedCards.add(card);
        return card;
    }
}
