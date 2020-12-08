package com.icecreamhead.adventofcode._2020._08;

import com.icecreamhead.adventofcode.util.InputLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Infinite {

  private static final List<String> INSTRUCTIONS = InputLoader.loadLines("_08/puzzle-input.txt");

  public static void main(String[] args) {

    for (int changed_instr = 0; changed_instr < INSTRUCTIONS.size(); changed_instr++) {

      int i = 0;
      int acc = 0;
      String[] instructions = INSTRUCTIONS.toArray(new String[0]);

      while (i <= instructions.length) {
        if (i == instructions.length) {
          System.out.println(acc);
          break;
        }
        if (instructions[i] == null) {
          break;
        }
        String[] split = instructions[i].split(" ");
        instructions[i] = null;
        if (i == changed_instr) {
          if ("jmp".equals(split[0]))
            split[0] = "nop";
          else if ("nop".equals(split[0]))
            split[0] = "jmp";
        }

        switch (split[0]) {
          case "acc" -> {
            acc += Integer.parseInt(split[1]);
            i++;
          }
          case "jmp" -> i += Integer.parseInt(split[1]);
          case "nop" -> i++;
          default -> {}
        }
      }
    }
  }


}
