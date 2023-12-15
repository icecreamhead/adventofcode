package com.icecreamhead.adventofcode.q15;

import static org.assertj.core.api.Assertions.assertThat;

import com.icecreamhead.adventofcode.util.InputLoader;
import org.junit.jupiter.api.Test;

class LensLibraryTest {

  private final LensLibrary underTest = new LensLibrary();

  private static final String SAMPLE = InputLoader.loadString("q15/sample.txt");
  private static final String PUZZLE = InputLoader.loadString("q15/puzzle.txt");

  @Test
  void part1_sample() {
    assertThat(underTest.part1(SAMPLE)).isEqualTo(1320);
  }
  @Test
  void part2_sample() {
    assertThat(underTest.part2(SAMPLE)).isEqualTo(145);
  }
  @Test
  void part1_puzzle() {
    System.out.println(underTest.part1(PUZZLE));
  }
  @Test
  void part2_puzzle() {
    System.out.println(underTest.part2(PUZZLE));
  }

  @Test
  void testHASH() {
    assertThat(LensLibrary.HASH("rn")).isEqualTo(0);
    assertThat(LensLibrary.HASH("qp")).isEqualTo(1);
    assertThat(LensLibrary.HASH("pc")).isEqualTo(3);
  }
}