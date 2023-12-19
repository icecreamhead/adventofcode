package com.icecreamhead.adventofcode.q15;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class LensLibrary {

  long part1(String input) {
    return Arrays.stream(input.split(","))
        .mapToInt(LensLibrary::HASH)
        .sum();
  }

  long part2(String input) {

    Map<Integer, LinkedHashMap<String, Integer>> map = new HashMap<>();
    for (int box = 0; box < 256; box++) {
      map.put(box, new LinkedHashMap<>());
    }

    for (String instruction : input.split(",")) {
      char op = instruction.endsWith("-") ? '-' : '=';
      String[] lens = instruction.split(op + "");
      String label = lens[0];
      int boxId = HASH(label);
      LinkedHashMap<String, Integer> box = map.get(boxId);
      switch (op) {
        case '=' -> box.put(label, Integer.parseInt(lens[1]));
        case '-' -> box.remove(label);
      }
    }

    return map.entrySet().stream()
        .mapToLong(e -> {
          int box = e.getKey();
          LinkedHashMap<String, Integer> lenses = e.getValue();
          long power = 0;
          long i = 1;
          for (Entry<String, Integer> lens : lenses.entrySet()) {
            power += (box + 1) * i * lens.getValue();
            i++;
          }
          return power;
        })
        .sum();
  }

  static int HASH(String input) {
    int total = 0;
    for (char c : input.toCharArray()) {
      total = ((total + c) * 17) % 256;
    }
    return total;
  }
}
