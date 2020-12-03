package com.icecreamhead.adventofcode.five;

import static com.icecreamhead.adventofcode.util.Converter.multilineStringToIntArray;

public class InstructionRunner {

  public int part1(String input) {
    InstructionSet instructionSet = new InstructionSet(multilineStringToIntArray(input));
    while (!instructionSet.done()) {
      instructionSet = instructionSet.nextP1();
    }
    ;

    return instructionSet.getCounter();
  }

  public int part2(String input) {
    InstructionSet instructionSet = new InstructionSet(multilineStringToIntArray(input));
//    System.out.println(instructionSet);
    while (!instructionSet.done()) {
      instructionSet = instructionSet.nextP2();
//      System.out.println(instructionSet);
    }
    ;

    return instructionSet.getCounter();
  }

}
