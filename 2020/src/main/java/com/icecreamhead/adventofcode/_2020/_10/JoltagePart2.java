package com.icecreamhead.adventofcode._2020._10;

import com.icecreamhead.adventofcode.util.InputLoader;

import java.util.stream.IntStream;

public class JoltagePart2 {

  private static final int[] ADAPTORS = IntStream.concat(
      IntStream.of(0),
      InputLoader.loadLines("_10/puzzle-input.txt").stream().mapToInt(Integer::valueOf).sorted()
  ).toArray();

  public static void main(String[] args) {

    long start = System.nanoTime();

    long[] jumps = new long[ADAPTORS.length];

    for (int i = 0; i < ADAPTORS.length; i++) {
      long pathsToHere =
          (i - 3 >= 0 && ADAPTORS[i] - ADAPTORS[i - 3] <= 3 ? jumps[i - 3] : 0) +
              (i - 2 >= 0 && ADAPTORS[i] - ADAPTORS[i - 2] <= 3 ? jumps[i - 2] : 0) +
              (i - 1 >= 0 && ADAPTORS[i] - ADAPTORS[i - 1] <= 3 ? jumps[i - 1] : 0);

      jumps[i] = Math.max(1, pathsToHere);
    }

    long end = System.nanoTime() - start;

    System.out.println(jumps[jumps.length - 1]);
    System.out.printf("Completed in %f seconds", end / 1000000000.0d);
  }


}
