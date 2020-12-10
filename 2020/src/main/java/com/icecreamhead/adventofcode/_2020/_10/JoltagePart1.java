package com.icecreamhead.adventofcode._2020._10;

import com.icecreamhead.adventofcode.util.InputLoader;

import java.util.Arrays;

public class JoltagePart1 {

  private static final int[] ADAPTORS = InputLoader.loadLines("_10/puzzle-input.txt")
      .stream().mapToInt(Integer::valueOf).sorted().toArray();

  public static void main(String[] args) {

    int[] differences = new int[]{Integer.MIN_VALUE, 0, 0, 0};

    differences[ADAPTORS[0]]++;
    for (int i = 1; i < ADAPTORS.length; i++) {
      differences[ADAPTORS[i] - ADAPTORS[i - 1]]++;
    }
    differences[3]++;

    System.out.println(differences[1] * differences[3]);
  }


}
