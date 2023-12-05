package com.icecreamhead.adventofcode.q5;



import static org.assertj.core.api.Assertions.assertThat;

import com.icecreamhead.adventofcode.util.InputLoader;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class FertilizerTest {

  private final Fertilizer fertilizer = new Fertilizer();

  @Test
  void part1_sample() {
    assertThat(fertilizer.part1(InputLoader.loadLines("q5/sample.txt"))).isEqualTo(35);
  }
  @Test
  void part1_puzzle() {
    System.out.println(fertilizer.part1(InputLoader.loadLines("q5/puzzle.txt")));
  }

  @Test
  void part2_sample() {
    assertThat(fertilizer.part2(InputLoader.loadLines("q5/sample.txt"))).isEqualTo(46);
  }
  @Disabled
  @Test
  void part2_puzzle() {
    System.out.println(fertilizer.part2(InputLoader.loadLines("q5/puzzle.txt")));
  }
}