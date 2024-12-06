package com.icecreamhead.adventofcode.q6;

import static org.assertj.core.api.Assertions.assertThat;

import com.icecreamhead.adventofcode.util.InputLoader;
import org.junit.jupiter.api.Test;

class GuardGallivantTest {

  private final GuardGallivant underTest = new GuardGallivant();


  @Test
  void pt1_sample() {
    assertThat(underTest.pt1(InputLoader.loadGrid("q6/sample.txt"))).isEqualTo(41);
  }

  @Test
  void pt1_puzzle() {
    System.out.println(underTest.pt1(InputLoader.loadGrid("q6/puzzle.txt")));
  }

  @Test
  void pt2_sample() {
    assertThat(underTest.pt2(InputLoader.loadGrid("q6/sample.txt"))).isEqualTo(6);
  }

  @Test
  void pt2_puzzle() {
    System.out.println(underTest.pt2(InputLoader.loadGrid("q6/puzzle.txt")));
  }
}