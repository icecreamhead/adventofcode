package com.icecreamhead.adventofcode.q17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class ChronospatialComputer {

  private long a;
  private long b = 0;
  private long c = 0;
  private final int[] program;
  private int ptr = 0;
  private final ArrayList<Integer> output = new ArrayList<>();

  ChronospatialComputer(long a, String program) {
    assert a >= 0;
    this.a = a;
    this.program = Arrays.stream(program.split(",")).mapToInt(Integer::parseInt).toArray();
  }

  String run() {

    try {

      while (program[ptr] < 8) {
        switch (program[ptr]) {
          case 0 -> adv();
          case 1 -> bxl();
          case 2 -> bst();
          case 3 -> jnz();
          case 4 -> bxc();
          case 5 -> out();
          case 6 -> bdv();
          case 7 -> cdv();
          default -> throw new IllegalStateException("Illegal opcode: " + program[ptr]);
        }
//        System.out.printf("%d %d %d %s%n", a, b, c, output);
      }

    } catch (ArrayIndexOutOfBoundsException e) {
      return output.stream().map(String::valueOf).collect(Collectors.joining(","));
    }
    throw new IllegalStateException("Illegal opcode: " + program[ptr]);
  }

  private void cdv() {
    try {
      setC(trunc(a / (long) Math.pow(2, combo())));
    } catch (ArithmeticException e) {
      throw new IllegalStateException("Illegal combo operand: " + program[ptr]);
    }
    ptr += 2;
  }

  private void bdv() {
    setB(trunc(a / (long) Math.pow(2, combo())));
    ptr += 2;
  }

  private void out() {
    output.add(((int) combo()) % 8);
    ptr += 2;
  }

  private void bxc() {
    setB(b ^ c);
    ptr += 2;
  }

  private void jnz() {
    ptr = a == 0 ? ptr + 2 : (int) literal();
  }

  private void bst() {
    setB(combo() % 8);
    ptr += 2;
  }

  private void adv() {
    setA(trunc(a / (long) Math.pow(2, combo())));
    ptr += 2;
  }

  private void bxl() {
    setB(b ^ literal());
    ptr += 2;
  }

  private void setA(long a) {
    assert a >= 0;
    this.a = a;
  }

  private void setB(long b) {
    assert b >= 0;
    this.b = b;
  }

  private void setC(long c) {
    assert c >= 0;
    this.c = c;
  }

  private long literal() {
    return program[ptr + 1];
  }

  private long combo() {
    return switch (program[ptr + 1]) {
      case 0, 1, 2, 3 -> program[ptr + 1];
      case 4 -> a;
      case 5 -> b;
      case 6 -> c;
      default -> throw new IllegalStateException("Illegal combo operand: " + program[ptr + 1]);
    };
  }

  private static int trunc(long l) {
    return l > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) l;
  }
}
