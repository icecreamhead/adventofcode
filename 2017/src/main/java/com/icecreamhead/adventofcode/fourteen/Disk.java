package com.icecreamhead.adventofcode.fourteen;

import java.util.Arrays;

public class Disk {

  private final Boolean[][] disk = new Boolean[128][128];

  public int countUsed() {
    return (int) Arrays.stream(disk)
        .mapToLong(row -> Arrays.stream(row).filter(bit -> bit).count())
        .sum();
  }

  public void setValues(int r, String binary) {
    Boolean[] row = disk[r];
    for (int i = 0; i < binary.toCharArray().length; i++) {
      row[i] = binary.charAt(i) == '1';
    }
  }

  public int countRegions() {
    int regions = 0;
    while (findRegion()) {
      regions++;
    }
    return regions;
  }

  private boolean findRegion() {
    for (int i = 0; i < 128; i++) {
      for (int j = 0; j < 128; j++) {
        if (disk[i][j]) {
          System.out.print("\nRegion start: (" + i + "," + j + ") contains ");
          exploreRegion(i, j);
          System.out.println();
          return true;
        }
      }
    }
    return false;
  }

  private void exploreRegion(int i, int j) {
    disk[i][j] = false;
    System.out.print("(" + i + "," + j + ")");
    if (i >= 1 && disk[i - 1][j]) {
      exploreRegion(i - 1, j);
    }
    if (j >= 1 && disk[i][j - 1]) {
      exploreRegion(i, j - 1);
    }
    if (i < 127 && disk[i + 1][j]) {
      exploreRegion(i + 1, j);
    }
    if (j < 127 && disk[i][j + 1]) {
      exploreRegion(i, j + 1);
    }
  }
}
