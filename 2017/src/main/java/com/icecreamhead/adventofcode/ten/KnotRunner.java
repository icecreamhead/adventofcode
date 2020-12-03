package com.icecreamhead.adventofcode.ten;

public class KnotRunner {

  private final Knot knot;

  public KnotRunner(int size) {
    this.knot = new Knot(size);
  }

  public void runOnce(String in) {
    for (String s : in.split(",")) {
      knot.round(Integer.parseInt(s));
    }
  }

  public String runN(String in, int rounds) {
    for (int i = 0; i < rounds; i++) {
      in.chars().forEach(c -> {
//        System.out.println("\nASCII: " + ((char) c) + "=" + c);
        knot.round(c);
      });
      for (int j : new int[]{17, 31, 73, 47, 23}) {
//        System.out.println("\nSuffix: " + j);
        knot.round(j);
      }
    }
    int[] dense = knot.dense();
//    System.out.println("\nDense: " + Arrays.toString(dense));
    return hash(dense);
  }

  static String hash(int[] dense) {
    StringBuilder bob = new StringBuilder();
    for (int i : dense) {
      String s = Integer.toHexString(i);
      if (s.length() == 1) s = "0" + s;
      bob.append(s);
    }
//    System.out.println("Hash: " + bob.toString());
    return bob.toString();
  }

  int output() {
    return knot.output();
  }
}
