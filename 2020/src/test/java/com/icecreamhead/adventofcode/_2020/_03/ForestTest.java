package com.icecreamhead.adventofcode._2020._03;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ForestTest {

  private final Forest forest = new Forest("_03/test-forest.txt");

  @Test
  void testNext() {

    Forest.Location l1 = forest.next(Forest.Location.START, 3, 1);
    assertThat(l1)
        .extracting("x", "y", "tree", "bottom")
        .containsExactly(3, 1, false, false);

    Forest.Location l2 = forest.next(l1, 3, 1);
    assertThat(l2)
        .extracting("x", "y", "tree", "bottom")
        .containsExactly(6, 2, true, false);

    Forest.Location l3 = forest.next(l2, 3, 1);
    assertThat(l3)
        .extracting("x", "y", "tree", "bottom")
        .containsExactly(9, 3, false, true);
  }

  @Test
  void testTraverse() {
    assertThat(forest.traverse(Forest.Location.START, 3, 1)).isEqualTo(1);
  }
}