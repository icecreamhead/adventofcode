package com.icecreamhead.adventofcode.q15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LensLibrary {

  long part1(String input) {
    return Arrays.stream(input.split(","))
        .mapToInt(LensLibrary::HASH)
        .sum();
  }

  long part2(String input) {

    Map<Integer, ArrayList<String>> map = new HashMap<>();
    for (int box = 0; box < 256; box++) {
      map.put(box, new ArrayList<>());
    }

    for (String instruction : input.split(",")) {
      char op = instruction.endsWith("-") ? '-' : instruction.charAt(instruction.length()-2);
      String label = instruction.substring(0, instruction.length()-(op == '-' ? 1 : 2));
      int boxId = HASH(label);
      if (boxId > 255) {
        System.err.println(instruction + " => " + label + " => "+boxId);
      }
      ArrayList<String> box = map.get(boxId);
      if (box == null) {
        System.err.println(boxId);
      }
      switch (op) {
        case '=' -> {
          boolean replaced = false;
          for (int i = 0; i < box.size(); i++) {
            String lens = box.get(i);
            if (lens.substring(0, lens.length()-2).equals(label)) {
              String old = box.remove(i);
              System.out.println("Replacing '" + old + "' at box " + boxId + "[" + i + "] with " + instruction);
              box.add(i, instruction);
              replaced = true;
              break;
            }
          }
          if (!replaced) {
            System.out.println("Adding '" + instruction + "' to box " + boxId);
            box.add(instruction);
          }
        }
        case '-' -> {
          System.out.println("Removing lenses with label " + label + " from box " + boxId);
          box.removeIf(lens -> lens.substring(0, lens.length()-2).equals(label));
        }
        default -> throw new IllegalStateException("Unknown op '"+op+"' ("+instruction+")");
      }
    }

    return map.entrySet().stream()
        .mapToLong(e -> {
          int box = e.getKey();
          List<String> lenses = e.getValue();
          long power = 0;
          for (int i = 0; i < lenses.size(); i++) {
            String lens = lenses.get(i);
            power += ((box + 1) * (i + 1) * Long.parseLong(lens.substring(lens.length()-1)));
          }
          return power;
        })
        .sum();
  }

  static int HASH(String input) {
    int total = 0;

    for (char c : input.toCharArray()) {
      total = (total + c) * 17;
      total = total % 256;
    }

    return total;
  }

}
