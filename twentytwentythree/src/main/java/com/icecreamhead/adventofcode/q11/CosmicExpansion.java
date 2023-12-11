package com.icecreamhead.adventofcode.q11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CosmicExpansion {

  long part1(char[][] input) {
    Set<Integer> emptyRows = new HashSet<>();
    Set<Integer> emptyCols = new HashSet<>();

    for (int rowi = 0; rowi < input.length; rowi++) {
      char[] row = input[rowi];
      if (allEmpty(row)) {
        emptyRows.add(rowi);
      }
    }

    for (int coli = 0; coli < input[0].length; coli++) {
      boolean allBlank = true;
      for (int rowi = 0; rowi < input.length; rowi++) {
        if (input[rowi][coli] != '.') {
          allBlank = false;
          break;
        }
      }
      if (allBlank) {
        emptyCols.add(coli);
      }
    }

    System.out.printf("Empty rows: %s Empty cols: %s", emptyRows, emptyCols);

    return calculateDistances(input, emptyRows, emptyCols, 1);
  }

  long part2(char[][] input, int expansion) {
//    printGrid(input);

    for (int rowi = 0; rowi < input.length; rowi++) {
      char[] row = input[rowi];
      if (allEmpty(row)) {
        input = duplicateRow(input, rowi, expansion - 1);
        rowi++;
      }
    }
//    printGrid(input);

    for (int coli = 0; coli < input[0].length; coli++) {
      boolean allBlank = true;
      for (int rowi = 0; rowi < input.length; rowi++) {
        if (input[rowi][coli] != '.') {
          allBlank = false;
          break;
        }
      }
      if (allBlank) {
        input = duplicateCol(input, coli, expansion - 1);
        coli++;
      }
    }
//    printGrid(input);

    return calculateDistances(input, null,null, 1);
  }

  private long calculateDistances(char[][] input, Set<Integer> emptyRows, Set<Integer> emptyCols, long mulitiplier) {
    List<Coord> galaxies = new ArrayList<>();

    for (int row = 0; row < input.length; row++) {
      for (int col = 0; col < input[row].length; col++) {
        if (input[row][col] == '#') galaxies.add(new Coord(col, row));
      }
    }

    long total = 0;
    for (Coord galaxy1 : galaxies) {
      for (Coord galaxy2 : galaxies) {
        if (!galaxy1.equals(galaxy2)) {
          int minX = Math.min(galaxy1.x, galaxy2.x);
          int maxX = Math.max(galaxy1.x, galaxy2.x);
          int minY = Math.min(galaxy1.y, galaxy2.y);
          int maxY = Math.max(galaxy1.y, galaxy2.y);
          long xVoids = emptyCols.stream().filter(x -> x > minX && x < maxX).count();
          long yVoids = emptyCols.stream().filter(y -> y > minY && y < maxY).count();
          // maxX - minX - xVoids + (multiplier * xVoids) + same again for y
          total += (Math.abs(galaxy1.x - galaxy2.x) + Math.abs(galaxy1.y - galaxy2.y));
        }
      }
    }

    return total / 2;
  }

  private static boolean allEmpty(char[] row) {
    for (char c : row) {
      if (c != '.') {
        return false;
      }
    }
    return true;
  }

  private static char[][] duplicateRow(char[][] input, int idx, int times) {
    System.out.printf("Input: %d rows, %d cols%n", input.length, input[0].length);
    char[][] out = new char[input.length + times][input[0].length];
    int offset = 0;
    for (int row = 0; row < input.length; row++) {
      System.out.printf("in.length=%d row=%d offset=%d idx=%d, out.length=%d%n", input.length, row, offset, (row+offset), out.length);
      out[row + offset] = input[row];
      if (row == idx) {
        for (int i = 1; i <= times; i++) {
          System.out.printf("Copying row %d to %d%n", row, row+offset+i);
          out[row + offset + i] = input[row];
        }
        offset++;
      }
    }
    System.out.printf("Output: %d rows, %d cols%n", out.length, out[0].length);
    return out;
  }

  private static char[][] duplicateCol(char[][] input, int idx, int times) {
//    System.out.printf("Input: %d rows, %d cols%n", input.length, input[0].length);
    char[][] out = new char[input.length][input[0].length + times];
    for (int row = 0; row < input.length; row++) {
//      System.out.printf("in.length=%d row=%d offset=%d idx=%d, out.length=%d%n", input.length, row, offset, (row+offset), out.length);
      int offset = 0;
      for (int col = 0; col < input[0].length; col++) {
        out[row][col + offset] = input[row][col];
        if (col == idx) {
          System.out.printf("Copying col %d to %d%n", row, row+offset);
          for (int i = 1; i <= times; i++) {
            out[row][col + offset + i] = input[row][col];
          }
          offset++;
        }
      }
    }
//    System.out.printf("Output: %d rows, %d cols%n", out.length, out[0].length);
    return out;
  }

  private static void printGrid(char[][] grid) {
    for (int y = 0; y < grid.length; y++) {
      System.out.println(y + ":\t" + Arrays.toString(grid[y]));
    }
    System.out.println();
  }

  record Coord(int x, int y){}
}
