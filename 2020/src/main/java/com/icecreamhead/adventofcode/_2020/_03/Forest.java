package com.icecreamhead.adventofcode._2020._03;

import com.icecreamhead.adventofcode.util.InputLoader;

import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Forest {

  private static final byte TREE = (byte) '#';

  private final byte[][] forest;

  public Forest(String inputFile) {
    List<String> lines = InputLoader.load(inputFile);
    int h = lines.size();
    int w = lines.get(0).length();
    forest = new byte[h][w];
    for (int i = 0; i < lines.size(); i++) {
      forest[i] = lines.get(i).getBytes(UTF_8);
    }
  }

  public Location next(Location location, int right, int down) {
    int x = location.x + right;
    int y = location.y + down;
    return new Location(x, y, y < forest.length && forest[y % forest.length][x % forest[0].length] == TREE, y >= forest.length);
  }

  public int traverse(Location location, int right, int down) {
    if (location.bottom) {
      return 0;
    }
    return traverse(next(location, right, down), right, down) + (location.tree ? 1 : 0);
  }

  static class Location {

    public static final Location START = new Location(0, 0, false, false);

    final int x;
    final int y;
    final boolean tree;
    final boolean bottom;

    private Location(int x, int y, boolean tree, boolean bottom) {
      this.x = x;
      this.y = y;
      this.tree = tree;
      this.bottom = bottom;
    }

    @Override
    public String toString() {
      return "Location{x=" + x + ", y=" + y + ", tree=" + tree + ", bottom=" + bottom + '}';
    }
  }
}
