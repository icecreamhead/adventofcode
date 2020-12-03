package com.icecreamhead.adventofcode.six;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MemoryBank {
  private final int[] blocks;
  private final Set<Integer> seen;

  public MemoryBank(int[] blocks) {
    this(blocks, new HashSet<>());
  }

  public MemoryBank(int[] blocks, Set<Integer> seen) {
    this.blocks = blocks;
    this.seen = seen;
  }

  public MemoryBank next() {
    seen.add(Arrays.hashCode(blocks));
    return new MemoryBank(redistribute(blocks), seen);
  }

  private int[] redistribute(int[] blocks) {
    // Find idx to redistribute
    int idx = -1;
    int count = -1;
    for (int i = 0; i < blocks.length; i++) {
      if (blocks[i] > count) {
        idx = i;
        count = blocks[i];
      }
    }
    blocks[idx] = 0;
//    System.out.println(idx + ":" + count);
    // Do the redisribution
    do {
      idx = (idx + 1) % blocks.length;
//      System.out.println("blocks[" + idx + "]=" + blocks[idx] + " -> " + (blocks[idx] + 1));
      blocks[idx]++;
      count--;
    } while (count > 0);

    return blocks;
  }

  public boolean done() {
    return seen.contains(Arrays.hashCode(blocks));
  }

  public void clearSeen() {
    seen.clear();
  }

  public int solution() {
    return seen.size();
  }

  @Override
  public String toString() {
    return "MemoryBank{" +
        "blocks=" + Arrays.toString(blocks) +
        ", seen=" + seen.size() +
        '}';
  }
}
