package com.icecreamhead.adventofcode.eleven;

public class HexRunner {

  private final Hexes hexes = new Hexes();

  public final int distance(String input) {
    for (String s : input.split(",")) {
      hexes.add(Hexes.Direction.valueOf(s.toUpperCase()));
    }
    return hexes.getDistance();
  }

  public final int furthest(String input) {
    for (String s : input.split(",")) {
      hexes.add(Hexes.Direction.valueOf(s.toUpperCase()));
    }
    return hexes.getFurthest();
  }
}
