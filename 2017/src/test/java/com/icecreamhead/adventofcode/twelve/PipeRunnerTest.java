package com.icecreamhead.adventofcode.twelve;

import junit.framework.TestCase;

import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;

public class PipeRunnerTest extends TestCase {

  private final PipeRunner runner = new PipeRunner();

  private static final String TEST_INPUT =
      "0 <-> 2\n" +
      "1 <-> 1\n" +
      "2 <-> 0, 3, 4\n" +
      "3 <-> 2, 4\n" +
      "4 <-> 2, 3, 6\n" +
      "5 <-> 6\n" +
      "6 <-> 4, 5";

  public void testPart1() throws Exception {
    assertThat(runner.counter(TEST_INPUT)).isEqualTo(6);
  }

  public void testPart2() throws Exception {
    assertThat(runner.groups(TEST_INPUT)).isEqualTo(2);
  }

  public void testSolutionPart1() throws Exception {
    System.out.println(runner.counter(Input.PUZZLE_INPUT));
  }

  public void testSolutionPart2() throws Exception {
    System.out.println(runner.groups(Input.PUZZLE_INPUT));
  }
}