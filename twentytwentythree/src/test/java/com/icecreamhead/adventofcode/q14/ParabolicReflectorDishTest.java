package com.icecreamhead.adventofcode.q14;

import static org.assertj.core.api.Assertions.assertThat;

import com.icecreamhead.adventofcode.util.InputLoader;
import org.junit.jupiter.api.Test;

class ParabolicReflectorDishTest {

  private final ParabolicReflectorDish underTest = new ParabolicReflectorDish();

  private static final char[][] SAMPLE = InputLoader.loadGrid("q14/sample.txt");
  private static final char[][] PUZZLE = InputLoader.loadGrid("q14/puzzle.txt");


  @Test
  void part1_sample() {
    assertThat(underTest.part1(SAMPLE)).isEqualTo(136);
  }
  @Test
  void part1_puzzle() {
    System.out.println(underTest.part1(PUZZLE));
  }

  @Test
  void part2_sample() {
    assertThat(underTest.part2(SAMPLE)).isEqualTo(64);
  }

  @Test
  void part2_puzzle() {
    System.out.println(underTest.part2(PUZZLE));
  }
}