package com.icecreamhead.adventofcode.six;

import junit.framework.TestCase;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryRunnerTest extends TestCase {

  private final MemoryRunner runner = new MemoryRunner();

  public void testPart1() throws Exception {
    assertThat(runner.part1("0\t2\t7\t0")).isEqualTo(5);
  }

  public void testPart2() throws Exception {
    assertThat(runner.part2("0\t2\t7\t0")).isEqualTo(4);
  }

  public void testSolutionPart1() throws Exception {
    System.out.println("Q6P1: " + runner.part1(PUZZLE_INPUT));
  }

  public void testSolutionPart2() throws Exception {
    System.out.println("Q6P2: " + runner.part2(PUZZLE_INPUT));
  }

  private static final String PUZZLE_INPUT = "14\t0\t15\t12\t11\t11\t3\t5\t1\t6\t8\t4\t9\t1\t8\t4";
}