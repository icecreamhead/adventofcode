package com.icecreamhead.adventofcode.q6;

import static org.assertj.core.api.Assertions.*;

import com.icecreamhead.adventofcode.util.InputLoader;
import org.junit.jupiter.api.Test;

class WaitForItTest {

  private final WaitForIt waitForIt = new WaitForIt();

  @Test
  void part1_sample() {
    assertThat(waitForIt.part1(InputLoader.loadString("q6/sample.txt"))).isEqualTo(288);
  }

  @Test
  void part1_puzzle() {
    System.out.println(waitForIt.part1(InputLoader.loadString("q6/puzzle.txt")));
  }
  @Test
  void part2_sample() {
    assertThat(waitForIt.part2(InputLoader.loadString("q6/sample.txt"))).isEqualTo(71503);
  }

  @Test
  void part2_puzzle() {
    System.out.println(waitForIt.part2(InputLoader.loadString("q6/puzzle.txt")));
  }
}