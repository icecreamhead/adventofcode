package com.icecreamhead.adventofcode._2020._05;

import com.icecreamhead.adventofcode.util.InputLoader;

import java.util.List;
import java.util.stream.Stream;

public class Boarding {

  private static final List<String> inputs = InputLoader.loadLines("_05/puzzle-input.txt");

  public static void main(String[] args) {

    int[] seats = inputs.stream()
        .mapToInt(input ->
            Stream.iterate(1, i -> i <= input.length(), i -> i + 1)
                .mapToInt(i ->
                    switch (input.charAt(i - 1)) {
                      case 'R', 'B' -> 1 << input.length() - i;
                      default -> 0;
                    })
                .sum())
        .sorted()
        .toArray();

    for (int i = 0; i < seats.length - 1; i++) {
      if (seats[i + 1] != seats[i] + 1) {
        System.out.println(seats[i] + 1);
      }
    }

  }
}
