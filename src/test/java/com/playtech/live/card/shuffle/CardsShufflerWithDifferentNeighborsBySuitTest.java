package com.playtech.live.card.shuffle;

import com.playtech.live.card.shuffle.model.Card;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

// Does we have enough tests to ensure correctness of CardsShufflerWithDifferentNeighborsBySuit ?
class CardsShufflerWithDifferentNeighborsBySuitTest {

    @RepeatedTest(1000)
    void testShufflingOnWholeDeck() {
        CardsShufflerWithDifferentNeighborsBySuit shuffler = new CardsShufflerWithDifferentNeighborsBySuit(ThreadLocalRandom.current());

        List<Card> shuffledDeck = shuffler.shuffleCards(List.of(Card.values()));
        verifyAnswerIntegrity(shuffledDeck);
    }

    // Does it work correctly always
    private void verifyAnswerIntegrity(List<Card> cards) {
        for (int i = 1; i < cards.size() - 1; i++) {
            Assertions.assertNotEquals(cards.get(i).suit(), cards.get(i - 1).suit(), "Same suit on neighbor positions: " + i + " and " + (i - 1));
            Assertions.assertNotEquals(cards.get(i).suit(), cards.get(i + 1).suit(), "Same suit on neighbor positions: " + i + " and " + (i + 1));
        }
    }
}