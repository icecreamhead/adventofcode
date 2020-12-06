package com.icecreamhead.adventofcode._2020._05;

import com.icecreamhead.adventofcode.util.InputLoader;

import java.util.List;
import java.util.stream.Stream;

public class Boarding {

  private static final List<String> inputs = InputLoader.loadLines("_05/puzzle-input.txt");

  public static void main(String[] args) {

    int[] seats = inputs.stream()
        .map(input -> new StringBuilder(input).reverse())
        .mapToInt(input ->
            Stream.iterate(0, i -> i < input.length(), i -> i + 1)
                .mapToInt(i ->
                    switch (input.charAt(i)) {
                      case 'R', 'B' -> (int) Math.pow(2, i);
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
