package com.playtech.live.card.shuffle.model;

public enum Suit {

    CLUBS("C", '♣', '♧'),
    DIAMONDS("D", '♦', '♢'),
    HEARTS("H", '♥', '♡'),
    SPADES("S", '♠', '♤');

    final String value;
    final char blackSymbol;
    final char whiteSymbol;

    Suit(String value, char blackSymbol, char whiteSymbol) {
        this.value = value;
        this.blackSymbol = blackSymbol;
        this.whiteSymbol = whiteSymbol;
    }
}
