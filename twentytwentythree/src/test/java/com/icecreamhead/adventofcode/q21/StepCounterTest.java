package com.icecreamhead.adventofcode.q21;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

import com.icecreamhead.adventofcode.util.InputLoader;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

class StepCounterTest {

  private final StepCounter underTest = new StepCounter();

  private char[][] SAMPLE;
  private char[][] PUZZLE;

  @BeforeEach
  void setUp() {
    SAMPLE = InputLoader.loadGrid("q21/sample.txt");
    PUZZLE = InputLoader.loadGrid("q21/puzzle.txt");
  }

  @Test
  void part1_sample() {
    assertThat(underTest.part1(SAMPLE, 6)).isEqualTo(16);
  }

  @Test
  void part1_puzzle() {
    System.out.println(underTest.part1(PUZZLE, 64));
  }


  @ParameterizedTest
  @MethodSource
  void part2_sample(int in, long out) {
    assertThat(underTest.part2(SAMPLE, in)).isEqualTo(out);
  }

  static List<Arguments> part2_sample() {
    return List.of(
        of(6, 16),
        of(10, 50),
        of(10, 50),
        of(50, 1594),
        of(100, 6536),
        of(500, 167004),
        of(1000, 668697),
        of(5000, 16733044)
    );
  }

  @Test
  void part2_puzzle() {
    System.out.println(underTest.part2(PUZZLE, 26501365));
  }

}