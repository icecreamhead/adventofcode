package com.icecreamhead.adventofcode.q8;

import static org.assertj.core.api.Assertions.assertThat;

import com.icecreamhead.adventofcode.util.InputLoader;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HauntedWastelandTest {

  private final HauntedWasteland underTest = new HauntedWasteland();

  private final List<String> sample = InputLoader.loadLines("q8/sample.txt");
//  private final List<String> puzzle = InputLoader.loadLines("q8/puzzle.txt");

  @Test
  void part1_sample() {
    assertThat(underTest.steps(sample)).isEqualTo(6);
  }
}