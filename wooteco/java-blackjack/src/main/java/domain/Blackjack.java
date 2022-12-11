package domain;

import domain.card.Card;
import domain.card.CardFactory;
import java.util.ArrayList;
import java.util.List;

public class Blackjack {
    private List<Card> cardDummy;
    private List<Card> usedCards;

    public Blackjack() {
        this.cardDummy = CardFactory.create();
        usedCards = new ArrayList<>();
    }
}
