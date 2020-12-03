package com.icecreamhead.adventofcode.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.valueOf;

public class Converter {

  private Converter() {
  }

  public static int[] stringToIntArray(String s) {
    return s.chars()
        .parallel()
        .mapToObj(c -> valueOf((char) c))
        .mapToInt(Integer::parseInt)
        .toArray();
  }

  public static int[] stringWithTabsToIntArray(String s) {
    return Arrays.stream(s.split("\t")).mapToInt(Integer::parseInt).toArray();
  }

  public static int[] multilineStringToIntArray(String s) {
    return Arrays.stream(s.split("\n")).mapToInt(Integer::parseInt).toArray();
  }

  public static List<List<Integer>> multilineStringToIntListList(String input) {
    return Stream.of(input.split("\n")).map(a -> Stream.of(a.split("([ \t])+")).map(Integer::valueOf).collect(Collectors.toList())).collect(Collectors.toList());
  }

  public static List<String> multilineStringToStringList(String input) {
    return Arrays.stream(input.split("\n")).collect(Collectors.toList());
  }

  public static String[][] multilineStringToCharacterGrid(String input) {
    String[] lines = input.split("\n");
    String[][] out = new String[lines.length][lines[0].length()];

    for (int i = 0; i < lines.length; i++) {
      String[] line = lines[i].split("");
      System.arraycopy(line, 0, out[i], 0, lines[i].length());
    }
    return out;
  }

}
