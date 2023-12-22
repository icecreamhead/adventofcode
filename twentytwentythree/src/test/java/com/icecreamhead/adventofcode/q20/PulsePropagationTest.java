package com.icecreamhead.adventofcode.q20;

import static org.assertj.core.api.Assertions.assertThat;

import com.icecreamhead.adventofcode.util.InputLoader;
import java.util.List;
import org.junit.jupiter.api.Test;

class PulsePropagationTest {

  private final PulsePropagation underTest = new PulsePropagation();

  private static final List<String> SAMPLE1 = InputLoader.loadLines("q20/sample1.txt");
  private static final List<String> SAMPLE2 = InputLoader.loadLines("q20/sample2.txt");
  private static final List<String> PUZZLE = InputLoader.loadLines("q20/puzzle.txt");

  @Test
  void part1_sample1() {
    assertThat(underTest.part1(SAMPLE1)).isEqualTo(32000000);
  }
  @Test
  void part1_sample2() {
    assertThat(underTest.part1(SAMPLE2)).isEqualTo(11687500);
  }

  @Test
  void part1_puzzle() {
    System.out.println(underTest.part1(PUZZLE));
  }
}