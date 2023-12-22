package com.icecreamhead.adventofcode.q3;

import static org.assertj.core.api.Assertions.assertThat;

import com.icecreamhead.adventofcode.util.InputLoader;
import java.util.List;
import org.junit.jupiter.api.Test;

class GearRatiosTest {

  private final GearRatios underTest = new GearRatios();

  private static final char[][] SAMPLE = InputLoader.loadGrid("q3/sample.txt");
  private static final char[][] PUZZLE = InputLoader.loadGrid("q3/puzzle.txt");

  @Test
  void part1_sample() {
    assertThat(underTest.part1(SAMPLE)).isEqualTo(4361);
  }
  @Test
  void part1_puzzle() {
    System.out.println(underTest.part1(PUZZLE));
  }
  @Test
  void part2_sample() {
    assertThat(underTest.part2(SAMPLE)).isEqualTo(467835);
  }
  @Test
  void part2_puzzle() {
    System.out.println(underTest.part2(PUZZLE));
  }
}