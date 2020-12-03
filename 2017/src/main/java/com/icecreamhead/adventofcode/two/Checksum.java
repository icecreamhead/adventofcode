package com.icecreamhead.adventofcode.two;

import java.util.List;

import static com.icecreamhead.adventofcode.util.Converter.multilineStringToIntListList;

class Checksum {

  int solvePart1(String input) {
    return multilineStringToIntListList(input).stream()
        .mapToInt(l ->
            l.stream().max(Integer::compareTo).orElse(0) -
                l.stream().min(Integer::compareTo).orElse(0)
        ).sum();
  }

  int solvePart2(String input) {
    return multilineStringToIntListList(input).stream()
        .mapToInt(this::divisor)
        .sum();
  }

  private int divisor(List<Integer> integers) {
    for (int i = 0; i < integers.size(); i++) {
      for (int j = i + 1; j < integers.size(); j++) {
        if (integers.get(i) % integers.get(j) == 0) {
          return integers.get(i) / integers.get(j);
        } else if (integers.get(j) % integers.get(i) == 0) {
          return integers.get(j) / integers.get(i);
        }
      }
    }
    throw new IllegalArgumentException();
  }
}
