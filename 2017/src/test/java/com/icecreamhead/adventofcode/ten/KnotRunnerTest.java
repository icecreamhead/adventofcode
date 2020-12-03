package com.icecreamhead.adventofcode.ten;

import junit.framework.TestCase;

import static org.assertj.core.api.Assertions.assertThat;

public class KnotRunnerTest extends TestCase {

  private static final String PUZZLE_INPUT = "197,97,204,108,1,29,5,71,0,50,2,255,248,78,254,63";

  public void testPart1() throws Exception {
    KnotRunner knotRunner = new KnotRunner(5);
    knotRunner.runOnce("3,4,1,5");
    assertThat(knotRunner.output()).isEqualTo(12);
  }

  public void testPart2a() throws Exception {
    KnotRunner knotRunner = new KnotRunner(256);
    assertThat(knotRunner.runN("3,4,1,5", 64)).isEqualTo("4a19451b02fb05416d73aea0ec8c00c0");
  }

  public void testPart2b() throws Exception {
    KnotRunner knotRunner = new KnotRunner(256);
    assertThat(knotRunner.runN("", 64)).isEqualTo("a2582a3a0e66e6e86e3812dcb672a272");
  }

  public void testPart2c() throws Exception {
    KnotRunner knotRunner = new KnotRunner(256);
    assertThat(knotRunner.runN("AoC 2017", 64)).isEqualTo("33efeb34ea91902bb2f59c9920caa6cd");
  }

  public void testPart2d() throws Exception {
    KnotRunner knotRunner = new KnotRunner(256);
    assertThat(knotRunner.runN("1,2,3", 64)).isEqualTo("3efbe78a8d82f29979031a4aa0b16a9d");
  }

  public void testPart2e() throws Exception {
    KnotRunner knotRunner = new KnotRunner(256);
    assertThat(knotRunner.runN("1,2,4", 64)).isEqualTo("63960835bcdc130f0b66d7ff4f6a5a8e");
  }

  public void testPart2Solution() throws Exception {
    KnotRunner knotRunner = new KnotRunner(256);
    System.out.println(knotRunner.runN(PUZZLE_INPUT, 64));
  }

  public void testPart1Solution() throws Exception {
    KnotRunner knotRunner = new KnotRunner(256);
    knotRunner.runOnce(PUZZLE_INPUT);
    System.out.println(knotRunner.output());
  }

  public void testHash() throws Exception {
    assertThat(KnotRunner.hash(new int[]{64, 7, 255})).isEqualTo("4007ff");
  }
}