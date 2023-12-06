package com.icecreamhead.adventofcode.q6;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class WaitForIt {

  long part1(String racesInput) {
    return solve(parseRacesPt1(racesInput));
  }

  long part2(String racesInput) {
    return solve(parseRacesPt2(racesInput));
  }

  private static long solve(Stream<Race> races) {
    return races.mapToLong(race -> {
          System.out.printf("Race (%dms): ", race.time);
          long min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
          for (int speed = 0; speed < race.time; speed++) {
            long dist = speed * (race.time - speed);
//            System.out.printf("speed=%dmm/ms, travelTime=%dms, dist=%dmm (better than record of %dmm? %s)%n", speed, (race.time - speed), dist, race.record, dist > race.record);
            if (dist > race.record && speed > max) {
              max = speed;
            }
            if (dist > race.record && speed < min) {
              min = speed;
            }
          }
          long winners = 1 + max - min;
          System.out.printf("Winning approaches = %d%n", winners);
          return winners;
        })
        .reduce(MULTIPLY)
        .orElseThrow();
  }

  private static Stream<Race> parseRacesPt1(String racesInput) {
    Tokenizers tokenizers = tokenize(racesInput);
    ArrayList<Race> races = new ArrayList<>();

    while (tokenizers.timeTokens.hasMoreTokens()) {
      races.add(new Race(Long.parseLong(tokenizers.timeTokens.nextToken()), Long.parseLong(tokenizers.distanceTokens.nextToken())));
    }

    return races.stream();
  }

  private static Stream<Race> parseRacesPt2(String racesInput) {
    String[] lines = racesInput.split("\n");
    long time = Long.parseLong(lines[0].split(":")[1].replace(" ", ""));
    long distance = Long.parseLong(lines[1].split(":")[1].replace(" ", ""));
    return Stream.of(new Race(time, distance));
  }

  private static Tokenizers tokenize(String racesInput) {
    String[] split = racesInput.split("\n");
    StringTokenizer timeTokens = new StringTokenizer(split[0], " ");
    StringTokenizer distTokens = new StringTokenizer(split[1], " ");
    timeTokens.nextToken();
    distTokens.nextToken();
    return new Tokenizers(timeTokens, distTokens);
  }

  record Race(long time, long record) {}

  record Tokenizers(StringTokenizer timeTokens, StringTokenizer distanceTokens) {}

  private static final LongBinaryOperator MULTIPLY = (a, b) -> a * b;
}
