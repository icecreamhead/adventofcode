package com.icecreamhead.adventofcode.eleven;

import java.util.Arrays;

public class Hexes {

  private int[] coordinates = new int[]{0, 0, 0};
  private int furthest = 0;

  public void add(Direction direction) {
    int[] before = Arrays.copyOf(coordinates, 3);
    coordinates = direction.add(coordinates);
    if (!Arrays.equals(before, coordinates)) {
      System.out.println("Adding " + Arrays.toString(direction.offsets) + " to " + Arrays.toString(before) + " = " + Arrays.toString(coordinates));
    }
    before = Arrays.copyOf(coordinates, 3);
    coordinates = reduce(coordinates);
    if (!Arrays.equals(before, coordinates)) {
      System.out.println("Reduced " + Arrays.toString(before) + " to " + Arrays.toString(coordinates));
    }

    if (getDistance() > furthest) {
      furthest = getDistance();
    }
  }

  static int[] reduce(int[] coords) {
    if ((coords[1] > 0 && coords[2] > 0) || (coords[0] < 0 && coords[1] > 0) || (coords[0] < 0 && coords[2] > 0)) {
      return new int[]{coords[0] + 1, coords[1] - 1, coords[2] - 1};
    } else if ((coords[0] > 0 && coords[2] < 0) || (coords[1] < 0 && coords[2] < 0) || (coords[0] > 0 && coords[1] < 0)) {
      return new int[]{coords[0] - 1, coords[1] + 1, coords[2] + 1};
    }
    return coords;
  }

  int getDistance() {
    int d = Arrays.stream(coordinates).map(Math::abs).sum();
    System.out.println("Current coords: " + Arrays.toString(coordinates) + " Distance = " + d);
    return d;
  }

  int getFurthest() {
    return furthest;
  }

  enum Direction {
    N(1, 0, 0),
    NE(0, 1, 0),
    NW(0, 0, 1),
    S(-1, 0, 0),
    SW(0, -1, 0),
    SE(0, 0, -1);

    private final int[] offsets;

    Direction(int... offsets) {
      if (offsets.length != 3)
        throw new IllegalArgumentException();
      this.offsets = offsets;
    }

    int[] add(int[] coords) {
      return new int[]{coords[0] + offsets[0], coords[1] + offsets[1], coords[2] + offsets[2]};
    }
  }
}
