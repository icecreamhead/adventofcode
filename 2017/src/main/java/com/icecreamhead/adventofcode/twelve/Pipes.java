package com.icecreamhead.adventofcode.twelve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Pipes {

  private final Map<Integer, List<Integer>> connections = new HashMap<>();

  public void add(String connection) {
    String[] split = connection.split(" <-> ");
    Integer source = Integer.parseInt(split[0]);

    List<Integer> dests = Arrays.stream(split[1].replace(" ", "").split(",")).map(Integer::parseInt).collect(Collectors.toList());
    connections.put(source, dests);
  }

  public int count() {
    return count(connections, new HashSet<>(), 0);
  }

  public int groups() {
    int groups = 0;

    while (!connections.isEmpty()) {
      groups++;
      Integer start = new ArrayList<>(connections.keySet()).get(0);
      System.out.println("NEW GROUP! START=" + start);
      final Set<Integer> sources = new HashSet<>();
      count(connections, sources, start);
      for (Integer source : sources) {
        connections.remove(source);
      }
    }

    return groups;
  }

  private static int count(Map<Integer, List<Integer>> conns, Set<Integer> seenSources, Integer source) {
    if (seenSources.contains(source)) {
      System.out.println("Already evaluated " + source);
      return seenSources.size();
    } else {
      System.out.println("Adding source " + source);
      seenSources.add(source);
      for (Integer dest : conns.get(source)) {
        System.out.println("Evaluating dest " + dest);
        count(conns, seenSources, dest);
      }
    }
    System.out.println("Returning " + seenSources.size());
    return seenSources.size();
  }
}
