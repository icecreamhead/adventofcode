package com.icecreamhead.adventofcode.q21;

import java.time.Duration;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.time.DurationFormatUtils;

public class StepCounter {

  long part1(char[][] input, int steps) {
    Pos start = findStart(input);
    input[start.y][start.x] = '.';

    return findPositions(input, Set.of(start), steps).size();
  }
  long part2(char[][] input, int steps) {
    Pos start = findStart(input);
    input[start.y][start.x] = '.';

//    for (char[] chars : input) {
//      System.out.println(new String(chars));
//    }

    return findPositionsP2(input, Set.of(start), steps, LocalTime.now()).size();
  }

  private Set<Pos> findPositions(char[][] map, Set<Pos> currentPositions, int remainingSteps) {
    if (remainingSteps == 0) return currentPositions;

    HashSet<Pos> positions = new HashSet<>();

    for (Pos pos : currentPositions) {
      if (valid(map, pos.x + 1, pos.y)) positions.add(new Pos(pos.x + 1, pos.y));
      if (valid(map, pos.x - 1, pos.y)) positions.add(new Pos(pos.x - 1, pos.y));
      if (valid(map, pos.x , pos.y + 1)) positions.add(new Pos(pos.x, pos.y + 1));
      if (valid(map, pos.x , pos.y - 1)) positions.add(new Pos(pos.x, pos.y - 1));
    }

    return findPositions(map, positions, remainingSteps - 1);
  }

  private Set<Pos> findPositionsP2(char[][] map, Set<Pos> currentPositions, int remainingSteps, LocalTime last) {
    if (remainingSteps == 0) return currentPositions;
    LocalTime now = LocalTime.now();
//    Duration expected = Duration.ofNanos((now.toNanoOfDay() - last.toNanoOfDay()) * remainingSteps);
//    System.out.println(remainingSteps + ": " + last + " => " + now + " Expected " + now.plus(expected) + " (" + DurationFormatUtils.formatDurationHMS(expected.toMillis()) + ")");

    HashSet<Pos> positions = new HashSet<>();

    for (Pos pos : currentPositions) {
      if (validP2(map, pos.x + 1, pos.y)) positions.add(new Pos(pos.x + 1, pos.y));
      if (validP2(map, pos.x - 1, pos.y)) positions.add(new Pos(pos.x - 1, pos.y));
      if (validP2(map, pos.x , pos.y + 1)) positions.add(new Pos(pos.x, pos.y + 1));
      if (validP2(map, pos.x , pos.y - 1)) positions.add(new Pos(pos.x, pos.y - 1));
    }

//    System.out.println(positions);

//    print(map, positions);

//    try {
//      Thread.sleep(1_000);
//    } catch (InterruptedException e) {
//      throw new RuntimeException(e);
//    }

    return findPositionsP2(map, positions, remainingSteps - 1, now);
  }

  private static void print(char[][] map, Set<Pos> positions) {
    for (int y = 0; y < map.length; y++) {
      for (int x = 0; x < map[y].length; x++) {
        System.out.printf("%s", positions.contains(new Pos(x, y)) ? "O" : map[y][x]);
      }
      System.out.println();
    }
  }

  private static boolean valid(char[][] map, int x, int y) {
    try {
      return map[y][x] == '.';
    } catch (Exception e) {
      return false;
    }
  }

  private static boolean validP2(char[][] map, int x, int y) {
    int y_ = y % map.length;
    if (y_ < 0) y_ += map.length;
    int x_ = x % map[0].length;
    if (x_ < 0) x_ += map[0].length;

//    if (x < 0 || x > map[0].length || y < 0 || y > map.length) {
//      System.out.printf("(%d,%d) => (%d, %d) => %s%n", x, y, x_, y_, map[y_][x_] == '.' ? "valid" : "not valid");
//      try {
//        Thread.sleep(1000);
//      } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//      }
//    }

    return map[y_][x_] == '.';
  }

  private static Pos findStart(char[][] input) {
    for (int y = 0; y < input.length; y++) {
      for (int x = 0; x < input[y].length; x++) {
        if (input[y][x] == 'S') {
          return new Pos(x, y);
        }
      }
    }
    throw new IllegalStateException();
  }

  record Pos(int x, int y){
    @Override
    public String toString() {
      return "(" + x + ", " + y + ')';
    }
  }
}
