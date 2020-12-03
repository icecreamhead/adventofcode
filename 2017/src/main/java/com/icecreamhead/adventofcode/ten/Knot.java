package com.icecreamhead.adventofcode.ten;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class Knot {

  private final int[] numbers;

  private int current = 0;
  private int skip = 0;

  public Knot(int count) {
    this.numbers = IntStream.range(0, count).toArray();
  }

  void round(int len) {
//    System.out.println("input=" + len + " current=" + current + " skip=" + skip);
//    System.out.println("Reversing " + current + " to " + (current + len - 1));
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < len; i++) {
      stack.push(numbers[(current + i) % numbers.length]);
    }
    for (int i = 0; i < len; i++) {
      numbers[(current + i) % numbers.length] = stack.pop();
    }
    current = current + len + skip;
    skip++;
  }

  int output() {
    return numbers[0] * numbers[1];
  }

  int[] dense() {
    return dense(numbers);
  }

  static int[] dense(int[] sparse) {
    int l = (int) Math.sqrt(sparse.length);
    if (sparse.length != l * l) throw new IllegalStateException();
    final int[] out = new int[l];
    for (int i = 0; i < l; i++) {
      out[i] = calcDense(Arrays.copyOfRange(sparse, i * l, (i + 1) * l));
    }
    return out;
  }

  static int calcDense(int[] in) {
    return Arrays.stream(in).reduce((x, y) -> x ^ y).orElseThrow(IllegalStateException::new);
  }
}
