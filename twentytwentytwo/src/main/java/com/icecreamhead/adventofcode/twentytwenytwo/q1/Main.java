package com.icecreamhead.adventofcode.twentytwenytwo.q1;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    System.out.printf("P1 Sample: %d%n", max(Input.SAMPLE));
    System.out.printf("P1 Puzzle: %d%n", max(Input.PUZZLE));

    System.out.printf("P2 Sample: %d%n", max3(Input.SAMPLE));
    System.out.printf("P2 Puzzle: %d%n", max3(Input.PUZZLE));
  }
  
  private static int max(String input) {
    return Arrays.stream(input.split("\n\n"))
        .map(cals -> Arrays.stream(cals.split("\n"))
            .mapToInt(Integer::valueOf)
            .sum())
        .mapToInt(Integer::intValue)
        .max().orElseThrow();
  }

  private static int max3(String input) {
    return Arrays.stream(input.split("\n\n"))
        .map(cals -> Arrays.stream(cals.split("\n"))
            .mapToInt(Integer::valueOf)
            .sum())
        .sorted((a,b) -> Integer.compare(b,a))
        .limit(3)
        .mapToInt(Integer::intValue)
        .sum();
  }
}
