package com.icecreamhead.adventofcode.twenty;

public class Coord {

  static final Coord ORIGIN = new Coord(0, 0, 0);

  private final int x;
  private final int y;
  private final int z;

  public Coord(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getZ() {
    return z;
  }

  public Coord add(Coord coord) {
    return new Coord(x + coord.x, y + coord.y, z + coord.z);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Coord coord = (Coord) o;

    if (x != coord.x) return false;
    if (y != coord.y) return false;
    return z == coord.z;
  }

  @Override
  public int hashCode() {
    int result = x;
    result = 31 * result + y;
    result = 31 * result + z;
    return result;
  }

  @Override
  public String toString() {
    return "{" + x + "," + y + "," + z + '}';
  }
}
