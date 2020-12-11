package com.icecreamhead.adventofcode._2020._09;

import com.icecreamhead.adventofcode.util.InputLoader;

import java.util.List;

public class EncodingPart1 {

  private static final long[] VALUES = InputLoader.loadLines("_09/puzzle-input.txt")
      .stream().mapToLong(Long::parseLong).toArray();

  private static final int CANDIDATE_RANGE = 25;

  public static void main(String[] args) {

    for (int i = CANDIDATE_RANGE; i < VALUES.length; i++) {
      if (!isSumOfTwoCandidates(i)) {
        System.out.println(VALUES[i]);
        break;
      }
    }

  }

  private static boolean isSumOfTwoCandidates(int expectedIndex) {
    for (int i = expectedIndex - CANDIDATE_RANGE; i < expectedIndex - 1; i++) {
      for (int j = i + 1; j < expectedIndex; j++) {
        if (VALUES[i] + VALUES[j] == VALUES[expectedIndex])
          return true;
      }
    }
    return false;
  }


}
