package com.icecreamhead.adventofcode._2020._09;

import com.icecreamhead.adventofcode.util.InputLoader;

public class EncodingPart2 {

  private static final long[] VALUES = InputLoader.loadLines("_09/puzzle-input.txt")
      .stream().mapToLong(Long::parseLong).toArray();

  private static final int WEAKNESS = 373803594;

  public static void main(String[] args) {

    long answer = 0;
    for (int i = 0; i < VALUES.length - 1; i++) {
      for (int j = i + 1; j < VALUES.length; j++) {
        if (isSumOfIndexRange(i, j)) {
          answer = minPlusMaxInRange(i, j);
          break;
        }
      }
      if (answer != 0)
        break;
    }
    System.out.println(answer);
  }

  private static long minPlusMaxInRange(int x, int y) {
    long min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int i = x; i <= y; i++) {
      min = Math.min(VALUES[i], min);
      max = Math.max(VALUES[i], max);
    }
    return min + max;
  }

  private static boolean isSumOfIndexRange(int x, int y) {
    long accum = 0;
    for (int i = x; i <= y; i++) {
      accum += VALUES[i];
      if (accum > WEAKNESS)
        break;
    }
    return accum == WEAKNESS;
  }


}
