package com.icecreamhead.adventofcode.q7;



import static com.icecreamhead.adventofcode.q7.CamelCards_Part2.Card.J;
import static java.util.function.Predicate.not;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class CamelCards_Part2 {

  long totalWinnings(List<String> lines) {
    List<Hand> hands = parseHands(lines);
    long score = 0;
    int rank = hands.size();
    for (Hand hand : hands) {
      score += hand.bid * rank;
      rank--;
    }
    return score;
  }

  private static List<Hand> parseHands(List<String> lines) {
    return lines.stream()
        .map(line -> {
          String[] parts = line.split(" ");
          Card[] cards = parts[0].chars().mapToObj(Card::parse).toArray(Card[]::new);
          Card[] sortedCards = cards.clone();
          Arrays.sort(sortedCards);
          return new Hand(cards, sortedCards, Long.parseLong(parts[1]));
        })
        .sorted(RANK)
        .toList();
  }

  record Hand(Card[] cards, Card[] sortedCards, Strength strength, long bid) {

    Hand(Card[] cards, Card[] sortedCards, long bid) {
      this(cards, sortedCards, calculateStrength(sortedCards), bid);
    }

    private static Strength calculateStrength(Card[] cards) {
      if (cards[0] != J && cards[1] != J && cards[2] != J && cards[3] != J &&cards[4] !=J) {
        return calculateStrengthNotIncludingJokers(cards);
      }
      Card[] nonJokers = Arrays.stream(cards).filter(not(J::equals)).toArray(Card[]::new);
      long jokerCount = 5 - nonJokers.length;
      if (jokerCount >= 4)
        return Strength.FIVE_OF_A_KIND;
      if (jokerCount == 3)
        return nonJokers[0] == nonJokers[1] ? Strength.FIVE_OF_A_KIND : Strength.FOUR_OF_A_KIND;
      if (jokerCount == 2) {
        if (nonJokers[0] == nonJokers[1] && nonJokers[1] == nonJokers[2])
          return Strength.FIVE_OF_A_KIND;
        if (nonJokers[0] == nonJokers[1] || nonJokers[1] == nonJokers[2])
          return Strength.FOUR_OF_A_KIND;
        return Strength.THREE_OF_A_KIND;
      }
      assert jokerCount == 1 && nonJokers.length == 4;
      if (cards[0] == cards[1] && cards[1] == cards[2] && cards[2] == cards[3])
        return Strength.FIVE_OF_A_KIND;
      if ((cards[0] == cards[1] && cards[1] == cards[2]) || cards[1] == cards[2] && cards[2] == cards[3])
        return Strength.FOUR_OF_A_KIND;
      if (cards[0] == cards[1] && cards[2] == cards[3])
        return Strength.FULL_HOUSE;
      if (cards[0] == cards[1] || cards[1] == cards[2] || cards[2] == cards[3])
        return Strength.THREE_OF_A_KIND;

      return Strength.ONE_PAIR;
    }

    private static Strength calculateStrengthNotIncludingJokers(Card[] cards) {
      if (cards[1] == cards[2] && cards[2] == cards[3]) {
        if (cards[0] == cards[1] && cards[3] == cards[4])
          return Strength.FIVE_OF_A_KIND;
        if (cards[0] == cards[1] || cards[3] == cards[4])
          return Strength.FOUR_OF_A_KIND;
      }
      if (cards[0] == cards[1] && cards[1] == cards[2])
        return cards[3] == cards[4] ? Strength.FULL_HOUSE : Strength.THREE_OF_A_KIND;

      if (cards[1] == cards[2] && cards[2] == cards[3])
        return Strength.THREE_OF_A_KIND;

      if (cards[2] == cards[3] && cards[3] == cards[4])
        return cards[0] == cards[1] ? Strength.FULL_HOUSE : Strength.THREE_OF_A_KIND;

      if (cards[0] == cards[1])
        return cards[2] == cards[3] || cards[3] == cards[4] ? Strength.TWO_PAIR : Strength.ONE_PAIR;

      if (cards[1] == cards[2])
        return cards[3] == cards[4] ? Strength.TWO_PAIR : Strength.ONE_PAIR;

      if (cards[2] == cards[3] || cards[3] == cards[4])
        return Strength.ONE_PAIR;

      return Strength.HIGH_CARD;
    }

    @Override
    public String toString() {
      return "Hand{" +
             "cards=" + Arrays.toString(cards) +
             ", sortedCards=" + Arrays.toString(sortedCards) +
             ", strength=" + strength +
             ", bid=" + bid +
             '}';
    }
  }

    enum Strength {
    FIVE_OF_A_KIND, FOUR_OF_A_KIND, FULL_HOUSE, THREE_OF_A_KIND, TWO_PAIR, ONE_PAIR, HIGH_CARD
  }

  static final Comparator<Hand> RANK = (h1, h2) -> {
    int s = h1.strength.compareTo(h2.strength);
    if (s != 0) return s;
    for (int i = 0; i < 5; i++) {
      s = h1.cards[i].compareTo(h2.cards[i]);
      if (s!=0) return s;
    }
    return 0;
  };

  enum Card {
    A, K, Q, T, NINE, EIGHT, SEVEN, SIX, FIVE, FOUR, THREE, TWO, J;

    public static Card parse(int i) {
      return switch (i) {
        case 'A' -> A;
        case 'K' -> K;
        case 'Q' -> Q;
        case 'J' -> J;
        case 'T' -> T;
        case '9' -> NINE;
        case '8' -> EIGHT;
        case '7' -> SEVEN;
        case '6' -> SIX;
        case '5' -> FIVE;
        case '4' -> FOUR;
        case '3' -> THREE;
        case '2' -> TWO;
        default -> throw new IllegalStateException(""+i);
      };
    }

    @Override
    public String toString() {
      return name();
    }
  }
}
