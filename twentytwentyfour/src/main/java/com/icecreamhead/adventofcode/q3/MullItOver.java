package com.icecreamhead.adventofcode.q3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MullItOver {

  long pt1(String input) {
    return pt1(Pattern.compile("(mul\\((\\d+),(\\d+)\\))").matcher(input));
  }

  private long pt1(Matcher matcher) {
    return matcher.find() ? Long.parseLong(matcher.group(2)) * Long.parseLong(matcher.group(3)) + pt1(matcher) : 0;
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
