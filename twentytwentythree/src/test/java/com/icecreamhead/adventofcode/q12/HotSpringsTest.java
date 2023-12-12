package com.icecreamhead.adventofcode.q12;

import static org.assertj.core.api.Assertions.assertThat;

import com.icecreamhead.adventofcode.util.InputLoader;
import java.util.List;
import org.junit.jupiter.api.Test;

class HotSpringsTest {

  private final HotSprings underTest = new HotSprings();

  private static final List<String> SAMPLE = InputLoader.loadLines("q12/sample.txt");

  @Test
  void part1() {
    assertThat(underTest.part1(SAMPLE)).isEqualTo(21);
  }
}