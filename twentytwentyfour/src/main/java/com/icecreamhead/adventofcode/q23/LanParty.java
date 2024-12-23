package com.icecreamhead.adventofcode.q23;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LanParty {

  private final Map<String, Set<String>> connections = new HashMap<>();
  private final Set<Set<String>> distinctNetworks = new HashSet<>();

  long pt1(List<String> input) {
    buildMap(input);
    buildNetworks(3);

    return distinctNetworks.stream()
        .filter(n -> n.size() == 3)
        .filter(n -> n.stream().anyMatch(c -> c.startsWith("t")))
        .count();
  }

  String pt2(List<String> input) {
    buildMap(input);
    buildNetworks(connections.size());

   return distinctNetworks.stream()
       .max(Comparator.comparingInt(Set::size))
       .orElseThrow()
       .stream()
       .sorted()
       .collect(Collectors.joining(","));
  }

  private void buildNetworks(int reqSize) {
    int before, after;
    do {
      int currentBiggest = distinctNetworks.stream().max(Comparator.comparingInt(Set::size)).map(Set::size).orElse(0);
      System.out.printf("current=%d %s%n", currentBiggest, distinctNetworks.stream().max(Comparator.comparingInt(Set::size)).orElseThrow().stream().sorted().collect(Collectors.joining(",")));
      before = currentBiggest;

      Set<Set<String>> networksToAdd = new HashSet<>();
      for (Set<String> distinctNetwork : distinctNetworks.stream().filter(nw -> nw.size() == currentBiggest).collect(Collectors.toSet())) {
        distinctNetwork.stream()
            .map(node -> connections.get(node).stream().filter(dest -> !distinctNetwork.contains(dest)).collect(Collectors.toSet()))
            .reduce((set1, set2) -> set1.stream().filter(set2::contains).collect(Collectors.toSet()))
            .orElse(Set.of())
            .forEach(newDest -> {
              HashSet<String> n = new HashSet<>(distinctNetwork);
              n.add(newDest);
              networksToAdd.add(n);
            });
      }
      distinctNetworks.addAll(networksToAdd);

      after = distinctNetworks.stream().max(Comparator.comparingInt(Set::size)).map(Set::size).orElse(0);
    } while (before != after && before <= reqSize);
  }

  private void buildMap(List<String> input) {
    input.forEach(line -> {
      String[] parts = line.split("-");
      connections.computeIfAbsent(parts[0], k -> new HashSet<>()).add(parts[1]);
      connections.computeIfAbsent(parts[1], k -> new HashSet<>()).add(parts[0]);
      distinctNetworks.add(Set.of(parts[0], parts[1]));
    });
  }
}
