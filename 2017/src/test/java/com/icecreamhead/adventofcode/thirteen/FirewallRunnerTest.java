package com.icecreamhead.adventofcode.thirteen;

import junit.framework.TestCase;

import static org.assertj.core.api.Assertions.assertThat;


public class FirewallRunnerTest {

  private final FirewallRunner runner = new FirewallRunner(0);

  private static final String TEST_INPUT =
      "0: 3\n" +
          "1: 2\n" +
          "4: 4\n" +
          "6: 4";

  public void testPart1() throws Exception {
    runner.run(TEST_INPUT);
    assertThat(runner.severity()).isEqualTo(24);
  }

  public void testPart2() throws Exception {
    int i = 0;
    FirewallRunner runner = new FirewallRunner(i);
    runner.run(TEST_INPUT);
    while (runner.severity() != 0) {
      i++;
      runner = new FirewallRunner(i);
      runner.run(TEST_INPUT);
    }
    System.out.println("delay=" + i);
    assertThat(i).isEqualTo(10);
  }

  public void testPart1Solution() throws Exception {
    runner.run(PUZZLE_INPUT);
    System.out.println(runner.severity());
  }

  private static final String PUZZLE_INPUT =
      "0: 3\n" +
          "1: 2\n" +
          "2: 4\n" +
          "4: 6\n" +
          "6: 4\n" +
          "8: 6\n" +
          "10: 5\n" +
          "12: 6\n" +
          "14: 8\n" +
          "16: 8\n" +
          "18: 8\n" +
          "20: 6\n" +
          "22: 12\n" +
          "24: 8\n" +
          "26: 8\n" +
          "28: 10\n" +
          "30: 9\n" +
          "32: 12\n" +
          "34: 8\n" +
          "36: 12\n" +
          "38: 12\n" +
          "40: 12\n" +
          "42: 14\n" +
          "44: 14\n" +
          "46: 12\n" +
          "48: 12\n" +
          "50: 12\n" +
          "52: 12\n" +
          "54: 14\n" +
          "56: 12\n" +
          "58: 14\n" +
          "60: 14\n" +
          "62: 14\n" +
          "64: 14\n" +
          "70: 10\n" +
          "72: 14\n" +
          "74: 14\n" +
          "76: 14\n" +
          "78: 14\n" +
          "82: 14\n" +
          "86: 17\n" +
          "88: 18\n" +
          "96: 26";
}