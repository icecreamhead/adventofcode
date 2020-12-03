package com.icecreamhead.adventofcode.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EnumMapperTest {

  enum Enum1 {VAL}

  enum Enum2 {VAL}

  @Test
  public void shouldCorrectlyMapEnum() {
    assertThat(EnumMapper.map(Enum1.VAL, Enum2.class)).isEqualTo(Enum2.VAL);
  }
}