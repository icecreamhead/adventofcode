package com.icecreamhead.adventofcode.q2;

import static java.lang.Math.abs;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class RedNosedReports {

  long pt1(List<String> input) {
    return input.stream()
        .filter(reports -> safe(reports, true))
        .count();
  }

  long pt2(List<String> input) {
    return input.stream()
        .filter(reports -> safe(reports, false))
        .count();
  }

  private boolean safe(String reports, boolean damped) {
    int[] l = Arrays.stream(reports.split(" ")).mapToInt(Integer::parseInt).toArray();
    boolean inc = l[1] > l[0];

    for (int i = 0; i < l.length; i++) {
      if (i == l.length - 1) continue;
      int diff = abs(l[i + 1] - l[i]);
      boolean up = l[i + 1] > l[i];
      if (diff == 0 || diff > 3 || up != inc) {
        System.out.printf("Reject: %s%n", Arrays.toString(l));
        if (!damped) {
          for (int j = 0; j < l.length; j++) {
            StringJoiner bob = new StringJoiner(" ");
            for (int k = 0; k < l.length; k++) {
              if (j != k) bob.add(String.valueOf(l[k]));
            }
            System.out.printf("Trying: %s%n", bob);
            if (safe(bob.toString(), true)) {
              return true;
            }
          }
        }
        return false;
      }
    }

    System.out.printf("Accept: %s%n", Arrays.toString(l));

    return true;
  }
}
