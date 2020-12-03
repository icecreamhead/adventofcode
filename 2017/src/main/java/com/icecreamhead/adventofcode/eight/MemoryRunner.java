package com.icecreamhead.adventofcode.eight;

public class MemoryRunner {

  private final Memory memory = new Memory();

  public Memory parse(String input) {
    for (String instruction : input.split("\n")) {
      memory.consume(instruction);
    }
    return memory;
  }
}
