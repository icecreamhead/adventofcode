package com.icecreamhead.adventofcode.q6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GuardGallivant {

  private static final char UP = '^';
  private static final char DOWN = 'V';
  private static final char LEFT = '<';
  private static final char RIGHT = '>';
  private static final Set<Character> GUARD = Set.of(UP, DOWN, LEFT, RIGHT);

  long pt1(char[][] map) {

    int x = -1, y = -1;
    char g = '.';
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        if (GUARD.contains(map[i][j])) {
          x = j;
          y = i;
          g = map[i][j];
          break;
        }
      }
      if (GUARD.contains(g)) break;
    }

    HashSet<P> been = new HashSet<>();
    been.add(new P(g, x, y));
    while (true) {
//      System.out.printf("%s (%d, %d)\n", g, x, y);
//      print(map, g, x, y);
      try {
        int nextx = x, nexty = y;
        switch (g) {
          case UP -> nexty = y - 1;
          case DOWN -> nexty = y + 1;
          case LEFT -> nextx = x - 1;
          case RIGHT -> nextx = x + 1;
        }

        if (map[nexty][nextx] == '.' || GUARD.contains(map[nexty][nextx])) {
          x = nextx;
          y = nexty;
          been.add(new P(g, x, y));
        } else if (map[nexty][nextx] == '#') {
          g = rotate90(g);
        }

//        Thread.sleep(1000);
      } catch (Exception e) {
        break;
      }
    }

    return been.stream().map(p -> new P('!', p.x, p.y)).distinct().count();
  }

  long pt2(char[][] map) {

    int x = -1, y = -1;
    char g = '.';
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        if (GUARD.contains(map[i][j])) {
          x = j;
          y = i;
          g = map[i][j];
          break;
        }
      }
      if (GUARD.contains(g)) break;
    }

    ArrayList<P> blocks = new ArrayList<>();
    HashSet<P> been = new HashSet<>();
    been.add(new P(g, x, y));
    while (true) {
//      System.out.printf("%s (%d, %d)\n", g, x, y);
//      print(map, g, x, y);
      try {
        int nextx = x, nexty = y;
        switch (g) {
          case UP -> nexty = y - 1;
          case DOWN -> nexty = y + 1;
          case LEFT -> nextx = x - 1;
          case RIGHT -> nextx = x + 1;
        }

        if (map[nexty][nextx] == '.' || GUARD.contains(map[nexty][nextx])) {
          x = nextx;
          y = nexty;
          been.add(new P(g, x, y));
          if (newPathIntersectsExistingPath(been, map, rotate90(g), x, y)) {
            switch (g) {
              case UP -> blocks.add(new P('O', x, y - 1));
              case RIGHT -> blocks.add(new P('O', x + 1, y));
              case DOWN -> blocks.add(new P('O', x, y + 1));
              case LEFT -> blocks.add(new P('O', x - 1, y));
              default -> throw new IllegalStateException("Unexpected value: " + g);
            }

          }
        } else if (map[nexty][nextx] == '#') {
          g = rotate90(g);
        }

      } catch (Exception e) {
        break;
      }
    }
//    System.out.println(blocks);

//     blocks.forEach(b -> print(map, b.g, b.x, b.y));

    return blocks.size();
  }

  private static boolean newPathIntersectsExistingPath(Set<P> been, char[][] map, char g, int x, int y) {
    while (true) {
//      print(map, g, x, y);
      try {
        if (map[y][x] == '#') return false; // need to recurse here
      } catch (ArrayIndexOutOfBoundsException e) {
//        System.err.println(e);
        return false;
      }
      if (been.contains(new P(g, x, y))) return true;
      switch (g) {
        case UP -> y--;
        case DOWN -> y++;
        case LEFT -> x--;
        case RIGHT -> x++;
      }
    }
  }

  private static char rotate90(char g) {
    return switch (g) {
      case UP -> RIGHT;
      case RIGHT -> DOWN;
      case DOWN -> LEFT;
      case LEFT -> UP;
      default -> throw new IllegalStateException("Unexpected value: " + g);
    };
  }

  private record P(char g, int x, int y) {}

  private static void print(char[][] map, char g, int x, int y) {
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        if (j == x && i == y) {
          System.out.print(g);
        } else if (map[i][j] == '^') {
          System.out.print('.');
        } else {
          System.out.print(map[i][j]);
        }
      }
      System.out.println();
    }
    System.out.println();
  }
}
