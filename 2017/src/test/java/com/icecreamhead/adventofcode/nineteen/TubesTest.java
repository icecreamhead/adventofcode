package com.icecreamhead.adventofcode.nineteen;

import junit.framework.TestCase;

import java.util.List;

public class TubesTest extends TestCase {

  private static final String TEST_INPUT =
          "     |          \n" +
          "     |  +--+    \n" +
          "     A  |  C    \n" +
          " F---|----E|--+ \n" +
          "     |  |  |  D \n" +
          "     +B-+  +--+ \n";

  public void testPart1() throws Exception {
    Tubes tubes = new Tubes(TEST_INPUT);

    System.out.println(tubes.traverse());
  }

  public void testSolutionPart1() throws Exception {
    Tubes tubes = new Tubes(Input.PUZZLE_INPUT);

    List<String> output = tubes.traverse();
    System.out.println();
    output.forEach(System.out::print);
  }
}