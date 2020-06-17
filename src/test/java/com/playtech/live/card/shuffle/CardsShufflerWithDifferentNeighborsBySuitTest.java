package com.playtech.live.card.shuffle;

import com.playtech.live.card.shuffle.model.Card;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

// Does we have enough tests to ensure correctness of CardsShufflerWithDifferentNeighborsBySuit ?
class CardsShufflerWithDifferentNeighborsBySuitTest {

    @Test
    void testEmptyDeck() {
        CardsShufflerWithDifferentNeighborsBySuit shuffler = new CardsShufflerWithDifferentNeighborsBySuit(ThreadLocalRandom.current());

        List<Card> shuffledDeck = shuffler.shuffleCards(List.of());
        assertThat(shuffledDeck).isEmpty();
    }

    @Test
    void testSingleCardDeck() {
        CardsShufflerWithDifferentNeighborsBySuit shuffler = new CardsShufflerWithDifferentNeighborsBySuit(ThreadLocalRandom.current());

        List<Card> shuffledDeck = shuffler.shuffleCards(List.of(Card.C3));
        assertThat(shuffledDeck).isEqualTo(List.of(Card.C3));
    }

    @Test
    void test2SameCardsDeck() {
        CardsShufflerWithDifferentNeighborsBySuit shuffler = new CardsShufflerWithDifferentNeighborsBySuit(ThreadLocalRandom.current());

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(
                        () -> shuffler.shuffleCards(List.of(Card.C3, Card.C4))
                );
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
            assertThat(cards.get(i).suit())
                    .withFailMessage("Same suit on neighbor positions: " + i + " and " + (i - 1))
                    .isNotEqualTo(cards.get(i - 1).suit());
        }
    }
}