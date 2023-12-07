package com.icecreamhead.adventofcode.q7;

import static org.assertj.core.api.Assertions.*;

import com.icecreamhead.adventofcode.util.InputLoader;
import org.junit.jupiter.api.Test;

class CamelCardsTest {

  private final CamelCards_Part1 camelCardsPart1 = new CamelCards_Part1();
  private final CamelCards_Part2 camelCardsPart2 = new CamelCards_Part2();

  @Test
  void part1_sample() {
    assertThat(camelCardsPart1.totalWinnings(InputLoader.loadLines("q7/sample.txt"))).isEqualTo(6440);
  }
  @Test
  void part1_puzzle() {
    System.out.println(camelCardsPart1.totalWinnings(InputLoader.loadLines("q7/puzzle.txt")));
  }

  @Test
  void part2_sample() {
    assertThat(camelCardsPart2.totalWinnings(InputLoader.loadLines("q7/sample.txt"))).isEqualTo(5905);
  }
  @Test
  void part2_puzzle() {
    System.out.println(camelCardsPart2.totalWinnings(InputLoader.loadLines("q7/puzzle.txt")));
  }

}