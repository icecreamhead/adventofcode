package com.icecreamhead.adventofcode._2020._03;

import java.util.List;

public class TobogganSlide {

  private static final String INPUT = "_03/puzzle-input.txt";

  public static void main(String[] args) {

    Forest forest = new Forest(INPUT);

    List<Coord> coords = List.of(
        new Coord(1, 1),
        new Coord(3, 1),
        new Coord(5, 1),
        new Coord(7, 1),
        new Coord(1, 2)
    );

    long total = coords.stream()
        .mapToLong(c -> forest.traverse(Forest.Location.START, c.x, c.y))
        .reduce((x, y) -> x * y)
        .getAsLong();

    System.out.println(total);
  }

  static class Coord {
    private final int x;
    private final int y;

    public Coord(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
