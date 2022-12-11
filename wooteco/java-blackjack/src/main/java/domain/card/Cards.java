package domain.card;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    private List<Card> cards;

    public Cards() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public List<String> getValues() {
        List<String> values = new ArrayList<>();
        cards.stream().forEach(card -> {
            values.add(card.getValue());
        });
        return values;
    }
}
