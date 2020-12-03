package com.icecreamhead.adventofcode.three;

import junit.framework.TestCase;

import static org.assertj.core.api.Assertions.assertThat;

public class ManhattanTest extends TestCase {

  private final Manhattan manhattan = new Manhattan();

  public void testPart1Test1() throws Exception {
    assertThat(manhattan.solvePart1(1)).isEqualTo(0);
  }

  public void testPart1Test2() throws Exception {
    assertThat(manhattan.solvePart1(12)).isEqualTo(3);
  }

  public void testPart1Test3() throws Exception {
    assertThat(manhattan.solvePart1(23)).isEqualTo(2);
  }

  public void testPart1Test4() throws Exception {
    assertThat(manhattan.solvePart1(1024)).isEqualTo(31);
  }

  public void testPart1Solution() throws Exception {
    System.out.println("Q3P1: " + manhattan.solvePart1(277678));
  }


  public void testPart2Test1() throws Exception {
    assertThat(manhattan.solvePart2(27)).isEqualTo(54);
  }

  public void testPart2Test2() throws Exception {
    assertThat(manhattan.solvePart2(748)).isEqualTo(806);
  }

  public void testPart2Solution() throws Exception {
    System.out.println("Q3P2: " + manhattan.solvePart2(277678));
  }

}