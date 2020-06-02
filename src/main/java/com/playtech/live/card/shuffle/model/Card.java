package com.playtech.live.card.shuffle.model;

public enum Card {

    C2(Suit.CLUBS, Rank.TWO, 1),
    C3(Suit.CLUBS, Rank.THREE, 2),
    C4(Suit.CLUBS, Rank.FOUR, 3),
    C5(Suit.CLUBS, Rank.FIVE, 4),
    C6(Suit.CLUBS, Rank.SIX, 5),
    C7(Suit.CLUBS, Rank.SEVEN, 6),
    C8(Suit.CLUBS, Rank.EIGHT, 7),
    C9(Suit.CLUBS, Rank.NINE, 8),
    C10(Suit.CLUBS, Rank.TEN, 9),
    CJ(Suit.CLUBS, Rank.JACK, 10),
    CQ(Suit.CLUBS, Rank.QUEEN, 11),
    CK(Suit.CLUBS, Rank.KING, 12),
    CA(Suit.CLUBS, Rank.ACE, 13),

    D2(Suit.DIAMONDS, Rank.TWO, 14),
    D3(Suit.DIAMONDS, Rank.THREE, 15),
    D4(Suit.DIAMONDS, Rank.FOUR, 16),
    D5(Suit.DIAMONDS, Rank.FIVE, 17),
    D6(Suit.DIAMONDS, Rank.SIX, 18),
    D7(Suit.DIAMONDS, Rank.SEVEN, 19),
    D8(Suit.DIAMONDS, Rank.EIGHT, 20),
    D9(Suit.DIAMONDS, Rank.NINE, 21),
    D10(Suit.DIAMONDS, Rank.TEN, 22),
    DJ(Suit.DIAMONDS, Rank.JACK, 23),
    DQ(Suit.DIAMONDS, Rank.QUEEN, 24),
    DK(Suit.DIAMONDS, Rank.KING, 25),
    DA(Suit.DIAMONDS, Rank.ACE, 26),

    H2(Suit.HEARTS, Rank.TWO, 27),
    H3(Suit.HEARTS, Rank.THREE, 28),
    H4(Suit.HEARTS, Rank.FOUR, 29),
    H5(Suit.HEARTS, Rank.FIVE, 30),
    H6(Suit.HEARTS, Rank.SIX, 31),
    H7(Suit.HEARTS, Rank.SEVEN, 32),
    H8(Suit.HEARTS, Rank.EIGHT, 33),
    H9(Suit.HEARTS, Rank.NINE, 34),
    H10(Suit.HEARTS, Rank.TEN, 35),
    HJ(Suit.HEARTS, Rank.JACK, 36),
    HQ(Suit.HEARTS, Rank.QUEEN, 37),
    HK(Suit.HEARTS, Rank.KING, 38),
    HA(Suit.HEARTS, Rank.ACE, 39),

    S2(Suit.SPADES, Rank.TWO, 40),
    S3(Suit.SPADES, Rank.THREE, 41),
    S4(Suit.SPADES, Rank.FOUR, 42),
    S5(Suit.SPADES, Rank.FIVE, 43),
    S6(Suit.SPADES, Rank.SIX, 44),
    S7(Suit.SPADES, Rank.SEVEN, 45),
    S8(Suit.SPADES, Rank.EIGHT, 46),
    S9(Suit.SPADES, Rank.NINE, 47),
    S10(Suit.SPADES, Rank.TEN, 48),
    SJ(Suit.SPADES, Rank.JACK, 49),
    SQ(Suit.SPADES, Rank.QUEEN, 50),
    SK(Suit.SPADES, Rank.KING, 51),
    SA(Suit.SPADES, Rank.ACE, 52);

    private final Rank rank;
    private final Suit suit;
    private final int id;

    Card(Suit suit, Rank rank, int id) {
        this.rank = rank;
        this.suit = suit;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Rank rank() {
        return rank;
    }

    public Suit suit() {
        return suit;
    }
}
