package com.icecreamhead.adventofcode.five;

import java.util.Arrays;

public class InstructionSet {

  private final int[] instructions;
  private final int counter;
  private final int pointer;

  public InstructionSet(int[] instructions) {
    this(instructions, 0, 0);
  }

  public InstructionSet(int[] instructions, int counter, int pointer) {
    this.instructions = instructions;
    this.counter = counter;
    this.pointer = pointer;
  }

  public InstructionSet nextP1() {
    int instruction = instructions[pointer];
    instructions[pointer] = instruction + 1;
    return new InstructionSet(instructions, counter + 1, instruction + pointer);
  }

  public InstructionSet nextP2() {
    int instruction = instructions[pointer];
    instructions[pointer] = instruction < 3 ? instruction + 1 : instruction - 1;
    return new InstructionSet(instructions, counter + 1, instruction + pointer);
  }

  public boolean done() {
    return pointer < 0 || pointer >= instructions.length;
  }

  public int getCounter() {
    return counter;
  }

  @Override
  public String toString() {
    return "InstructionSet{" +
        "instructions=" + Arrays.toString(instructions) +
        ", counter=" + counter +
        ", pointer=" + pointer +
        '}';
  }
}
