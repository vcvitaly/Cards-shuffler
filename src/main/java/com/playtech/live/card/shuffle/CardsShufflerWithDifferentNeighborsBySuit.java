package com.playtech.live.card.shuffle;

import com.playtech.live.card.shuffle.model.Card;

import com.playtech.live.card.shuffle.model.Suit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        if (deck.size() <= 1) {
            return deck;
        }

        List<Card> shuffledCards = new ArrayList<>();

        Map<Suit, List<Card>> sortedBySuit = groupBySuitAndShuffleEachDeck(deck, random);

        shuffledCards.add(
                pickCardWithSuitePredicate(sortedBySuit, s -> true)
                        .orElseThrow(
                                () -> new IllegalStateException("Optional cannot be empty at this stage, something went wrong")
                        )
        );

        IntStream.range(1, deck.size()).forEach(i -> shuffledCards.add(
                pickCardWithSuitePredicate(
                        sortedBySuit, s -> s != shuffledCards.get(i - 1).suit()
                ).orElseThrow(
                        () -> new IllegalArgumentException("Cannot shuffle " + deck)
                )
        ));

        return shuffledCards;
    }

    private Map<Suit, List<Card>> groupBySuitAndShuffleEachDeck(List<Card> deck, Random random) {
        Map<Suit, List<Card>> groupedBy = deck.stream().collect(Collectors.groupingBy(Card::suit));
        groupedBy.values().forEach(cards -> Collections.shuffle(cards, random));
        return groupedBy;
    }

    public Optional<Card> pickCardWithSuitePredicate(Map<Suit, List<Card>> sortedBySuit, Predicate<Suit> p) {

        return sortedBySuit.keySet().stream()
                .filter(p)
                .map(sortedBySuit::get)
                .max(Comparator.comparingInt(List::size))
                .map(cards -> cards.remove(0));
    }
}
