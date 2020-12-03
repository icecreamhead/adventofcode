package com.icecreamhead.adventofcode.fourteen;

import junit.framework.TestCase;

import static org.assertj.core.api.Assertions.assertThat;

public class DefragmenterTest extends TestCase {

  private final Defragmenter defragmenter = new Defragmenter();

  private static final String PUZZLE_INPUT = "ffayrhll";

  public void testPart1() throws Exception {
    assertThat(defragmenter.evaluateUsedBits("flqrgnkx")).isEqualTo(8108);
  }

  public void testPart2() throws Exception {
    assertThat(defragmenter.evaluateRegions("flqrgnkx")).isEqualTo(1242);
  }

  public void testPart2Solution() throws Exception {
    System.out.println(defragmenter.evaluateRegions(PUZZLE_INPUT));
  }

  public void testPart1Solution() throws Exception {
    System.out.println(defragmenter.evaluateUsedBits(PUZZLE_INPUT));
  }

  public void testHashToBinary() throws Exception {
    assertThat(Defragmenter.hashToBinary("a0c2017")).isEqualTo("1010000011000010000000010111");
  }
}