package domain.card;

import static constant.BlackjackRule.ACE_ADVANTAGE;
import static constant.BlackjackRule.BLACKJACK_NUMBER;

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

    public int getScoreSum() {
        if (haveAce()) {
            return getScoreSumContainAce();
        }
        return getScoreSumWithoutAce();
    }

    public int getSize() {
        return cards.size();
    }

    private int getScoreSumWithoutAce() {
        return cards.stream().map(card -> card.getScore())
                .mapToInt(score -> score)
                .sum();
    }

    private boolean haveAce() {
        for (Card card : cards) {
            if (card.isAce()) {
                return true;
            }
        }
        return false;
    }

    private int getScoreSumContainAce() {
        int scoreSum = getScoreSumWithoutAce();
        if (scoreSum + ACE_ADVANTAGE > BLACKJACK_NUMBER) {
            return scoreSum;
        }
        scoreSum += ACE_ADVANTAGE;
        return scoreSum;
    }
}
