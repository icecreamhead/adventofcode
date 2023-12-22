package com.icecreamhead.adventofcode.q3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GearRatios {

  Set<PartNumber> partNumbers = new HashSet<>();
  Set<Symbol> symbols = new HashSet<>();
  Set<Symbol> gears = new HashSet<>();

  long part1(char[][] input) {
    init(input);

    return partNumbers.stream()
        .filter(part -> part.pos().stream().anyMatch(p -> symbols.stream().anyMatch(s -> s.pos.adjacent(p))))
        .mapToLong(PartNumber::num)
        .sum();

  }
  long part2(char[][] input) {
    init(input);

    return gears.stream()
        .mapToLong(gear -> {
          List<PartNumber> gearParts = partNumbers.stream()
              .filter(part -> part.pos.stream().anyMatch(p -> p.adjacent(gear.pos)))
              .toList();
          return gearParts.size() == 2 ? gearParts.get(0).num * gearParts.get(1).num : 0;
        })
        .sum();

  }

  private void init(char[][] input) {
    for (int y = 0; y < input.length; y++) {
      for (int x = 0; x < input[y].length; x++) {
        if (Character.isDigit(input[y][x])) {
          StringBuilder bob = new StringBuilder();
          Set<Pos> pos = new HashSet<>();
          while (x < input[y].length && Character.isDigit(input[y][x])) {
            bob.append(input[y][x]);
            pos.add(new Pos(x, y));
            x++;
          }
          partNumbers.add(new PartNumber(Long.parseLong(bob.toString()), pos));
          x--;
        } else if (!Character.isDigit(input[y][x]) && input[y][x] != '.') {
          symbols.add(new Symbol(input[y][x], new Pos(x, y)));
        }
      }
    }
    gears = symbols.stream().filter(s -> s.sym == '*').collect(Collectors.toUnmodifiableSet());
  }

  record Pos(int x, int y) {
    boolean adjacent(Pos pos) {
      return (pos.y == y || pos.y == y - 1 || pos.y == y + 1) && (pos.x == x || pos.x == x - 1 || pos.x == x + 1);
    }
  }

  record PartNumber(long num, Set<Pos> pos) {}
  record Symbol(char sym, Pos pos) {}
}
