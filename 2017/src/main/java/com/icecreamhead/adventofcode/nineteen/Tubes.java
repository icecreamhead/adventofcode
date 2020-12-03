package com.icecreamhead.adventofcode.nineteen;

import com.icecreamhead.adventofcode.util.Converter;

import java.util.ArrayList;
import java.util.List;

import static com.icecreamhead.adventofcode.nineteen.Direction.DOWN;
import static com.icecreamhead.adventofcode.nineteen.Direction.LEFT;
import static com.icecreamhead.adventofcode.nineteen.Direction.RIGHT;
import static com.icecreamhead.adventofcode.nineteen.Direction.UP;

public class Tubes {

  private final String[][] grid;

  private final List<String> seen = new ArrayList<>();
  private final long length;

  public Tubes(String input) {
    this.grid = Converter.multilineStringToCharacterGrid(input);
    this.length = grid.length * grid[0].length;
    System.out.println("Grid size: " + grid.length + "x" + grid[0].length + "=" + length);
  }

  private static final List<String> PATHS = List.of("|", "-", "+", " ");

  public List<String> traverse() {
    long i = 0;
    int[] start = start();
    Vector next = next(new Vector(start[0], start[1], Direction.DOWN));
    while (next != null) {
      try {
        String sym = getSym(next);
        if (sym != null && !PATHS.contains(sym)) {
//          System.out.println(getSym(next));
          seen.add(getSym(next));
        }
        next = next(next);
        i++;
        if (i > length) {
          throw new IllegalStateException();
        }
      } catch (Exception e) {
        break;
      }
    }
    return seen;
  }

  private int[] start() {
    for (int y = 0; y < grid[0].length; y++) {
      if (grid[0][y].equals("|"))
        return new int[]{0, y};
    }
    throw new IllegalStateException();
  }

  private String getSym(Vector vector) {
//    System.out.println("retrieving sym (" + vector.x + "," + vector.y + ") = '"+grid[vector.x][vector.y]+"'");
    return grid[vector.x][vector.y];
  }

  private Vector next(Vector current) {
    String s = getSym(current);
    if (s.equals("+")) {
      for (Direction nextDir : current.direction.turns()) {
        try {
          int[] coords = nextDir.next(current.coords());
          Vector v = new Vector(coords[0], coords[1], nextDir);
          String nextSym = getSym(v);
          if (nextSym.equals(" ")) {
            continue;
          } else if ((current.direction == UP || current.direction == DOWN) && nextSym.equals("|")) {
            continue;
          } else if ((current.direction == LEFT || current.direction == RIGHT) && nextSym.equals("-")) {
            continue;
          }
//          System.out.println("next=(" + v.x + "," + v.y + ")");
          return v;
        } catch (Exception e) {
          // do nothing
        }
      }
      return null;
    }

    int[] coords = current.direction.next(current.coords());

    if (coords == null) {
      return null;
    }

    return new Vector(coords[0], coords[1], current.direction);
  }

  private static class Vector {
    private final int x;
    private final int y;
    private final Direction direction;

    private Vector(int x, int y, Direction direction) {
      this.x = x;
      this.y = y;
      this.direction = direction;
    }

    private int[] coords() {
      return new int[]{x, y};
    }
  }
}
