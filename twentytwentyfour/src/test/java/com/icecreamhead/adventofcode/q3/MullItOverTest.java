package com.icecreamhead.adventofcode.q3;

import static org.assertj.core.api.Assertions.assertThat;

import com.icecreamhead.adventofcode.util.InputLoader;
import org.junit.jupiter.api.Test;

class MullItOverTest {

  private final MullItOver underTest = new MullItOver();


  @Test
  void pt1_sample() {
    String sample = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";
    assertThat(underTest.pt1(sample)).isEqualTo(161);
  }

  @Test
  void pt1_puzzle() {
    System.out.println(underTest.pt1(InputLoader.loadString("q3/puzzle.txt")));

  }

  @Test
  void pt2_sample() {
    String sample = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";
    assertThat(underTest.pt2(sample)).isEqualTo(48);
  }

  @Test
  void pt2_puzzle() {
    System.out.println(underTest.pt2(InputLoader.loadString("q3/puzzle.txt")));
  }
}