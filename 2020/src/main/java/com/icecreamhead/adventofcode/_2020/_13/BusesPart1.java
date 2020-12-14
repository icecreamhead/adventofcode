package com.icecreamhead.adventofcode._2020._13;

import com.icecreamhead.adventofcode.util.InputLoader;

import java.util.Arrays;
import java.util.List;

public class BusesPart1 {

  private static final List<String> SCHEDULE = InputLoader.loadLines("_13/puzzle-input.txt");
  private static final long EARLIEST = Integer.parseInt(SCHEDULE.get(0));
  private static final int[] BUSES = Arrays.stream(SCHEDULE.get(1).split(","))
      .mapToInt(bus -> "x".equals(bus) ? Integer.MAX_VALUE : Integer.parseInt(bus)).toArray();

  public static void main(String[] args) {

    long answer = 0;
//    System.out.println(" S: " + Arrays.toString(BUSES));

    for (int t = 0; t < EARLIEST + 60; t++) {
      Boolean[] running = new Boolean[BUSES.length];

      for (int j = 0; j < BUSES.length; j++) {
        running[j] = t % BUSES[j] == 0;

        if (running[j] && t >= EARLIEST) {
          answer = BUSES[j] * (t - EARLIEST);
          System.out.printf("%d * %d = %d\n", BUSES[j], t - EARLIEST, answer);
          break;
        }
      }


      if (answer > 0) {
        break;
      }

//      System.out.println(i + ": " + Arrays.toString(Arrays.stream(running).map(b -> b != null && b ? "D " : ". ").toArray()));

    }
  }
}
