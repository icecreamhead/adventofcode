package com.icecreamhead.adventofcode.q11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CosmicExpansion {

  long part1(char[][] input) {
    return part2(input, 2);
  }

  long part2(char[][] input, int multiplier) {
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
      for (char[] row : input) {
        if (row[coli] != '.') {
          allBlank = false;
          break;
        }
      }
      if (allBlank) {
        emptyCols.add(coli);
      }
    }

//    System.out.printf("Empty rows: %s Empty cols: %s%n", emptyRows, emptyCols);

    return calculateDistances(input, emptyRows, emptyCols, multiplier);
  }

  private long calculateDistances(char[][] input, Set<Integer> emptyRows, Set<Integer> emptyCols, long multiplier) {
    List<Galaxy> galaxies = new ArrayList<>();

    int id = 1;
    for (int row = 0; row < input.length; row++) {
      for (int col = 0; col < input[row].length; col++) {
        if (input[row][col] == '#') {
          galaxies.add(new Galaxy(id, col, row));
          id++;
        }
      }
    }

    long total = 0;
    for (Galaxy galaxy1 : galaxies) {
      for (Galaxy galaxy2 : galaxies) {
        if (galaxy1.id < galaxy2.id && !(galaxy1.x == galaxy2.x && galaxy1.y == galaxy2.y)) {
          int minX = Math.min(galaxy1.x, galaxy2.x);
          int maxX = Math.max(galaxy1.x, galaxy2.x);
          int minY = Math.min(galaxy1.y, galaxy2.y);
          int maxY = Math.max(galaxy1.y, galaxy2.y);
          long xVoids = emptyCols.stream().filter(x -> x > minX && x < maxX).count();
          long yVoids = emptyRows.stream().filter(y -> y > minY && y < maxY).count();
//          System.out.printf("minX=%d maxX=%d xVoids=%d minY=%d maxY=%d yVoids=%d multiplier=%d%n", minX, maxX, xVoids, minY, maxY, yVoids, multiplier);
          total += ((maxX - minX - xVoids + (multiplier * xVoids)) + (maxY - minY - yVoids + (multiplier * yVoids)));
        }
      }
    }

    return total;
  }

  private static boolean allEmpty(char[] row) {
    for (char c : row) {
      if (c != '.') {
        return false;
      }
    }
    return true;
  }
  record Galaxy(int id, int x, int y){}
}
