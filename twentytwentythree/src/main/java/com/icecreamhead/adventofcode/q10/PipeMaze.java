package com.icecreamhead.adventofcode.q10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PipeMaze {

  long part1(char[][] input) {

    Pos pos = findStart(input);

    long x = 0;
    Pos prev = null, tmp = null;
    do {
      tmp = pos;
      pos = pos.next(prev, input);
      prev = tmp;
//            System.out.println(pos);
      x++;
    } while (pos.tile != 'S');

    return x % 2 == 0 ? x / 2 : (x + 1) / 2;
  }

  long part2(char[][] input) {

    Set<Pos> pipes = new HashSet<>();
    Pos pos = findStart(input);
    System.out.println("Start: " + pos);
    pipes.add(pos);

    long x = 0;
    Pos prev = null, tmp;
    Pos first = null, last;
    do {
      tmp = pos;
      pos = pos.next(prev, input);
      if (tmp.tile == 'S') {
        first = pos;
      }
      pipes.add(pos);
      prev = tmp;
//            System.out.println(pos);
      x++;
    } while (pos.tile != 'S');
    last = prev;
    System.out.printf("First: %s Last: %s%n", first, last);
//    for (char[] chars : input) {
//      System.out.println(new String(chars));
//    }
    input[pos.y][pos.x] = inferStartTile(first, last);

    int count = 0;
    boolean inside = false;

    for (int rowi = 0; rowi < input.length; rowi++) {
      char entryCorner = '!';
//      System.out.println(new String(input[rowi]));
//      System.out.printf("%s ", new String(input[rowi]));
      for (int coli = 0; coli < input[rowi].length; coli++) {
        int y_ = rowi, x_ = coli;
        char tile = input[y_][x_];
        boolean isPipe = pipes.stream().anyMatch(p -> p.x == x_ && p.y == y_);
        if (isPipe && entryCorner == '!' && (tile == 'F' || tile == 'L')) {
          entryCorner = tile;
//          System.err.printf("First corner (%d,%d): %s%n",x_,y_,entryCorner);
        }
//        System.out.print(isPipe ? "#" : "-");
        if (isPipe) {
//          System.out.print(tile);
          if (tile == '|' || (entryCorner == 'F' && tile == 'J') || (entryCorner == 'L' && tile == '7')) {
//                        System.err.printf("Inc pipesCrossed %s(%d,%d) [%s]%n", tile, x_,y_, entryCorner);
            entryCorner = '!';
            inside = !inside;
//            System.out.println(" => "+ (inside?"inside":"outside"));
          } else if ((entryCorner == 'F' && tile == '7') || (entryCorner == 'L' && tile == 'J')) {
            entryCorner = '!';
//            System.out.println(" => "+ (inside?"inside":"outside"));
          }
        } else if (inside) {
//                    System.out.printf("Adding %s(%d,%d)%n", tile, x_, y_);
//          System.out.print("o");
          count++;
        }
//        else {
//          System.out.print(".");
//        }
      }
//      System.out.println();
    }

    return count;
  }

  private static char inferStartTile(Pos first, Pos last) {
    if (last.x < first.x) {
      if (last.y > first.y) {
        return 'F';
      }
      if (last.y < first.y) {
        return 'L';
      }
      return '-';
    }
    if (last.x > first.x) {
      if (last.y < first.y) {
        return 'J';
      }
      if (last.y > first.y) {
        return '7';
      }
      return '-';
    }
    return '|';
  }

  private static Pos findStart(char[][] input) {
    for (int y = 0; y < input.length; y++) {
      for (int x = 0; x < input[y].length; x++) {
        if (input[y][x] == 'S') {
          return new Pos(input[y][x], x, y);
        }
      }
    }
    throw new IllegalStateException();
  }

  record Pos(char tile, int x, int y) {

    Pos next(Pos prev, char[][] tiles) {
      boolean tileNorth = y > 0, tileEast = x < tiles.length - 1, tileSouth = y < tiles[0].length - 1, tileWest = x > 0;
      return switch (tile) {
        case 'S' -> {
          if (tileNorth && (tiles[y - 1][x] == '|' || tiles[y - 1][x] == 'F' || tiles[y - 1][x] == '7')) {
            yield new Pos(tiles[y - 1][x], x, y - 1);
          }
          if (tileEast && (tiles[y][x + 1] == '-' || tiles[y][x + 1] == 'J' || tiles[y][x + 1] == '7')) {
            yield new Pos(tiles[y][x + 1], x + 1, y);
          }
          if (tileSouth && (tiles[y + 1][x] == '|' || tiles[y + 1][x] == 'J' || tiles[y + 1][x] == 'L')) {
            yield new Pos(tiles[y + 1][x], x, y + 1);
          }
          if (tileWest && (tiles[y][x - 1] == '-' || tiles[y][x - 1] == 'L' || tiles[y][x - 1] == 'F')) {
            yield new Pos(tiles[y][x - 1], x - 1, y);
          }
          throw new IllegalStateException();
        }
        case 'F' -> prev.x == x + 1 && prev.y == y ? new Pos(tiles[y + 1][x], x, y + 1) : new Pos(tiles[y][x + 1], x + 1, y);
        case 'J' -> prev.x == x && prev.y == y - 1 ? new Pos(tiles[y][x - 1], x - 1, y) : new Pos(tiles[y - 1][x], x, y - 1);
        case '-' -> prev.x == x + 1 && prev.y == y ? new Pos(tiles[y][x - 1], x - 1, y) : new Pos(tiles[y][x + 1], x + 1, y);
        case '|' -> prev.x == x && prev.y == y - 1 ? new Pos(tiles[y + 1][x], x, y + 1) : new Pos(tiles[y - 1][x], x, y - 1);
        case 'L' -> prev.x == x + 1 && prev.y == y ? new Pos(tiles[y - 1][x], x, y - 1) : new Pos(tiles[y][x + 1], x + 1, y);
        case '7' -> prev.x == x - 1 && prev.y == y ? new Pos(tiles[y + 1][x], x, y + 1) : new Pos(tiles[y][x - 1], x - 1, y);
        default -> throw new IllegalStateException();
      };
    }
  }
}
