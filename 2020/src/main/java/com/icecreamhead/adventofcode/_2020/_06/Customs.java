package com.icecreamhead.adventofcode._2020._06;

import com.icecreamhead.adventofcode.util.InputLoader;

import java.util.Arrays;

public class Customs {

  public static void main(String[] args) {
    String input = InputLoader.loadString("_06/puzzle-input.txt");

    int answer = Arrays.stream(input.split("\n\n"))
        .mapToInt(in -> {
          String[] ss  = in.split("\n");
          String out = ss[0];
          for (String s : ss) {
            for (String c : out.split("")) {
              if (!s.contains(c)) {
                out = out.replace(c, "");
              }
            }
          }
          return out.length();
        })
        .sum();

    System.out.println(answer);
  }

}
