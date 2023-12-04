package com.icecreamhead.adventofcode.q4;

import static org.assertj.core.api.Assertions.*;

import com.icecreamhead.adventofcode.util.InputLoader;
import java.util.List;
import org.junit.jupiter.api.Test;

class ScratchcardSolverTest {

  private final ScratchcardSolver solver = new ScratchcardSolver();
  @Test
  void part1_sample() {
    List<String> lines = InputLoader.loadLines("q4/sample.txt");

    assertThat(solver.part1(lines)).isEqualTo(13);
  }
  @Test
  void part1_puzzle() {
    List<String> lines = InputLoader.loadLines("q4/puzzle.txt");

    System.out.println(solver.part1(lines));
  }
  @Test
  void part2_sample() {
    List<String> lines = InputLoader.loadLines("q4/sample.txt");

    assertThat(solver.part2(lines)).isEqualTo(30);
  }
  @Test
  void part2_puzzle() {
    List<String> lines = InputLoader.loadLines("q4/puzzle.txt");

    System.out.println(solver.part2(lines));
  }
}