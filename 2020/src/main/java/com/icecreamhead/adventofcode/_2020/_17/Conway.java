package com.icecreamhead.adventofcode._2020._17;

import com.icecreamhead.adventofcode.util.InputLoader;

public class Conway {

  private static final char ACTIVE = '#';
  private static final char INACTIVE = '.';


  // char[z][y][x]
  private static final char[][][] INITIAL_CUBES = new char[][][]{InputLoader.loadGrid("_17/sample-input.txt")};


  public static void main(String[] args) {

    next(INITIAL_CUBES);
    int count = countActiveNeighbours(0, 2, 1, INITIAL_CUBES);
    System.out.println(count);

    for (int i = 0; i < 6; i++) {


    }

  }

  private static char[][][] next(char[][][] cubes) {
    char[][][] next = new char[cubes.length + 2][cubes[0].length + 2][cubes[0][0].length + 2];

    for (int z = 0; z < cubes.length; z++) {
      for (int y = 0; y < cubes[z].length; y++) {
        for (int x = 0; x < cubes[z][y].length; x++) {
          System.out.printf("%d,%d,%d=%c\n", x, y, z, cubes[z][y][x]);
        }
      }
    }

    return next;
  }

  private static int countActiveNeighbours(int z, int y, int x, char[][][] cubes) {
    char c = cubes[z][y][x]; // co-ordinate sanity check
    int count = 0;
    for (int z_ = Math.max(0, z - 1); z_ < Math.min(cubes.length, z + 2); z_++) {
      char[][] zLayer = cubes[z_];
      for (int y_ = Math.max(0, y - 1); y_ < Math.min(zLayer.length, y + 2); y_++) {
        char[] yLayer = zLayer[y_];
        for (int x_ = Math.max(0, x - 1); x_ < Math.min(yLayer.length, x + 2); x_++) {
          if (x_ == x && y_ == y && z_ == z) continue;
//          System.out.printf("%d,%d,%d=%c\n", x_, y_, z_, yLayer[x_]);
          if (yLayer[x_] == ACTIVE) count++;
        }
      }
    }
    return count;
  }
}
