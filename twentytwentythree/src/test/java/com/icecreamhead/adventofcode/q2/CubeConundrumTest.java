package com.icecreamhead.adventofcode.q2;

import com.icecreamhead.adventofcode.util.InputLoader;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CubeConundrumTest {

    private final CubeConundrum conundrum = new CubeConundrum();

    @Test
    void part1_sample() {
        assertThat(conundrum.part1(InputLoader.loadLines("q2/sample.txt"))).isEqualTo(8);
    }

    @Test
    void part1_puzzle() {
        System.out.println(conundrum.part1(InputLoader.loadLines("q2/puzzle.txt")));
    }

    @Test
    void part2_sample() {
        assertThat(conundrum.part2(InputLoader.loadLines("q2/sample.txt"))).isEqualTo(2286);
    }

    @Test
    void part2_puzzle() {
        System.out.println(conundrum.part2(InputLoader.loadLines("q2/puzzle.txt")));
    }
}