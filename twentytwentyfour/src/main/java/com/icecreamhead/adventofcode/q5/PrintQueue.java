package com.icecreamhead.adventofcode.q5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PrintQueue {

  long pt1(List<String> input) {

    Map<Integer, Set<Integer>> rules = buildRules(input);

    input.removeFirst(); // skip line break

    return input.stream()
        .map(in -> Arrays.stream(in.split(",")).mapToInt(Integer::parseInt).toArray())
        .filter(up -> accept(up, rules))
        .mapToInt(up -> up[up.length / 2])
        .sum();
  }

  long pt2(List<String> input) {

    Map<Integer, Set<Integer>> rules = buildRules(input);

    input.removeFirst(); // skip line break

    return input.stream()
        .map(in -> Arrays.stream(in.split(",")).mapToInt(Integer::parseInt).toArray())
        .filter(up -> !accept(up, rules))
        .map(up -> fixIt(up, rules))
        .mapToInt(up -> up[up.length / 2])
        .sum();
  }

  private static int[] fixIt(int[] update, Map<Integer, Set<Integer>> rules) {
    ArrayList<Integer> incorrect = new ArrayList<>(Arrays.stream(update).boxed().toList());

    rules.forEach((r, vs) -> {
      if (incorrect.contains(r)) {
        vs.forEach(v -> {
          if (incorrect.contains(v) && incorrect.indexOf(r) > incorrect.indexOf(v)) {
            // move r before v
            incorrect.remove(r);
            incorrect.add(incorrect.indexOf(v), r);
          }
        });
      }
    });
    return incorrect.stream().mapToInt(i -> i).toArray();
  }

  private static boolean accept(int[] update, Map<Integer, Set<Integer>> rules) {
    for (int i = 0; i < update.length; i++) {
      if (rules.containsKey(update[i])) {
        Set<Integer> ruleSet = rules.get(update[i]);
        for (int j = i - 1; j >= 0; j--) {
          if (ruleSet.contains(update[j])) {
            return false;
          }
        }
      }
    }
    return true;
  }

  private static Map<Integer, Set<Integer>> buildRules(List<String> input) {
    Map<Integer, Set<Integer>> rules = new HashMap<>();
    while (input.getFirst().contains("|")) {
      String[] parts = input.removeFirst().split("\\|");
      rules.computeIfAbsent(Integer.parseInt(parts[0]), k -> new HashSet<>()).add(Integer.parseInt(parts[1]));
    }
    return rules;
  }

}
