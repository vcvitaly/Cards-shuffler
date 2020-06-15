package com.playtech.live.card.shuffle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.playtech.live.card.shuffle.model.Card;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

// Does we have enough tests to ensure correctness of CardsShufflerWithDifferentNeighborsBySuit ?
class CardsShufflerWithDifferentNeighborsBySuitTest {

    @Test
    void testEmptyDeck() {
        CardsShufflerWithDifferentNeighborsBySuit shuffler = new CardsShufflerWithDifferentNeighborsBySuit(ThreadLocalRandom.current());

        List<Card> shuffledDeck = shuffler.shuffleCards(List.of());
        assertTrue(shuffledDeck.isEmpty());
    }

    @Test
    void testSingleCardDeck() {
        CardsShufflerWithDifferentNeighborsBySuit shuffler = new CardsShufflerWithDifferentNeighborsBySuit(ThreadLocalRandom.current());

        List<Card> shuffledDeck = shuffler.shuffleCards(List.of(Card.C3));
        assertEquals(List.of(Card.C3), shuffledDeck);
    }

    @Test
    void test2SameCardsDeck() {
        CardsShufflerWithDifferentNeighborsBySuit shuffler = new CardsShufflerWithDifferentNeighborsBySuit(ThreadLocalRandom.current());

        assertThrows(Exception.class, () -> shuffler.shuffleCards(List.of(Card.C3, Card.C4)));
    }

    @Test
    void test3CardsDeck() {
        CardsShufflerWithDifferentNeighborsBySuit shuffler = new CardsShufflerWithDifferentNeighborsBySuit(ThreadLocalRandom.current());

        List<Card> shuffledDeck = shuffler.shuffleCards(List.of(Card.C3, Card.C4, Card.D5));
        verifyNeighborCardsHaveDifferentSuits(shuffledDeck);
    }

    @RepeatedTest(1000)
    void testShufflingOnWholeDeck() {
        CardsShufflerWithDifferentNeighborsBySuit shuffler = new CardsShufflerWithDifferentNeighborsBySuit(ThreadLocalRandom.current());

        List<Card> shuffledDeck = shuffler.shuffleCards(List.of(Card.values()));
        verifyNeighborCardsHaveDifferentSuits(shuffledDeck);
    }

    private void verifyNeighborCardsHaveDifferentSuits(List<Card> cards) {
        for (int i = 1; i < cards.size(); i++) {
            assertNotEquals(cards.get(i).suit(), cards.get(i - 1).suit(), "Same suit on neighbor positions: " + i + " and " + (i - 1));
        }
    }
}