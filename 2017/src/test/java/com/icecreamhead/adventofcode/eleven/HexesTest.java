package com.icecreamhead.adventofcode.eleven;

import junit.framework.TestCase;

import static com.icecreamhead.adventofcode.eleven.Input.PUZZLE_INPUT;
import static org.assertj.core.api.Assertions.assertThat;

public class HexesTest extends TestCase {

  private final HexRunner runner = new HexRunner();

  public void testPart1T1() throws Exception {
    assertEquals(3, runner.distance("ne,ne,ne"));
  }

  public void testPart1T2() throws Exception {
    assertEquals(0, runner.distance("ne,ne,sw,sw"));
  }

  public void testPart1T2a() throws Exception {
    assertEquals(0, runner.distance("n,ne,se,s,sw,nw"));
  }

  public void testPart1T3() throws Exception {
    assertEquals(2, runner.distance("ne,ne,s,s"));
  }

  public void testPart1T4() throws Exception {
    assertEquals(3, runner.distance("se,sw,se,sw,sw"));
  }

  public void testSolvePart1() throws Exception {
    System.out.println(runner.distance(PUZZLE_INPUT));
  }

  public void testSolvePart2() throws Exception {
    System.out.println(runner.furthest(PUZZLE_INPUT));
  }

  public void testReducer() throws Exception {
    reduce(new int[]{0, 1, 1}, new int[]{1, 0, 0});
    reduce(new int[]{1, 0, -1}, new int[]{0, 1, 0});
    reduce(new int[]{-1, 1, 0}, new int[]{0, 0, -1});
    reduce(new int[]{0, -1, -1}, new int[]{-1, 0, 0});
    reduce(new int[]{-1, 0, 1}, new int[]{0, -1, 0});
    reduce(new int[]{1, -1, 0}, new int[]{0, 0, 1});
    reduce(new int[]{1, -1, -1}, new int[]{0, 0, 0});
    reduce(new int[]{-1, 1, 1}, new int[]{0, 0, 0});
  }

  private void reduce(int[] input, int[] expected) {
    assertThat(Hexes.reduce(input)).isEqualTo(expected);
  }
}