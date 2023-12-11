package com.icecreamhead.adventofcode.q11;

import static org.assertj.core.api.Assertions.assertThat;

import com.icecreamhead.adventofcode.util.InputLoader;
import org.junit.jupiter.api.Test;

class CosmicExpansionTest {

  private final CosmicExpansion underTest = new CosmicExpansion();

  private static final char[][] SAMPLE = InputLoader.loadGrid("q11/sample.txt");
  private static final char[][] PUZZLE = InputLoader.loadGrid("q11/puzzle.txt");

  @Test
  void part1_sample() {
    assertThat(underTest.part1(SAMPLE)).isEqualTo(374);
  }
  @Test
  void part1_puzzle() {
    System.out.println(underTest.part1(PUZZLE));
  }
  @Test
  void part2_sample() {
    assertThat(underTest.part2(SAMPLE, 10)).isEqualTo(1030);
    assertThat(underTest.part2(SAMPLE, 100)).isEqualTo(8410);
  }
  @Test
  void part2_puzzle() {
    System.out.println(underTest.part2(PUZZLE, 1000000));
  }
}