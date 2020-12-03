package com.icecreamhead.adventofcode.util;

import junit.framework.TestCase;

import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;

public class EnumMapperTest extends TestCase {

  enum Enum1 { VAL }
  enum Enum2 { VAL }

  public void testEnumMapper() throws Exception {
    assertThat(EnumMapper.map(Enum1.VAL, Enum2.class)).isEqualTo(Enum2.VAL);
  }
}