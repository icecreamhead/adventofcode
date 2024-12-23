package com.icecreamhead.adventofcode.q23;

import static org.assertj.core.api.Assertions.assertThat;

import com.icecreamhead.adventofcode.util.InputLoader;
import org.junit.jupiter.api.Test;

class LanPartyTest {

  private final LanParty underTest = new LanParty();

  @Test
  void pt1_sample() {
    assertThat(underTest.pt1(InputLoader.loadLines("q23/sample.txt"))).isEqualTo(7);
  }

  @Test
  void pt1_puzzle() {
    System.out.println(underTest.pt1(InputLoader.loadLines("q23/puzzle.txt")));
  }

  @Test
  void pt2_sample() {
    assertThat(underTest.pt2(InputLoader.loadLines("q23/sample.txt"))).isEqualTo("co,de,ka,ta");
  }

  @Test
  void pt2_puzzle() {
    System.out.println(underTest.pt2(InputLoader.loadLines("q23/puzzle.txt")));
  }
}