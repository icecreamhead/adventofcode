package com.icecreamhead.adventofcode.ten;

import junit.framework.TestCase;

import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;

public class KnotTest extends TestCase {

  public void testCalcDense() throws Exception {
    assertThat(Knot.calcDense(new int[]{65, 27, 9, 1, 4, 3, 40, 50, 91, 7, 6, 0, 2, 5, 68, 22})).isEqualTo(64);
  }

  public void testCalcDense2() throws Exception {
    assertThat(Knot.calcDense(new int[]{7, 8, 9})).isEqualTo(6);
  }

  public void testDense() throws Exception {
    assertThat(Knot.dense(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})).isEqualTo(new int[]{0, 7, 6});
    assertThat(1 ^ 2 ^ 3).isEqualTo(3 ^ 2 ^ 1);
  }
}