package com.playtech.live.card.shuffle;

import com.playtech.live.card.shuffle.model.Card;

import java.util.List;
import java.util.Random;

/**
 * This shuffler should provide shuffled deck that meets following condition:
 * If we take some position in the resulted list, than it's neighbors should have not equal suit with it,
 * More formally, for all indexes in resulted list should meet next condition: cards[i].suit != cards[i - 1].suit && cards[i].suit != cards[i + 1].suit
 *
 * For example:
 * if we have input cards equal to [C3, C5, D3, SA],
 * following permutations are correct:
 * - [C3, D3, SA, C5]
 * - [SA, C5, D3, S3]
 * and [D3, C3, C5, SA] isn't
 *
 * Note:
 * - What if we can't meet this conditions in any permutation of deck?
 * - What if only one permutation that meet conditions exists?
 * - What the time limit has implementation?
 * - Any other questions that should be asked?
 */
public class CardsShufflerWithDifferentNeighborsBySuit implements CardsShuffler {

    private final Random random;

    public CardsShufflerWithDifferentNeighborsBySuit(Random random) {
        this.random = random;
    }

    public List<Card> shuffleCards(List<Card> deck) {
        throw new RuntimeException("Not implemented");
    }
}
