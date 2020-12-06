package com.icecreamhead.adventofcode.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputLoaderTest {

  @Test
  void test() {
    assertThat(InputLoader.loadLines("test.txt"))
        .containsExactly("line 1", "line 2", "line 3");
  }

}