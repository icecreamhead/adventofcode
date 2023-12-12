package com.icecreamhead.adventofcode.q12;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

public class HotSprings {

  long part1(List<String> input) {
    return input.stream()
        .mapToLong(line -> {
          String[] parts = line.split(" ");
          String record = parts[0];
          int[] groups = Arrays.stream(parts[1].split(",")).mapToInt(Integer::parseInt).toArray();
          int hashCount = record.replace("[^#]", "").length();
          int damageCount = Arrays.stream(groups).sum();
          int unknownsToFill = damageCount - hashCount;

          return groups.length;
        })
        .sum();
  }

}
