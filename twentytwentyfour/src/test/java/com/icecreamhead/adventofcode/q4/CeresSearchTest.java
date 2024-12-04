package com.icecreamhead.adventofcode.q4;

import static org.assertj.core.api.Assertions.assertThat;

import com.icecreamhead.adventofcode.util.InputLoader;
import org.junit.jupiter.api.Test;

class CeresSearchTest {

  private final CeresSearch underTest = new CeresSearch();


  @Test
  void pt1_sample() {
    assertThat(underTest.pt1(InputLoader.loadGrid("q4/sample.txt"))).isEqualTo(18);
  }

  @Test
  void pt1_puzzle() {
    System.out.println(underTest.pt1(InputLoader.loadGrid("q4/puzzle.txt")));
  }

  @Test
  void pt2_sample() {
    assertThat(underTest.pt2(InputLoader.loadGrid("q4/sample.txt"))).isEqualTo(9);
  }

  @Test
  void pt2_puzzle() {
    System.out.println(underTest.pt2(InputLoader.loadGrid("q4/puzzle.txt")));
  }
}