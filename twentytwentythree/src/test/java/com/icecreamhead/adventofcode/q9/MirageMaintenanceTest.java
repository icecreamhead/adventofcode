package com.icecreamhead.adventofcode.q9;

import com.icecreamhead.adventofcode.util.InputLoader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class MirageMaintenanceTest {

    private final MirageMaintenance underTest = new MirageMaintenance();

    private final List<String> sample = InputLoader.loadLines("q9/sample.txt");
    private final List<String> puzzle = InputLoader.loadLines("q9/puzzle.txt");

    @Test
    void part1_sample() {
        assertThat(underTest.part1(sample)).isEqualTo(114);
    }
    @Test
    void part1_puzzle() {
        System.out.println(underTest.part1(puzzle));
    }

    @Test
    void part2_sample() {
        assertThat(underTest.part2(sample)).isEqualTo(2);
    }
    @Test
    void part2_puzzle() {
        System.out.println(underTest.part2(puzzle));
    }

}