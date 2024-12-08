package com.icecreamhead.adventofcode.q7;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class BridgeRepair {

    long pt1(List<String> input) {
        var ops = Set.of(add, mul);
        return input.stream()
                .mapToLong(l -> {
                    long expected = Long.parseLong(l.split(":")[0].strip());
                    long[] vs = Arrays.stream(l.split(":")[1].strip().split(" ")).mapToLong(Long::parseLong).toArray();
                    if (ops.stream().anyMatch(o -> recursiveFind(o, vs[0], vs[1], vs, 2, expected, ops))) {
                        return expected;
                    }
                    return 0;
                })
                .sum();
    }

    long pt2(List<String> input) {
        var ops = Set.of(add, mul, cat);
        return input.stream()
                .mapToLong(l -> {
                    long expected = Long.parseLong(l.split(":")[0].strip());
                    long[] vs = Arrays.stream(l.split(":")[1].strip().split(" ")).mapToLong(Long::parseLong).toArray();
                    if (ops.stream().anyMatch(o -> recursiveFind(o, vs[0], vs[1], vs, 2, expected, ops))) {
                        return expected;
                    }
                    return 0;
                })
                .sum();
    }

    private boolean recursiveFind(BiFunction<Long, Long, Long> op, long x, long y, long[] tail, int nextIdx, long expected, Set<BiFunction<Long, Long, Long>> ops) {
        long z = op.apply(x, y);
        if (z > expected) return false;
        if (nextIdx == tail.length) {
            return z == expected;
        }
        return ops.stream().anyMatch(o -> recursiveFind(o, z, tail[nextIdx], tail, nextIdx + 1, expected, ops));
    }

    private static final BiFunction<Long, Long, Long> add = Long::sum;
    private static final BiFunction<Long, Long, Long> mul = (Long x, Long y) -> x * y;
    private static final BiFunction<Long, Long, Long> cat = (Long x, Long y) -> Long.parseLong("" + x + y);
}
