package com.icecreamhead.adventofcode.q13;

import static com.icecreamhead.adventofcode.q13.PointOfIncidence.Direction.H;
import static com.icecreamhead.adventofcode.q13.PointOfIncidence.Direction.V;
import static com.icecreamhead.adventofcode.util.InputLoader.transpose;

import java.util.Arrays;
import java.util.List;

public class PointOfIncidence {

  long part1(List<char[][]> patterns) {
    return patterns.stream()
        .mapToLong(pattern -> {
          for (char[] chars : pattern) {
            System.out.println(new String(chars));
          }

          // look for horizontal reflection
          for (int i = 0; i < pattern.length - 1; i++) {
            if (Arrays.equals(pattern[i], pattern[i + 1])) {
              if (isHorizontalReflection(pattern, i)) {
                System.out.println(100L * (i + 1));
                return 100L * (i + 1);
              }
            }
          }

          // look for vertical reflection by transposing
          char[][] transposed = transpose(pattern);
          for (int i = 0; i < transposed.length - 1; i++) {
            if (Arrays.equals(transposed[i], transposed[i + 1])) {
              if (isHorizontalReflection(transposed, i)) {
                System.out.println(i + 1);
                return i + 1;
              }
            }
          }

          throw new IllegalStateException();
        })
        .sum();
  }

  private PrevReflection part1Reflection(char[][] pattern) {
    // look for horizontal reflection
    for (int i = 0; i < pattern.length - 1; i++) {
      if (Arrays.equals(pattern[i], pattern[i + 1])) {
        if (isHorizontalReflection(pattern, i)) {
          return new PrevReflection(H, i);
        }
      }
    }

    // look for vertical reflection by transposing
    char[][] transposed = transpose(pattern);
    for (int i = 0; i < transposed.length - 1; i++) {
      if (Arrays.equals(transposed[i], transposed[i + 1])) {
        if (isHorizontalReflection(transposed, i)) {
          return new PrevReflection(V, i);
        }
      }
    }
    throw new IllegalStateException();
  }

  long part2(List<char[][]> patterns) {
    return patterns.stream()
        .mapToLong(pattern -> {
          System.out.println("before");
          for (char[] chars : pattern) {
            System.out.println(new String(chars));
          }
          PrevReflection prev = part1Reflection(pattern);
          System.out.println(prev);

          for (int y = 0; y < pattern.length; y++) {
            for (int x = 0; x < pattern[y].length; x++) {

              pattern[y][x] = pattern[y][x] == '#' ? '.' : '#';
              System.out.println("after ("+x+","+y+")");
              for (char[] chars : pattern) {
                System.out.println(new String(chars));
              }

              // look for horizontal reflection
              for (int i = 0; i < pattern.length - 1; i++) {
                if (Arrays.equals(pattern[i], pattern[i + 1])) {
                  if (isHorizontalReflection(pattern, i) && !(prev.d == H && prev.idx == i)) {
                    System.out.println("horizontal " +i + ": " + (100L * (i + 1)));
                    return 100L * (i + 1);
                  }
                }
              }

              // look for vertical reflection by transposing
              char[][] transposed = transpose(pattern);
              for (int i = 0; i < transposed.length - 1; i++) {
                if (Arrays.equals(transposed[i], transposed[i + 1])) {
                  if (isHorizontalReflection(transposed, i) && !(prev.d == V && prev.idx == i)) {
                    System.out.println("vertical " +i + ": " +(i + 1));
                    return i + 1;
                  }
                }
              }

              pattern[y][x] = pattern[y][x] == '#' ? '.' : '#';
            }
          }

          throw new IllegalStateException();
        })
        .sum();
  }

  private static boolean isHorizontalReflection(char[][] pattern, int i) {
    int j = i + 1;
    assert Arrays.equals(pattern[i], pattern[j]);

    while (i >= 0 && j < pattern.length) {
      if (!Arrays.equals(pattern[i], pattern[j])) {
        return false;
      }
      i--; j++;
    }

    return true;
  }

  record PrevReflection(Direction d, int idx){}
  enum Direction { H, V }
}
