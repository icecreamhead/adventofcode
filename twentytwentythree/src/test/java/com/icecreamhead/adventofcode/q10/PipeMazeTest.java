package com.icecreamhead.adventofcode.q10;

import com.icecreamhead.adventofcode.util.InputLoader;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class PipeMazeTest {

    private final PipeMaze underTest = new PipeMaze();

    private static final char[][] SAMPLE = InputLoader.loadGrid("q10/sample.txt");
    private static final char[][] PUZZLE = InputLoader.loadGrid("q10/puzzle.txt");
    @Test
    void part1_sample() {
        assertThat(underTest.part1(SAMPLE)).isEqualTo(8);
    }
    @Test
    void part1_puzzle() {
        System.out.println(underTest.part1(PUZZLE));
    }
}