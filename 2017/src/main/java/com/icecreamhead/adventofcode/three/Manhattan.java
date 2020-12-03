package com.icecreamhead.adventofcode.three;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Manhattan {

  private final Map<String, Integer> values = new HashMap<>();

  static final int[] ORIGIN = {0, 0};
  private static final Vector START = new Vector(ORIGIN, null);

  int solvePart1(int input) {
    int[] coords = getCoordsLoopy(input);
    return Math.abs(coords[0]) + Math.abs(coords[1]);
  }

  int solvePart2(int input) {
    getCoordsLoopy(input); // populate the map
    for (int i = 1; i < input; i++) {
      int x = getVal(getCoordsLoopy(i));
//      System.out.println("Input " + i + ", getVal " + x + (x > input ? ">" : "<") + input);
      if (x > input) {
        return x;
      }
    }
    throw new IllegalStateException();
  }

  private int[] getCoordsRecursive(int target, int current, boolean newPhase, int step, int len, Vector v) {
    System.out.println(v + ": " + current);

    if (current == target)
      return v.coords;

    if (step == len) {
      return getCoordsRecursive(target, current + 1, !newPhase, 1, newPhase ? len + 1 : len, v.next(true));
    } else {
      return getCoordsRecursive(target, current + 1, newPhase, step + 1, len, v.next(false));
    }
  }

  private int getVal(int[] coords) {
    return values.getOrDefault(toKey(coords), 0);
  }

  private int calcVal(int[] coords) {
    if (Arrays.equals(coords, ORIGIN)) {
      return 1;
    }
    return Arrays.stream(adjacents(coords))
        .mapToInt(this::getVal)
        .sum();
  }

  private int[] getCoordsLoopy(int target) {
    int current = 1;
    boolean newPhase = false;
    int step = 0;
    int len = 1;
    Vector v = START;

    while (current != target) {
      String k = toKey(v.coords);
      int val = calcVal(v.coords);
//      System.out.println("Adding (" + k + "): " + val);
      values.put(k, val);

      if (step == len) {
        len = newPhase ? len + 1 : len;
        newPhase = !newPhase;
        v = v.next(true);
        step = 1;
      } else {
        step++;
        v = v.next(false);
      }
      current++;
    }
    return v.coords;
  }

  enum Direction implements Next {
    UP {
      @Override
      public Vector next(int[] xy, boolean turn) {
        return turn ? LEFT.next(xy, false) : new Vector(new int[]{xy[0], xy[1] + 1}, this);
      }
    },

    DOWN {
      @Override
      public Vector next(int[] xy, boolean turn) {
        return turn ? RIGHT.next(xy, false) : new Vector(new int[]{xy[0], xy[1] - 1}, this);
      }
    },

    LEFT {
      @Override
      public Vector next(int[] xy, boolean turn) {
        return turn ? DOWN.next(xy, false) : new Vector(new int[]{xy[0] - 1, xy[1]}, this);
      }
    },

    RIGHT {
      @Override
      public Vector next(int[] xy, boolean turn) {
        return turn ? UP.next(xy, false) : new Vector(new int[]{xy[0] + 1, xy[1]}, this);
      }
    }
  }

  static class Vector {
    private final int[] coords;
    private final Direction direction;

    Vector(int[] coords, Direction direction) {
      this.coords = coords;
      this.direction = direction;
    }

    Vector next(boolean turn) {
      if (direction == null) {
        return Direction.RIGHT.next(coords, turn);
      }
      return direction.next(coords, turn);
    }

    @Override
    public String toString() {
      return "Vector{" +
          "coords=" + Arrays.toString(coords) +
          ", direction=" + direction +
          '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Vector vector = (Vector) o;

      return Arrays.equals(coords, vector.coords) && direction == vector.direction;
    }

    @Override
    public int hashCode() {
      int result = Arrays.hashCode(coords);
      result = 31 * result + (direction != null ? direction.hashCode() : 0);
      return result;
    }
  }

  private static final List<int[]> MASKS = List.of(
      new int[]{1, 0},
      new int[]{1, 1},
      new int[]{1, -1},
      new int[]{-1, 0},
      new int[]{-1, 1},
      new int[]{-1, -1},
      new int[]{0, 1},
      new int[]{0, -1}
  );

  private static int[][] adjacents(int[] coords) {
    return MASKS.stream()
        .map(m -> new int[]{coords[0] + m[0], coords[1] + m[1]})
        .toArray(x -> new int[8][2]);
  }

  private static String toKey(int[] coords) {
    return coords[0] + "," + coords[1];
  }

  private interface Next {
    Vector next(int[] xy, boolean turn);
  }
}
