package com.icecreamhead.adventofcode.twentytwenytwo.q13;

import com.icecreamhead.adventofcode.util.InputLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    String input = InputLoader.loadString("com/icecreamhead/adventofcode/twentytwentytwo/q13/puzzle.txt");

    Pair[] pairs = parseInput(input);

    int t = 0;
    for (int i = 1; i < pairs.length + 1; i++) {
      if (pairs[i-1].correct()) {
        t += i;
      }
      System.out.println();
    }
    System.out.println(t);
  }

  private static ArrayList parsePacket(List<String> tail, ArrayList packet, ArrayList parent) {

    if (tail.isEmpty()) {
      return packet;
    }
    String t;
    
    while (true) {
      t = tail.remove(0);
      System.out.println(t);

      switch (t) {
        case "[":
          packet.add(parsePacket(tail, new ArrayList(), packet));
          if (!tail.isEmpty()) {
            break;
          }
          return packet;
        case "]":
          return packet;
        case ",":
          break;
        default:
          packet.add(Integer.parseInt(t));
          break;
      }
    }
    
    
  }

  private static Pair parsePair(String pair) {
    System.out.println(pair);
    String[] packets = pair.split("\n");
    return new Pair(packets[0], (ArrayList) parsePacket(str2chars(packets[0]), new ArrayList(), null).get(0), packets[1], (ArrayList) parsePacket(str2chars(packets[1]), new ArrayList(), null).get(0));
  }

  private static Pair[] parseInput(String input) {
    return Arrays.stream(input.split("\n\n"))
        .map(Main::parsePair)
        .peek(s -> System.out.println())
        .toArray(Pair[]::new);
  }

  record Pair(String l, ArrayList left, String r, ArrayList right) {
    
    boolean correct() {
      return correct(left, right);
    }

    private boolean correct(ArrayList left, ArrayList right) {

      System.out.printf("- Compare %s vs %s%n", left, right);
      for (int i = 0; i < left.size(); i++) {
        if (right.size() - 1 < i) {
          System.out.println("  - Right side ran out of items, so inputs are not in the right order");
          return false;
        } else if (left.get(i) instanceof Integer && right.get(i) instanceof Integer) {
          System.out.printf(  "- Compare %s vs %s%n", left.get(i), right.get(i));
          if ((Integer) left.get(i) < (Integer) right.get(i)) {
            System.out.println("    - Left side is smaller, so inputs are in the right order");
            return true;
          }
          else if ((Integer) left.get(i) > (Integer) right.get(i)) {
            System.out.println("    - Right side is smaller, so inputs are not in the right order");
            return false;
          }
        } else if (left.get(i) instanceof ArrayList && right.get(i) instanceof ArrayList) {
          if (!correct((ArrayList) left.get(i), (ArrayList) right.get(i))) {
            return false;
          }
        } else if (left.get(i) instanceof Integer && right.get(i) instanceof ArrayList) {
          ArrayList l = new ArrayList();
          l.add(left.get(i));
          if (!correct(l, (ArrayList) right.get(i))) {
            return false;
          }
        } else if (left.get(i) instanceof ArrayList && right.get(i) instanceof Integer) {
          ArrayList r = new ArrayList();
          r.add(right.get(i));
          if (!correct((ArrayList) left.get(i), r)) {
            return false;
          }
        }
        
        if (i == left.size() - 1 && right.size() > left.size()) {
          System.out.printf(" - Left side ran out of items, so inputs are in the right order (%s vs %s)%n", left.size(), right.size());
          return true;
        }
        
      }
      
      
//      System.out.println(" ? Left side ran out of items, so inputs are in the right order");
      return true;
    }

  }
  
  private static ArrayList<String> str2chars(String str) {
    return new ArrayList<>(Arrays.asList(str.split("")));
  }
}
