package com.icecreamhead.adventofcode.q3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MullItOver {

  long pt1(String input) {
    Matcher matcher = Pattern.compile("(mul\\(\\d+,\\d+\\))").matcher(input);
    long out = 0;
    while (matcher.find()) {
      long x = Integer.parseInt(matcher.group().substring(4, matcher.group().indexOf(",")));
      long y = Integer.parseInt(matcher.group().substring(matcher.group().indexOf(",") + 1, matcher.group().indexOf(")")));
      out += x * y;
    }
    return out;
  }

  long pt2(String input) {
    Matcher matcher = Pattern.compile("(mul\\(\\d+,\\d+\\))|(do\\(\\))|(don't\\(\\))").matcher(input);
    long out = 0;
    boolean enabled = true;
    while (matcher.find()) {
      System.out.println(matcher.group());
      switch (matcher.group()) {
        case "do()" -> enabled = true;
        case "don't()" -> enabled = false;
        default -> {
          if (!enabled) continue;
          long x = Integer.parseInt(matcher.group().substring(4, matcher.group().indexOf(",")));
          long y = Integer.parseInt(matcher.group().substring(matcher.group().indexOf(",") + 1, matcher.group().indexOf(")")));
          out += x * y;
        }
      }
    }
    return out;
  }
}
