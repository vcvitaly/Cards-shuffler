package com.playtech.live.card.shuffle;


import com.playtech.live.card.shuffle.model.Card;

import java.util.List;

public interface CardsShuffler {

    List<Card> shuffleCards(List<Card> deck);
}
