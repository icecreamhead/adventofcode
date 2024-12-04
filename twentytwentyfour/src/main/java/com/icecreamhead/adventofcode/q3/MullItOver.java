package com.icecreamhead.adventofcode.q3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MullItOver {

  long pt1(String input) {
    return Pattern.compile("(mul\\((\\d+),(\\d+)\\))").matcher(input).results().reduce(0L, (a, b) -> a + Long.parseLong(b.group(2)) * Long.parseLong(b.group(3)), Long::sum);
  }

  long p2(String input) {
    return p2(Pattern.compile("(mul\\((\\d+),(\\d+)\\))|(do(n't)?\\(\\))").matcher(input), true);
  }

  private long p2(Matcher m, boolean e) {
    if (!m.find()) return 0;
    return switch (m.group()) {
      case "do()" -> p2(m, true);
      case "don't()" -> p2(m, false);
      default -> (e ? Long.parseLong(m.group(2)) * Long.parseLong(m.group(3)) : 0) + p2(m, e);
    };
  }
}
