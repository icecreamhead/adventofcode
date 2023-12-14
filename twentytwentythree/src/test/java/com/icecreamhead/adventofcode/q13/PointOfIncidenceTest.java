package com.icecreamhead.adventofcode.q13;

import static org.assertj.core.api.Assertions.assertThat;

import com.icecreamhead.adventofcode.util.InputLoader;
import java.util.List;
import org.junit.jupiter.api.Test;

class PointOfIncidenceTest {

  private final PointOfIncidence underTest = new PointOfIncidence();

  private static final List<char[][]> SAMPLE = InputLoader.loadListOfGrids("q13/sample.txt");
  private static final List<char[][]> PUZZLE = InputLoader.loadListOfGrids("q13/puzzle.txt");

  @Test
  void part1_sample() {
    assertThat(underTest.part1(SAMPLE)).isEqualTo(405);
  }
  @Test
  void part1_puzzle() {
    System.out.println(underTest.part1(PUZZLE));
  }
}