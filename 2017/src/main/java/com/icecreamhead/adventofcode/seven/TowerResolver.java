package com.icecreamhead.adventofcode.seven;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.icecreamhead.adventofcode.util.Converter.multilineStringToStringList;

public class TowerResolver {

  // ugml (68) -> gyxo, ebii, jptl

  String closeRegex = "^([a-z]{4}) \\(([0-9]+)\\)(?: -> (.*))?$";

  static final Pattern READER = Pattern.compile("^([a-z]{4}) \\(([0-9]+)\\)(?: -> (([a-z]{4},? ?)+))?$");

  private final Set<String> roots = new HashSet<>();

  private final Map<String, Set<String>> leaves = new HashMap<>();
  private final Map<String, Integer> weights = new HashMap<>();

  public String findRoot(String input) {
    List<String> towerStrings = multilineStringToStringList(input);

    for (String t : towerStrings) {
//      System.out.println("Parsing: '" + t + "'");
      ParsedTower parsed = new ParsedTower(t);

//      System.out.println("Added "+parsed.name+":"+parsed.weight);
      weights.put(parsed.name, parsed.weight);
      roots.add(parsed.name);
      leaves.put(parsed.name, Arrays.stream(parsed.towers).collect(Collectors.toSet()));
    }

    for (String root : roots) {
      if (!leaves.values().stream().flatMap(Set::stream).collect(Collectors.toSet()).contains(root)) {
        return root;
      }
    }
    throw new RuntimeException();
  }

  public int findIncorrectWeight(String string) {
    String root = findRoot(string);

    return calcTotalWeight(root, 0);
  }

  private int calcTotalWeight(String node, int depth) {
    Set<String> nodeLeaves = leaves.getOrDefault(node, new HashSet<>());
    int w = weights.get(node);
    if (nodeLeaves.isEmpty()) {
//      System.out.println("Weight of d" + depth + " leaf " + node + "=" + w);
      return w;
    }

    List<Integer> leafWeights = nodeLeaves.stream().map(n -> calcTotalWeight(n, depth + 1)).collect(Collectors.toList());
    if (leafWeights.stream().distinct().count() > 1) {
      System.out.println("Leaves " + nodeLeaves.toString() + " have weights " + leafWeights.toString());
    }

    int total = leafWeights.stream().mapToInt(n -> n).sum();
    System.out.println("Total weight of d" + depth + " node " + node + "=" + total + "+" + w + "=" + (w + total));
    return w + total;
  }

  private int checkWeights(String node) {
    System.out.println("Traversing " + node);
    int weight = weights.getOrDefault(node, 0);
    if (weight == 0) {
      return -1;
    }

    Set<String> nodeLeaves = leaves.getOrDefault(node, new HashSet<>());
    if (nodeLeaves.isEmpty()) {
      // do nothing?
    } else {
      nodeLeaves.forEach(this::checkWeights);

      List<Integer> leafWeights = nodeLeaves.stream()
          .map(weights::get)
          .collect(Collectors.toList());

//      if (leafWeights.stream().distinct().count() > 1) {
      System.out.println("Weight of " + node + "=" + weight + ". Weight of leaves "
          + nodeLeaves.toString() + leafWeights.toString() + "=" + nodeLeaves.stream().mapToInt(weights::get).sum()
          + "+ own weight = " + nodeLeaves.stream().mapToInt(weights::get).sum() + weights.get(node));
//      }
    }

    return 0;
  }

  static class ParsedTower {
    final String name;
    final int weight;
    final String[] towers;

    ParsedTower(String line) {
      if (line.contains("->")) {
        String[] split = line.split(" -> ");
        towers = split[1].split(", ");
        split = split[0].split(" ");
        name = split[0];
        weight = Integer.parseInt(split[1].replaceAll("\\(|\\)", ""));
      } else {
        towers = new String[0];
        String[] split = line.split(" ");
        name = split[0];
        weight = Integer.parseInt(split[1].replaceAll("\\(|\\)", ""));
      }
    }

    @Override
    public String toString() {
      return name + ": [" + weight + "] -> " + Arrays.toString(towers);
    }
  }
}
