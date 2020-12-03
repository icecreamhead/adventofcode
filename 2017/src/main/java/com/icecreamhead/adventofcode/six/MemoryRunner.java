package com.icecreamhead.adventofcode.six;

import static com.icecreamhead.adventofcode.util.Converter.stringWithTabsToIntArray;

public class MemoryRunner {

  public int part1(String input) {
    MemoryBank memoryBank = new MemoryBank(stringWithTabsToIntArray(input));
    while (!memoryBank.done()) {
      memoryBank = memoryBank.next();
      System.out.println(memoryBank);
    }
    ;

    return memoryBank.solution();
  }

  public int part2(String input) {
    MemoryBank memoryBank = new MemoryBank(stringWithTabsToIntArray(input));
    while (!memoryBank.done()) {
      memoryBank = memoryBank.next();
    }
    ;

    memoryBank.clearSeen();

    while (!memoryBank.done()) {
      memoryBank = memoryBank.next();
    }
    ;

    return memoryBank.solution();
  }

}
