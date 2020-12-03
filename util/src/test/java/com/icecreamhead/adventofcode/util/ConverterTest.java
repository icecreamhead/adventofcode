package com.icecreamhead.adventofcode.util;

import org.junit.jupiter.api.Test;

import static com.icecreamhead.adventofcode.util.Converter.multilineStringToCharacterGrid;
import static com.icecreamhead.adventofcode.util.Converter.stringToIntArray;
import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {

  @Test
  public void testStringToArray() throws Exception {
    assertThat(stringToIntArray("123")).isEqualTo(new int[]{1, 2, 3});
  }

//  public void testMultiLine() throws Exception {
//    assertThat(multilineStringToIntListList(ChecksumTest.PART_1_TEST_INPUT)).isEqualTo(Lists.newArrayList(Lists.newArrayList(5, 1, 9, 5), Lists.newArrayList(7, 5, 3), Lists.newArrayList(2, 4, 6, 8)));
//  }

  @Test
  public void testTubeGrid() throws Exception {
    String[][] grid = multilineStringToCharacterGrid(
        "     |          \n" +
            "     |  +--+    \n" +
            "     A  |  C    \n" +
            " F---|----E|--+ \n" +
            "     |  |  |  D \n" +
            "     +B-+  +--+ \n");
    assertThat(grid).hasSize(6).allMatch(y -> y.length == 16);
//    for (String[] strings : grid) {
//      System.out.println(Arrays.toString(strings));
//    }
  }
}