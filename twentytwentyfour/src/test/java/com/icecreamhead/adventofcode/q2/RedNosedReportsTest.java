package com.icecreamhead.adventofcode.q2;

import static org.assertj.core.api.Assertions.assertThat;

import com.icecreamhead.adventofcode.util.InputLoader;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class RedNosedReportsTest {

  private final RedNosedReports underTest = new RedNosedReports();


  @Test
  void pt1_sample() {
    assertThat(underTest.pt1(InputLoader.loadLines("q2/sample.txt"))).isEqualTo(2);
  }

  @Test
  void pt1_puzzle() {
    System.out.println(underTest.pt1(InputLoader.loadLines("q2/puzzle.txt")));
  }


  @Test
  void pt2_sample() {
    assertThat(underTest.pt2(InputLoader.loadLines("q2/sample.txt"))).isEqualTo(4);
  }

  @Test
  void pt2_puzzle() {
    System.out.println(underTest.pt2(InputLoader.loadLines("q2/puzzle.txt")));
  }
}