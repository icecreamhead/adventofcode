package com.icecreamhead.adventofcode.q5;

import static org.assertj.core.api.Assertions.assertThat;

import com.icecreamhead.adventofcode.util.InputLoader;
import org.junit.jupiter.api.Test;

class PrintQueueTest {

  private final PrintQueue underTest = new PrintQueue();


  @Test
  void pt1_sample() {
    assertThat(underTest.pt1(InputLoader.loadLines("q5/sample.txt"))).isEqualTo(143);
  }

  @Test
  void pt1_puzzle() {
    System.out.println(underTest.pt1(InputLoader.loadLines("q5/puzzle.txt")));
  }

  @Test
  void pt2_sample() {
    assertThat(underTest.pt2(InputLoader.loadLines("q5/sample.txt"))).isEqualTo(123);
  }

  @Test
  void pt2_puzzle() {
    System.out.println(underTest.pt2(InputLoader.loadLines("q5/puzzle.txt")));
  }
}