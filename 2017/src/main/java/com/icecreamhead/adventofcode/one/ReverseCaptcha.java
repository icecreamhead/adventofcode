package com.icecreamhead.adventofcode.one;


import static com.icecreamhead.adventofcode.util.Converter.stringToIntArray;

class ReverseCaptcha {

  int solvePart1(String input) {
    return solve(stringToIntArray(input), i -> (i + 1) % input.length());
  }

  int solvePart2(String input) {
    return solve(stringToIntArray(input), i -> (i + input.length() / 2) % input.length());
  }

  private int solve(int[] ints, Idx idx) {
    int total = 0;
    for (int i = 0; i < ints.length; i++) {
      if (ints[i] == ints[idx.get(i)]) {
        total += ints[i];
      }
    }
    return total;
  }

  private interface Idx {
    int get(int idx);
  }
}
