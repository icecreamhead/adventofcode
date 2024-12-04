package com.icecreamhead.adventofcode.q4;

import java.util.Arrays;

public class CeresSearch {

  long pt1(char[][] input) {
    long sum = 0;
    for (int y = 0; y < input.length; y++) {
      for (int x = 0; x < input[y].length; x++) {
        try { // horizonal left to right
          sum += xmas(new char[]{input[y][x], input[y][x + 1], input[y][x + 2], input[y][x + 3]});
        } catch (ArrayIndexOutOfBoundsException e) {
          //
        }
        try { // vertical top to bottom
          sum += xmas(new char[]{input[y][x], input[y + 1][x], input[y + 2][x], input[y + 3][x]});
        } catch (ArrayIndexOutOfBoundsException e) {
          //
        }
        try { // diagonal top l to bottom r
          sum += xmas(new char[]{input[y][x], input[y + 1][x + 1], input[y + 2][x + 2], input[y + 3][x + 3]});
        } catch (ArrayIndexOutOfBoundsException e) {
          //
        }
        try { // diagonal top r to bottom l
          sum += xmas(new char[]{input[y][x + 3], input[y + 1][x + 2], input[y + 2][x + 1], input[y + 3][x]});
        } catch (ArrayIndexOutOfBoundsException e) {
          //
        }

      }
    }
    return sum;
  }

  private int xmas(char[] input) {
    String s = new String(input);
    return s.equals("XMAS") || s.equals("SAMX") ? 1 : 0;
  }

  long pt2(char[][] i) {
    long sum = 0;
    for (int y = 0; y < i.length; y++) {
      for (int x = 0; x < i[y].length; x++) {
        try {
          if (xmas(new char[][]{
              new char[]{i[y][x], i[y][x + 1], i[y][x + 2]},
              new char[]{i[y + 1][x], i[y + 1][x + 1], i[y + 1][x + 2]},
              new char[]{i[y + 2][x], i[y + 2][x + 1], i[y + 2][x + 2]}
          })) {
            sum++;
          }
        } catch (ArrayIndexOutOfBoundsException e) {
          //
        }
      }
    }
    return sum;
  }

  private boolean xmas(char[][] input) {
    return input[1][1] == 'A' && (input[0][0] == 'M' && input[2][2] == 'S' || input[0][0] == 'S' && input[2][2] == 'M') && (input[0][2] == 'M' && input[2][0] == 'S' || input[0][2] == 'S' && input[2][0] == 'M');
  }


}
