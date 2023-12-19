package com.icecreamhead.adventofcode.q19;

import static org.assertj.core.api.Assertions.assertThat;

import com.icecreamhead.adventofcode.q19.Aplenty.PartRange;
import com.icecreamhead.adventofcode.util.InputLoader;
import java.util.List;
import org.junit.jupiter.api.Test;

class AplentyTest {

  private final Aplenty underTest = new Aplenty();

  private static final String SAMPLE = InputLoader.loadString("q19/sample.txt");
  private static final String PUZZLE = InputLoader.loadString("q19/puzzle.txt");

  @Test
  void part1_sample() {
    String[] parts = SAMPLE.split("\n\n");
    assertThat(underTest.part1(parts[0].lines().toList(), parts[1].lines().toList())).isEqualTo(19114);
  }
  @Test
  void part1_custom() {
    String[] parts = SAMPLE.split("\n\n");
    assertThat(underTest.part1(parts[0].lines().toList(), List.of(
        "{x=2441,m=1,a=2006,s=538}",
        "{x=2441,m=2089,a=4000,s=538}",
        "{x=4000,m=1,a=2006,s=1350}",
        "{x=4000,m=2089,a=4000,s=1350}"
    ))).isEqualTo(0);
  }
  @Test
  void part2_sample() {
    String[] parts = SAMPLE.split("\n\n");
    assertThat(underTest.part2(parts[0].lines().toList())).isEqualTo(167409079868000L);
  }

  @Test
  void testRangeTotal() {
    assertThat(new PartRange(1, 2, 1, 2, 1, 2, 1, 2).total()).isEqualTo(16);
  }

  @Test
  void part1_puzzle() {
    String[] parts = PUZZLE.split("\n\n");
    System.out.println(underTest.part1(parts[0].lines().toList(), parts[1].lines().toList()));
  }

  @Test
  void part2_puzzle() {
    String[] parts = PUZZLE.split("\n\n");
    System.out.println(underTest.part2(parts[0].lines().toList()));
  }
}