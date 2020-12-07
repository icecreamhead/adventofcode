package com.icecreamhead.adventofcode._2020._07;

import com.icecreamhead.adventofcode.util.InputLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Baggage {

  private static final List<String> rules = InputLoader.loadLines("_07/puzzle-input.txt");
  private static final Map<String, List<String>> rulesMap = new HashMap<>();

  public static void main(String[] args) {

    for (String rule : rules) {
      String[] parts = rule.split(" bags contain ");
      String outer = parts[0];
      List<String> contents = new ArrayList<>();
      for (String inner : parts[1].replace(".", "").split(", ")) {
        if (!inner.equals("no other bags")) {
          String[] bags = inner.split(" ");
          for (int i = 0; i < Integer.parseInt(bags[0]); i++) {
            contents.add(bags[1] + " " + bags[2]);
          }
        }
      }
      rulesMap.put(outer, contents);
    }

    // Part 1
    System.out.println(rulesMap.keySet().stream().filter(Baggage::canHoldShinyGold).count());
    // Part 2
    System.out.println(totalBagsInside("shiny gold") - 1);
  }

  private static boolean canHoldShinyGold(String bag) {
    List<String> allowed = rulesMap.get(bag);

    return allowed.contains("shiny gold") || allowed.stream().distinct().anyMatch(Baggage::canHoldShinyGold);
  }

  private static int totalBagsInside(String bag) {
    return 1 + rulesMap.get(bag).stream().mapToInt(Baggage::totalBagsInside).sum();
  }
}
