package com.icecreamhead.adventofcode.q7;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.BiFunction;

public class BridgeRepair {

  long pt1(List<String> input) {
    return eval(input, Set.of(add, mul));
  }

  long pt2(List<String> input) {
    return eval(input, Set.of(add, mul, cat));
  }

  private long eval(List<String> input, Set<BiFunction<Long, Long, Long>> operators) {
    return input.stream()
        .map(in -> Collections.list(new StringTokenizer(in, ": ")).stream().mapToLong(a -> Long.parseLong((String) a)).toArray())
        .filter(in -> operators.stream().anyMatch(o -> recursiveFind(o, in[1], in[2], in, 3, in[0], operators)))
        .mapToLong(a -> a[0])
        .sum();
  }

  private boolean recursiveFind(BiFunction<Long, Long, Long> op, long x, long y, long[] tail, int nextIdx, long expected, Set<BiFunction<Long, Long, Long>> ops) {
    long z = op.apply(x, y);
    if (z > expected) return false;
    if (nextIdx == tail.length) return z == expected;
    return ops.stream().anyMatch(o -> recursiveFind(o, z, tail[nextIdx], tail, nextIdx + 1, expected, ops));
  }

  private static final BiFunction<Long, Long, Long> add = Long::sum;
  private static final BiFunction<Long, Long, Long> mul = (Long x, Long y) -> x * y;
  private static final BiFunction<Long, Long, Long> cat = (Long x, Long y) -> Long.parseLong("" + x + y);
}
