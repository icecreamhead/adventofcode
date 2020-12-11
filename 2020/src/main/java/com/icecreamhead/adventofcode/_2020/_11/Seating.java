package com.icecreamhead.adventofcode._2020._11;

import com.icecreamhead.adventofcode.util.InputLoader;

import static java.util.Arrays.deepEquals;

public class Seating {

  private static final char OCCUPIED = '#';
  private static final char EMPTY = 'L';
  private static final char FLOOR = '.';

  private static final char[][] SEATS = InputLoader.loadGrid("_11/puzzle-input.txt");

  public static void main(String[] args) {
    char[][] before;
    char[][] after = SEATS;

    do {
      before = after;
      after = next(before);
    } while (!deepEquals(before, after));

    printGrid(after);
    System.out.println(countTotalOccupied(after));
  }

  public static int countAdjacentOccupied(char[][] seats, int x, int y) {
    int count = 0;
    for (int _y = -1; _y <= 1; _y++) {
      for (int _x = -1; _x <= 1; _x++) {
        if (_y == 0 && _x == 0)
          continue;

        int i = 1;
        while (y + _y * i >= 0 && y + _y * i < seats.length && x + _x * i >= 0 && x + _x * i < seats[0].length) {
          if (seats[y + _y * i][x + _x * i] == FLOOR) {
            i++;
          } else if (seats[y + _y * i][x + _x * i] == OCCUPIED) {
            count++;
            break;
          } else if (seats[y + _y * i][x + _x * i] == EMPTY) {
            break;
          } else {
            throw new RuntimeException("Whoops");
          }
        }
      }
    }
    return count;
  }

  public static int countTotalOccupied(char[][] seats) {
    int count = 0;
    for (int y = 0; y < seats.length; y++) {
      for (int x = 0; x < seats[0].length; x++) {
        if (seats[y][x] == OCCUPIED) count++;
      }
    }
    return count;
  }

  public static char[][] next(char[][] seats) {
    char[][] newSeats = new char[seats.length][seats[0].length];
    for (int y = 0; y < seats.length; y++) {
      for (int x = 0; x < seats[0].length; x++) {
        if (seats[y][x] == EMPTY && countAdjacentOccupied(seats, x, y) == 0) {
          newSeats[y][x] = OCCUPIED;
        } else if (seats[y][x] == OCCUPIED && countAdjacentOccupied(seats, x, y) >= 5) {
          newSeats[y][x] = EMPTY;
        } else {
          newSeats[y][x] = seats[y][x];
        }
      }
    }
    return newSeats;
  }

  private static void printGrid(char[][] seats) {
    for (int y = 0; y < seats.length; y++) {
      for (int x = 0; x < seats[0].length; x++) {
        System.out.print(seats[y][x]);
      }
      System.out.print(" ");
      for (int x = 0; x < seats[0].length; x++) {
        System.out.print(countAdjacentOccupied(seats, x, y));
      }
      System.out.println();
    }
  }
}
