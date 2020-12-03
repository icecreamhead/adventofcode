package com.icecreamhead.adventofcode.three;

import junit.framework.TestCase;

import static com.icecreamhead.adventofcode.three.Manhattan.Direction.DOWN;
import static com.icecreamhead.adventofcode.three.Manhattan.Direction.LEFT;
import static com.icecreamhead.adventofcode.three.Manhattan.Direction.RIGHT;
import static com.icecreamhead.adventofcode.three.Manhattan.Direction.UP;
import static com.icecreamhead.adventofcode.three.Manhattan.ORIGIN;
import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest extends TestCase {

  public void testRight() throws Exception {
    test(RIGHT, false, ORIGIN, RIGHT, 1, 0);
  }

  public void testRightTurn() throws Exception {
    test(RIGHT, true, ORIGIN, UP, 0, 1);
  }

  public void testUp() throws Exception {
    test(UP, false, ORIGIN, UP, 0, 1);
  }

  public void testUpTurn() throws Exception {
    test(UP, true, ORIGIN, LEFT, -1, 0);
  }

  public void testLeft() throws Exception {
    test(LEFT, false, ORIGIN, LEFT, -1, 0);
  }

  public void testLeftTurn() throws Exception {
    test(LEFT, true, ORIGIN, DOWN, 0, -1);
  }

  public void testDown() throws Exception {
    test(DOWN, false, ORIGIN, DOWN, 0, -1);
  }

  public void testDownTurn() throws Exception {
    test(DOWN, true, ORIGIN, RIGHT, 1, 0);
  }

  private static void test(Manhattan.Direction direction, boolean turn, int[] xy, Manhattan.Direction expectedDirection, int... expected) {
    assertThat(direction.next(xy, turn)).isEqualTo(new Manhattan.Vector(expected, expectedDirection));
  }
}