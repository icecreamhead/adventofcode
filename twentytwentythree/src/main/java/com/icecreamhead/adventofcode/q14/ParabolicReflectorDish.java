package com.icecreamhead.adventofcode.q14;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ParabolicReflectorDish {

  long part1(char[][] input) {
    tiltNorth(input);
    long load = 0;
    for (int rowi = 0; rowi < input.length; rowi++) {
      char[] row = input[rowi];
      for (char c : row) {
        if (c == 'O') {
          load += input.length - rowi;
        }
      }
    }
    return load;
  }

  long part2(char[][] input) {

    long lE = -1;
    long anchor1 = -1, anchor2 = -1;
    long anchor1Ix = -1, anchor2Ix = -1;
    boolean jumpedToWarpSpeed = false;
    for (long i = 0; i < 1_000_000_000; i++) {
      tiltNorth(input);
      tiltWest(input);
      tiltSouth(input);
      tiltEast(input);
      lE = calculateLoad(input);

      // wait for the cycles to settle down then start tracking
      if (i > 1000) {

        if (anchor2Ix != -1 && anchor1Ix != -1 && anchor1 == lE && anchor2 == lE && !jumpedToWarpSpeed) {
          long period = anchor2Ix - anchor1Ix;
          System.out.printf("%d:%d %d:%d %d:%d ==> period is %d%n", anchor1Ix, anchor1, anchor2Ix, anchor2, i, lE, anchor2Ix - anchor1Ix);
//          long jump = period * (((1_000_000_000 - 1000) / period) - period);
//          System.out.printf("Adding %d to i (%d => %d)%n", jump, i, i + jump);
//          i += jump;
          while (i < 1_000_000_000) i += period;
          i -= period;
          System.out.println("Fast-forwarded to end! i is now " + i);
          jumpedToWarpSpeed = true;
        } else if (anchor2Ix == -1 && anchor1 == lE) {
          anchor2Ix = i;
          anchor2 = lE;
        } else if (anchor1Ix == -1) {
          anchor1Ix = i;
          anchor1 = lE;
        }
//        if (i > 999_999_980) {
//          System.out.printf("%d => %d%n", i, lE);
//        }
      }
    }

    return lE;
  }

  private static long calculateLoad(char[][] input) {
    long load = 0;
    for (int rowi = 0; rowi < input.length; rowi++) {
      char[] row = input[rowi];
      for (char c : row) {
        if (c == 'O') {
          load += input.length - rowi;
        }
      }
    }
    return load;
  }

  private static void tiltNorth(char[][] input) {
    int[] nextSpace = new int[input[0].length];
    Arrays.fill(nextSpace, -1);

    for (int rowi = 0; rowi < input.length; rowi++) {

      char[] row = input[rowi];
      for (int coli = 0; coli < row.length; coli++) {
        // first see if there are any boulders in this row that we can move up (skip first row)
        if (rowi > 0) {
          if (row[coli] == 'O' && nextSpace[coli] != -1) {
//            System.out.printf("Moving boulder at (%d,%d) to (%d,%d)%n", coli, rowi, coli, nextSpace[coli]);
            input[nextSpace[coli]][coli] = 'O';
            row[coli] = '.';
            nextSpace[coli]++;
          }
        }

        // then update the status for the next iteration
//        System.out.printf("(%d,%d): '%s' == '%s'? %s%n", coli, rowi, row[coli], 'O', row[coli] == 'O');
        if (row[coli] == 'O' || row[coli] == '#') {
          nextSpace[coli] = -1;
        } else if (row[coli] == '.' && nextSpace[coli] == -1) {
//          System.out.printf("Setting nextSpace (%d,%d)%n", coli, rowi);
          nextSpace[coli] = rowi;
        }
      }
    }
  }

  private static void tiltWest(char[][] input) {
    int[] nextSpace = new int[input.length];
    Arrays.fill(nextSpace, -1);

    for (int coli = 0; coli < input[0].length; coli++) {

      for (int rowi = 0; rowi < input.length; rowi++) {
        // first see if there are any boulders in this row that we can move up (skip first col)
        if (coli > 0) {
          if (input[rowi][coli] == 'O' && nextSpace[rowi] != -1) {
//            System.out.printf("Moving boulder at (%d,%d) to (%d,%d)%n", coli, rowi, coli, nextSpace[rowi]);
            input[rowi][nextSpace[rowi]] = 'O';
            input[rowi][coli] = '.';
            nextSpace[rowi]++;
          }
        }

        // then update the status for the next iteration
//        System.out.printf("(%d,%d): '%s' == '%s'? %s%n", coli, rowi, input[rowi][coli], 'O', input[rowi][coli] == 'O');
        if (input[rowi][coli] == 'O' || input[rowi][coli] == '#') {
          nextSpace[rowi] = -1;
        } else if (input[rowi][coli] == '.' && nextSpace[rowi] == -1) {
//          System.out.printf("Setting nextSpace[%d]=%d%n", rowi, coli);
          nextSpace[rowi] = coli;
        }
      }
    }
  }

  private static void tiltSouth(char[][] input) {
    int[] nextSpace = new int[input[0].length];
    Arrays.fill(nextSpace, -1);

    for (int rowi = input.length - 1; rowi >= 0; rowi--) {
      char[] row = input[rowi];
      for (int coli = 0; coli < row.length; coli++) {
        // first see if there are any boulders in this row that we can move up (skip first row)
        if (rowi < input.length - 1) {
          if (row[coli] == 'O' && nextSpace[coli] != -1) {
            input[nextSpace[coli]][coli] = 'O';
            row[coli] = '.';
            nextSpace[coli]--;
          }
        }

        // then update the status for the next iteration
        if (row[coli] == 'O' || row[coli] == '#') {
          nextSpace[coli] = -1;
        } else if (row[coli] == '.' && nextSpace[coli] == -1) {
          nextSpace[coli] = rowi;
        }
      }
    }
  }

  private static void tiltEast(char[][] input) {
    int[] nextSpace = new int[input.length];
    Arrays.fill(nextSpace, -1);

    for (int coli = input[0].length - 1; coli >= 0; coli--) {

      for (int rowi = 0; rowi < input.length; rowi++) {
        // first see if there are any boulders in this row that we can move up (skip first col)
        if (coli < input[0].length - 1) {
          if (input[rowi][coli] == 'O' && nextSpace[rowi] != -1) {
//            System.out.printf("Moving boulder at (%d,%d) to (%d,%d)%n", coli, rowi, coli, nextSpace[rowi]);
            input[rowi][nextSpace[rowi]] = 'O';
            input[rowi][coli] = '.';
            nextSpace[rowi]--;
          }
        }

        // then update the status for the next iteration
//        System.out.printf("(%d,%d): '%s' == '%s'? %s%n", coli, rowi, input[rowi][coli], 'O', input[rowi][coli] == 'O');
        if (input[rowi][coli] == 'O' || input[rowi][coli] == '#') {
          nextSpace[rowi] = -1;
        } else if (input[rowi][coli] == '.' && nextSpace[rowi] == -1) {
//          System.out.printf("Setting nextSpace[%d]=%d%n", rowi, coli);
          nextSpace[rowi] = coli;
        }
      }
    }
  }

  private static void printGrid(char[][] input) {
    for (char[] line : input) {
      System.out.println(new String(line));
    }
    System.out.println();
  }

}
