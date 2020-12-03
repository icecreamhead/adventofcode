package com.icecreamhead.adventofcode.twenty;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.icecreamhead.adventofcode.twenty.Coord.ORIGIN;

public class Particle {

  private static final Pattern PATTERN = Pattern.compile("p=<(.*),(.*),(.*)>, v=<(.*),(.*),(.*)>, a=<(.*),(.*),(.*)>");

  private final Coord p;
  private final Coord v;
  private final Coord a;

  Particle(Coord p, Coord v, Coord a) {
    this.p = p;
    this.v = v;
    this.a = a;
  }

  static Particle parse(String input) {
    Matcher m = PATTERN.matcher(input.trim());

    if (!m.matches()) {
      // Don't remove this. It is required to actually do the matching. Obviously.
      System.err.println("Line can't be parsed: '" + input + "'");
      throw new IllegalStateException();
    }

    int px = groupToInt(m, 1);
    int py = groupToInt(m, 2);
    int pz = groupToInt(m, 3);
    int vx = groupToInt(m, 4);
    int vy = groupToInt(m, 5);
    int vz = groupToInt(m, 6);
    int ax = groupToInt(m, 7);
    int ay = groupToInt(m, 8);
    int az = groupToInt(m, 9);

    return new Particle(new Coord(px, py, pz), new Coord(vx, vy, vz), new Coord(ax, ay, az));
  }

  public Coord getP() {
    return p;
  }

  public Coord getV() {
    return v;
  }

  public Coord getA() {
    return a;
  }

  public int distanceFromOrigin() {
    return manhattan(ORIGIN, p);
  }

  public int acceleration() {
    return manhattan(ORIGIN, a);
  }

  public static int manhattan(Coord c1, Coord c2) {
    int val = Math.abs(c1.getX() - c2.getX()) + Math.abs(c1.getY() - c2.getY()) + Math.abs(c1.getZ() - c2.getZ());
    if (val > 2000000000) {
      throw new IllegalStateException();
    }
    return val;
  }

  public Particle next() {
    return new Particle(nextP(), nextV(), a);
  }

  private Coord nextP() {
    return p.add(v);
  }

  private Coord nextV() {
    return v.add(a);
  }

  private static int groupToInt(Matcher m, int group) {
    return Integer.parseInt(m.group(group).trim());
  }

  @Override
  public String toString() {
    return "Particle{" +
        "p=" + p +
        ", v=" + v +
        ", a=" + a +
        '}';
  }
}
