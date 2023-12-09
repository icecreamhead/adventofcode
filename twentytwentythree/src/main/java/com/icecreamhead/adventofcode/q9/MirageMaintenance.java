package com.icecreamhead.adventofcode.q9;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MirageMaintenance {

    long part1(List<String> input) {
        return input.stream()
                .map(line -> {
                    StringTokenizer tokenizer = new StringTokenizer(line, " ");
                    ArrayList<Long> numbers = new ArrayList<>();
                    while (tokenizer.hasMoreTokens()) {
                        numbers.add(Long.parseLong(tokenizer.nextToken()));
                    }
                    return numbers;
                })
                .mapToLong(MirageMaintenance::nextVal)
                .sum();
    }

    private static long nextVal(List<Long> vals) {
        if (vals.stream().allMatch(x -> x == 0))
            return 0;

        ArrayList<Long> diffs = new ArrayList<>();

        for (int i = 0; i < vals.size() - 1; i++) {
            diffs.add(vals.get(i + 1) - vals.get(i));
        }

        return vals.get(vals.size() - 1) + nextVal(diffs);
    }

    long part2(List<String> input) {
        return input.stream()
                .map(line -> {
                    StringTokenizer tokenizer = new StringTokenizer(line, " ");
                    ArrayList<Long> numbers = new ArrayList<>();
                    while (tokenizer.hasMoreTokens()) {
                        numbers.add(Long.parseLong(tokenizer.nextToken()));
                    }
                    return numbers;
                })
                .mapToLong(MirageMaintenance::prevVal)
                .sum();
    }

    private static long prevVal(List<Long> vals) {
        if (vals.stream().allMatch(x -> x == 0))
            return 0;

        ArrayList<Long> diffs = new ArrayList<>();

        for (int i = 0; i < vals.size() - 1; i++) {
            diffs.add(vals.get(i + 1) - vals.get(i));
        }

        return vals.get(0) - prevVal(diffs);
    }
}
