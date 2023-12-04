package com.icecreamhead.adventofcode.q4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class ScratchcardSolver {

    private Stream<Scratchcard> resolveScratchcards(List<String> lines) {
        return lines.stream()
                .map(line -> {

                    StringTokenizer tokenizer = new StringTokenizer(line, " ");
                    boolean addToWinningNumbers = true;
                    int cardId = -1;
                    HashSet<Integer> winningNumbers = new HashSet<>();
                    HashSet<Integer> myNumbers = new HashSet<>();
                    while (tokenizer.hasMoreTokens()) {
                        String token = tokenizer.nextToken();
                        if (token.equals("Card")) {
                            cardId = Integer.parseInt(tokenizer.nextToken().replace(":", ""));
                            addToWinningNumbers = true;
                        } else if (token.equals("|")) {
                            addToWinningNumbers = false;
                        } else if (token.matches("\\d\\d?")) {
                            if (addToWinningNumbers) {
                                winningNumbers.add(Integer.parseInt(token));
                            } else {
                                myNumbers.add(Integer.parseInt(token));
                            }
                        } else {
                            throw new IllegalStateException();
                        }
                    }

                    return new Scratchcard(cardId, winningNumbers, myNumbers);
                });
    }

    long part1(List<String> lines) {
        return resolveScratchcards(lines)
                .mapToLong(card -> (long) Math.pow(2, card.countMatchingNumbers() - 1))
                .sum();
    }

    long part2(List<String> lines) {
        List<Scratchcard> cards = resolveScratchcards(lines).toList();
        Map<Integer, Integer> cardCount = new HashMap<>();
        int total = 0;

        for (Scratchcard card : cards) {
            System.out.printf("Evaluating card %d...%n", card.id);
            int copies = cardCount.compute(card.id, (k, v) -> v == null ? 1 : v);
            System.out.printf("> We have %d copies and each has %d winners%n", copies, card.countMatchingNumbers());
            for (int i = card.id + 1; i <= card.id + card.countMatchingNumbers(); i++) {
                System.out.printf(">> Card %d: %d + %d = ", i, cardCount.get(i) == null ? 1 : cardCount.get(i), cardCount.get(card.id));
                cardCount.compute(i, (k, v) -> cardCount.get(card.id) + (v == null ? 1 : v));
                System.out.printf("%d%n", cardCount.get(i));
            }
            total += cardCount.get(card.id);
            System.out.printf("Total is now %d%n", total);
        }
//    long sum = cardCount.values().stream().mapToLong(Integer::longValue).sum();
        System.out.printf("%nOverall we have %d scratchcards!%n", total);
        return total;
    }

    private record Scratchcard(int id, HashSet<Integer> winningNumbers, HashSet<Integer> myNumbers) {

        private Scratchcard(int id, HashSet<Integer> winningNumbers, HashSet<Integer> myNumbers) {
            this.id = id;
            assert ((winningNumbers.size() == 5 && myNumbers.size() == 8) || (winningNumbers.size() == 10 && myNumbers.size() == 25));
            this.winningNumbers = winningNumbers;
            this.myNumbers = myNumbers;
        }

        private long countMatchingNumbers() {
            return winningNumbers.stream().filter(myNumbers::contains).count();
        }

        @Override
        public String toString() {
            return "Scratchcard{" +
                    "id=" + id +
                    ", winningNumbers=" + winningNumbers +
                    ", myNumbers=" + myNumbers +
                    ", matchingNumbers=" + countMatchingNumbers() +
                    '}';
        }
    }
}
