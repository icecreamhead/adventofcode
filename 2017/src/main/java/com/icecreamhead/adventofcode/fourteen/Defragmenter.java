package com.icecreamhead.adventofcode.fourteen;

import com.icecreamhead.adventofcode.ten.KnotRunner;

public class Defragmenter {

  private final Disk disk = new Disk();

  public int evaluateUsedBits(String input) {
    buildState(input);
    return disk.countUsed();
  }

  private void addRow(String rowString, int row) {
    KnotRunner runner = new KnotRunner(256);
    String hash = runner.runN(rowString, 64);
    String binary = hashToBinary(hash);
    disk.setValues(row, binary);
  }

  private void buildState(String input) {
    for (int i = 0; i < 128; i++) {
      addRow(input + "-" + i, i);
    }
  }

  static String hashToBinary(String hash) {
    StringBuilder bob = new StringBuilder();
    for (char c : hash.toCharArray()) {
      String s = Character.toString(c);
      int i = Integer.parseInt(s, 16);
      String b = Integer.toBinaryString(i);
      for (int j = b.length(); j < 4; j++) {
        bob.append("0");
      }
      bob.append(b);
    }
    if (hash.length() * 4 != bob.toString().length()) throw new IllegalStateException();
    return bob.toString();
  }

  public int evaluateRegions(String input) {
    buildState(input);
    return disk.countRegions();
  }
}
