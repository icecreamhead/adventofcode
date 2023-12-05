package com.icecreamhead.adventofcode.q5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Fertilizer {

  Almanac buildAlmanacPart1(List<String> lines) {
    List<Seed> seeds = new ArrayList<>();
    Map<String, List<Mapping>> mappings = new HashMap<>();

    String m = null;
    for (String line : lines) {
      if (line.isBlank()) {
        continue;
      }
      StringTokenizer tokenizer = new StringTokenizer(line, " ");
      String firstT = tokenizer.nextToken();
      if (firstT.equals("seeds:")) {
        while (tokenizer.hasMoreTokens()) {
          long s = Long.parseLong(tokenizer.nextToken());
          seeds.add(new Seed(s, s+1));
        }

      } else if (firstT.contains("-")) {
        m = firstT;
        mappings.put(m, new ArrayList<>());
      } else if (firstT.matches("\\d+")) {
        long destStart = Long.parseLong(firstT);
        long sourceStart = Long.parseLong(tokenizer.nextToken());
        long length = Long.parseLong(tokenizer.nextToken());

        List<Mapping> mapMappings = mappings.get(m);
        mapMappings.add(new Mapping(sourceStart, sourceStart + length, destStart - sourceStart));

      } else {
        throw new IllegalStateException(firstT);
      }
    }

    return new Almanac(seeds, mappings);
  }

  long part1(List<String> lines) {

    Almanac almanac = buildAlmanacPart1(lines);
    System.out.println(almanac);

    return almanac.closestLocation();
  }

  Almanac buildAlmanacPart2(List<String> lines) {
    List<Seed> seeds = new ArrayList<>();
    Map<String, List<Mapping>> mappings = new HashMap<>();

    String m = null;
    for (String line : lines) {
      if (line.isBlank()) {
        continue;
      }
      StringTokenizer tokenizer = new StringTokenizer(line, " ");
      String firstT = tokenizer.nextToken();
      if (firstT.equals("seeds:")) {
        while (tokenizer.hasMoreTokens()) {
          String t1 = tokenizer.nextToken();
//          System.out.println(t1);
          long s1 = Long.parseLong(t1);
          String t2 = tokenizer.nextToken();
//          System.out.println(t2);
          long s2 = Long.parseLong(t2);
          seeds.add(new Seed(s1, s1 + s2));
        }

      } else if (firstT.contains("-")) {
        m = firstT;
        mappings.put(m, new ArrayList<>());
      } else if (firstT.matches("\\d+")) {
        long destStart = Long.parseLong(firstT);
        long sourceStart = Long.parseLong(tokenizer.nextToken());
        long length = Long.parseLong(tokenizer.nextToken());

        List<Mapping> mapMappings = mappings.get(m);
        mapMappings.add(new Mapping(sourceStart, sourceStart + length, destStart - sourceStart));

      } else {
        throw new IllegalStateException(firstT);
      }
    }

    return new Almanac(seeds, mappings);
  }

  public long part2(List<String> strings) {
    return buildAlmanacPart2(strings).closestLocation();
  }

  record Almanac (List<Seed> seeds, Map<String, List<Mapping>> mappings){

    public long closestLocation() {
      return seeds.stream()
          .flatMap(seed -> Stream.iterate(seed.rangeStart, s -> s < seed.rangeEnd, s -> s + 1).parallel())
          .parallel()
          .mapToLong(seed -> {
//            System.out.printf("%d, ", seed);
            long soil = mappings.get("seed-to-soil").stream().filter(m -> seed >= m.sourceMin && seed < m.sourceMax).findAny().map(m -> seed + m.diff).orElse(seed);
//            System.out.printf("%d, ", soil);
            long fert = mappings.get("soil-to-fertilizer").stream().filter(m -> soil >= m.sourceMin && soil < m.sourceMax).findAny().map(m -> soil + m.diff).orElse(soil);
//            System.out.printf("%d, ", fert);
            long water = mappings.get("fertilizer-to-water").stream().filter(m -> fert >= m.sourceMin && fert < m.sourceMax).findAny().map(m -> fert + m.diff).orElse(fert);
//            System.out.printf("%d, ", water);
            long light = mappings.get("water-to-light").stream().filter(m -> water >= m.sourceMin && water < m.sourceMax).findAny().map(m -> water + m.diff).orElse(water);
//            System.out.printf("%d, ", light);
            long temp = mappings.get("light-to-temperature").stream().filter(m -> light >= m.sourceMin && light < m.sourceMax).findAny().map(m -> light + m.diff).orElse(light);
//            System.out.printf("%d, ", temp);
            long humidity = mappings.get("temperature-to-humidity").stream().filter(m -> temp >= m.sourceMin && temp < m.sourceMax).findAny().map(m -> temp + m.diff).orElse(temp);
//            System.out.printf("%d, ", humidity);
            long loc = mappings.get("humidity-to-location").stream().filter(m -> humidity >= m.sourceMin && humidity < m.sourceMax).findAny().map(m -> humidity + m.diff).orElse(humidity);
//            System.out.printf("%d%n", loc);
            return loc;
          })
          .min()
          .orElseThrow();
    }
  }
  record Mapping(long sourceMin, long sourceMax, long diff){}
  record Seed(long rangeStart, long rangeEnd){}
}
